import {useAnalytics} from '@/shared/hooks/useAnalytics';
import {ActionDefinitionApi, ComponentDefinition} from '@/shared/middleware/platform/configuration';
import {ActionDefinitionKeys} from '@/shared/queries/platform/actionDefinitions.queries';
import {WorkflowNodeOutputKeys} from '@/shared/queries/platform/workflowNodeOutputs.queries';
import {ClickedOperationType, NodeDataType, PropertyAllType} from '@/shared/types';
import {getRandomId} from '@/shared/util/random-utils';
import {Component1Icon} from '@radix-ui/react-icons';
import {useQueryClient} from '@tanstack/react-query';
import {ComponentIcon} from 'lucide-react';
import InlineSVG from 'react-inlinesvg';
import {useReactFlow} from 'reactflow';

import {useWorkflowMutation} from '../providers/workflowMutationProvider';
import useWorkflowDataStore from '../stores/useWorkflowDataStore';
import useWorkflowNodeDetailsPanelStore from '../stores/useWorkflowNodeDetailsPanelStore';
import getFormattedName from '../utils/getFormattedName';
import getParametersWithDefaultValues from '../utils/getParametersWithDefaultValues';
import handleConditionChildOperationClick from '../utils/handleConditionChildOperationClick';
import saveWorkflowDefinition from '../utils/saveWorkflowDefinition';

interface WorkflowNodesPopoverMenuOperationListProps {
    componentDefinition: ComponentDefinition;
    conditionId?: string;
    edge?: boolean;
    setPopoverOpen: (open: boolean) => void;
    sourceNodeId: string;
    trigger?: boolean;
}

const WorkflowNodesPopoverMenuOperationList = ({
    componentDefinition,
    conditionId,
    edge,
    setPopoverOpen,
    sourceNodeId,
    trigger,
}: WorkflowNodesPopoverMenuOperationListProps) => {
    const {setLatestComponentDefinition, setWorkflow, workflow} = useWorkflowDataStore();
    const {currentNode, setCurrentComponent, setCurrentNode} = useWorkflowNodeDetailsPanelStore();

    const {captureComponentUsed} = useAnalytics();

    const {getEdge, getNode, getNodes, setEdges, setNodes} = useReactFlow();

    const {updateWorkflowMutation} = useWorkflowMutation();

    const queryClient = useQueryClient();

    const {componentNames} = workflow;

    const {actions, icon, name, title, triggers, version} = componentDefinition;

    const operations = trigger ? triggers : actions;

    const handleOperationClick = async (clickedOperation: ClickedOperationType) => {
        if (!componentDefinition) {
            return;
        }

        const {componentLabel, componentName, icon, operationName, version} = clickedOperation;

        setLatestComponentDefinition(componentDefinition);

        if (trigger) {
            captureComponentUsed(componentName, undefined, operationName);

            const newTriggerNodeData: NodeDataType = {
                componentName: componentName,
                icon: (
                    <>
                        {icon ? (
                            <InlineSVG className="size-9 text-gray-700" src={icon} />
                        ) : (
                            <Component1Icon className="size-9 text-gray-700" />
                        )}
                    </>
                ),
                label: componentLabel,
                metadata: undefined,
                name: 'trigger_1',
                operationName: operationName,
                parameters: undefined,
                trigger: true,
                type: `${componentName}/v${version}/${operationName}`,
                version: version,
                workflowNodeName: 'trigger_1',
            };

            saveWorkflowDefinition({
                nodeData: newTriggerNodeData,
                onSuccess: () => {
                    queryClient.invalidateQueries({
                        queryKey: WorkflowNodeOutputKeys.filteredPreviousWorkflowNodeOutputs({
                            id: workflow.id!,
                            lastWorkflowNodeName: currentNode?.name,
                        }),
                    });

                    setWorkflow({
                        ...workflow,
                        componentNames: [componentName, ...componentNames.slice(1)],
                    });

                    if (currentNode?.trigger) {
                        setCurrentNode({
                            ...currentNode,
                        });
                    }

                    if (trigger) {
                        setCurrentComponent({
                            componentName: newTriggerNodeData.componentName,
                            notes: newTriggerNodeData.description,
                            operationName: newTriggerNodeData.operationName,
                            title: newTriggerNodeData.label,
                            type: newTriggerNodeData.type,
                            workflowNodeName: newTriggerNodeData.workflowNodeName ?? 'trigger_1',
                        });
                    }
                },
                queryClient,
                updateWorkflowMutation,
                workflow,
            });

            return;
        }

        const getActionDefinitionRequest = {
            actionName: clickedOperation.operationName,
            componentName: clickedOperation.componentName,
            componentVersion: componentDefinition.version,
        };

        const clickedComponentActionDefinition = await queryClient.fetchQuery({
            queryFn: () => new ActionDefinitionApi().getComponentActionDefinition(getActionDefinitionRequest),
            queryKey: ActionDefinitionKeys.actionDefinition(getActionDefinitionRequest),
        });

        if (edge) {
            const clickedEdge = getEdge(sourceNodeId);

            if (!clickedEdge) {
                return;
            }

            captureComponentUsed(componentName, operationName, undefined);

            const nodes = getNodes();

            const workflowNodeName = getFormattedName(clickedOperation.componentName!, nodes);

            const newWorkflowNode = {
                data: {
                    componentName: clickedOperation.componentName,
                    icon: clickedOperation.icon && (
                        <InlineSVG
                            className="size-9"
                            loader={<ComponentIcon className="size-9" />}
                            src={clickedOperation.icon}
                        />
                    ),
                    label: clickedOperation.componentLabel,
                    metadata: {},
                    name: workflowNodeName,
                    type: clickedOperation.type,
                    workflowNodeName,
                },
                id: getRandomId(),
                position: {
                    x: 0,
                    y: 0,
                },
                type: 'workflow',
            };

            const sourceEdge = {
                id: `${clickedEdge.source}->${newWorkflowNode.id}`,
                source: clickedEdge.source,
                sourceHandle: clickedEdge.sourceHandle,
                target: newWorkflowNode.id,
                type: 'workflow',
            };

            const targetEdge = {
                id: `${newWorkflowNode.id}->${clickedEdge.target}`,
                source: newWorkflowNode.id,
                sourceHandle: clickedEdge.sourceHandle,
                target: clickedEdge.target,
                type: 'workflow',
            };

            setNodes((nodes) => {
                const previousWorkflowNode = nodes.find((node) => node.id === clickedEdge.source);

                const previousComponentNameIndex = componentNames.findIndex(
                    (name) => name === previousWorkflowNode?.data.componentName
                );

                const tempComponentNames = [...componentNames];

                tempComponentNames.splice(previousComponentNameIndex + 1, 0, newWorkflowNode.data.componentName);

                setWorkflow({
                    ...workflow,
                    componentNames: tempComponentNames,
                    nodeNames: [...workflow.nodeNames, newWorkflowNode.data.name],
                });

                const previousWorkflowNodeIndex = nodes.findIndex((node) => node.id === clickedEdge.source);

                const tempNodes = [...nodes];

                tempNodes.splice(previousWorkflowNodeIndex + 1, 0, newWorkflowNode);

                const previousWorkflowTaskIndex = workflow.tasks?.findIndex((task) => task.name === clickedEdge.source);

                saveWorkflowDefinition({
                    nodeData: {
                        ...newWorkflowNode.data,
                        parameters: getParametersWithDefaultValues({
                            properties: clickedComponentActionDefinition?.properties as Array<PropertyAllType>,
                        }),
                    },
                    nodeIndex: (previousWorkflowTaskIndex ?? 0) + 1,
                    onSuccess: () => {
                        queryClient.invalidateQueries({
                            queryKey: WorkflowNodeOutputKeys.filteredPreviousWorkflowNodeOutputs({
                                id: workflow.id!,
                                lastWorkflowNodeName: currentNode?.name,
                            }),
                        });
                    },
                    queryClient,
                    updateWorkflowMutation,
                    workflow,
                });

                return tempNodes;
            });

            setEdges((edges) => edges.filter((edge) => edge.id !== sourceNodeId).concat([sourceEdge, targetEdge]));
        } else {
            if (conditionId) {
                const nodes = getNodes();

                handleConditionChildOperationClick({
                    componentNames,
                    conditionId,
                    currentNode,
                    nodes,
                    operation: clickedOperation,
                    operationDefinition: clickedComponentActionDefinition,
                    placeholderId: sourceNodeId,
                    queryClient,
                    setNodes,
                    setWorkflow,
                    updateWorkflowMutation,
                    workflow,
                });

                setPopoverOpen(false);

                captureComponentUsed(componentName, operationName, undefined);

                return;
            }

            const placeholderNode = getNode(sourceNodeId);

            if (!placeholderNode) {
                return;
            }

            const placeholderId = placeholderNode.id;

            captureComponentUsed(componentName, operationName, undefined);

            const childPlaceholderId = getRandomId();

            const childPlaceholderNode = {
                data: {label: '+'},
                id: childPlaceholderId,
                position: {
                    x: 0,
                    y: 0,
                },
                style: {
                    zIndex: 9999,
                },
                type: 'placeholder',
            };

            setNodes((nodes) =>
                nodes
                    .map((node) => {
                        if (node.id !== placeholderId) {
                            return node;
                        }

                        const workflowNodeName = getFormattedName(clickedOperation.componentName!, nodes);

                        const newWorkflowNodeData = {
                            componentName: clickedOperation.componentName,
                            icon: clickedOperation.icon && (
                                <InlineSVG
                                    className="size-9"
                                    loader={<ComponentIcon className="size-9" />}
                                    src={clickedOperation.icon}
                                />
                            ),
                            label: clickedOperation.componentLabel,
                            name: workflowNodeName,
                            type: clickedOperation.type,
                            workflowNodeName,
                        };

                        setWorkflow({
                            ...workflow,
                            componentNames: [...componentNames, clickedOperation.componentName],
                            nodeNames: [...workflow.nodeNames, workflowNodeName],
                        });

                        let taskNodeIndex: number | undefined = undefined;

                        if (sourceNodeId.includes('bottom-placeholder')) {
                            const sourceNodeIndex = getNodes().findIndex((node) => node.id === sourceNodeId);

                            const nextNode = getNodes()[sourceNodeIndex + 1];

                            taskNodeIndex = workflow.tasks?.findIndex((task) => task.name === nextNode.id);
                        }

                        saveWorkflowDefinition({
                            nodeData: {
                                ...newWorkflowNodeData,
                                parameters: getParametersWithDefaultValues({
                                    properties: clickedComponentActionDefinition?.properties as Array<PropertyAllType>,
                                }),
                            },
                            nodeIndex: taskNodeIndex,
                            onSuccess: () => {
                                queryClient.invalidateQueries({
                                    queryKey: WorkflowNodeOutputKeys.filteredPreviousWorkflowNodeOutputs({
                                        id: workflow.id!,
                                        lastWorkflowNodeName: currentNode?.name,
                                    }),
                                });
                            },
                            queryClient,
                            updateWorkflowMutation,
                            workflow,
                        });

                        return {
                            ...node,
                            data: newWorkflowNodeData,
                            type: 'workflow',
                        };
                    })
                    .concat([childPlaceholderNode])
            );
        }
    };

    return (
        <div className="flex w-workflow-nodes-popover-actions-menu-width flex-col rounded-r-lg border-l">
            <header className="flex items-center space-x-2 rounded-tr-lg bg-white px-3 py-1.5">
                {icon ? (
                    <InlineSVG className="size-8" loader={<ComponentIcon className="size-8" />} src={icon} />
                ) : (
                    <ComponentIcon className="size-8" />
                )}

                <div className="flex w-full flex-col">
                    <h2 className="text-lg font-semibold">{title}</h2>

                    <h3 className="text-sm text-muted-foreground">{trigger ? 'Triggers' : 'Actions'}</h3>
                </div>
            </header>

            <ul className="h-96 space-y-2 overflow-scroll rounded-br-lg bg-muted p-3">
                {operations?.map((operation) => (
                    <li
                        className="cursor-pointer space-y-1 rounded border-2 border-transparent bg-white px-2 py-1 hover:border-blue-200"
                        key={operation.name}
                        onClick={() => {
                            handleOperationClick({
                                componentLabel: title,
                                componentName: name,
                                icon: icon,
                                operationName: operation.name,
                                type: `${name}/v${version}/${operation.name}`,
                                version: version,
                            });
                        }}
                    >
                        <h3 className="text-sm">{operation.title}</h3>

                        <p className="text-xs text-muted-foreground">{operation.description}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default WorkflowNodesPopoverMenuOperationList;
