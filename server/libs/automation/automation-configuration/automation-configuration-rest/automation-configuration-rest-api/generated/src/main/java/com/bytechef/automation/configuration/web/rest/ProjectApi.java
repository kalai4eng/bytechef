/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.automation.configuration.web.rest;

import com.bytechef.automation.configuration.web.rest.model.ProjectModel;
import com.bytechef.automation.configuration.web.rest.model.ProjectStatusModel;
import com.bytechef.automation.configuration.web.rest.model.ProjectVersionModel;
import com.bytechef.automation.configuration.web.rest.model.PublishProjectRequestModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-30T07:20:52.343251+02:00[Europe/Zagreb]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "project", description = "The Automation Project Internal API")
public interface ProjectApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /projects : Create a new project.
     * Create a new project.
     *
     * @param projectModel  (required)
     * @return The project object. (status code 200)
     */
    @Operation(
        operationId = "createProject",
        summary = "Create a new project.",
        description = "Create a new project.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The project object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/projects",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<ProjectModel> createProject(
        @Parameter(name = "ProjectModel", description = "", required = true) @Valid @RequestBody ProjectModel projectModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /projects/{id} : Delete a project.
     * Delete a project.
     *
     * @param id The id of a project. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "deleteProject",
        summary = "Delete a project.",
        description = "Delete a project.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/projects/{id}"
    )
    
    default ResponseEntity<Void> deleteProject(
        @Parameter(name = "id", description = "The id of a project.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /projects/{id}/duplicate : Duplicates existing project.
     * Duplicates existing project.
     *
     * @param id The id of a project. (required)
     * @return The duplicated project object. (status code 200)
     */
    @Operation(
        operationId = "duplicateProject",
        summary = "Duplicates existing project.",
        description = "Duplicates existing project.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The duplicated project object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/projects/{id}/duplicate",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ProjectModel> duplicateProject(
        @Parameter(name = "id", description = "The id of a project.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /projects/{id} : Get a project by id.
     * Get a project by id.
     *
     * @param id The id of a project. (required)
     * @return The project object. (status code 200)
     */
    @Operation(
        operationId = "getProject",
        summary = "Get a project by id.",
        description = "Get a project by id.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The project object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/projects/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ProjectModel> getProject(
        @Parameter(name = "id", description = "The id of a project.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /projects/{id}/versions : Get a project versions.
     * Get a project versions.
     *
     * @param id The id of a project. (required)
     * @return The list of project version objects. (status code 200)
     */
    @Operation(
        operationId = "getProjectVersions",
        summary = "Get a project versions.",
        description = "Get a project versions.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of project version objects.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProjectVersionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/projects/{id}/versions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ProjectVersionModel>> getProjectVersions(
        @Parameter(name = "id", description = "The id of a project.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"description\" : \"description\", \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"version\" : 0 }, { \"description\" : \"description\", \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"version\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /projects : Get projects.
     * Get projects.
     *
     * @param categoryId The category id used for filtering projects. (optional)
     * @param projectInstances Use for filtering projects for which project instances exist. (optional)
     * @param tagId The tag id of used for filtering projects. (optional)
     * @param status Use for filtering projects per status. (optional)
     * @return The list of projects. (status code 200)
     */
    @Operation(
        operationId = "getProjects",
        summary = "Get projects.",
        description = "Get projects.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of projects.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProjectModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/projects",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ProjectModel>> getProjects(
        @Parameter(name = "categoryId", description = "The category id used for filtering projects.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "categoryId", required = false) Long categoryId,
        @Parameter(name = "projectInstances", description = "Use for filtering projects for which project instances exist.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "projectInstances", required = false) Boolean projectInstances,
        @Parameter(name = "tagId", description = "The tag id of used for filtering projects.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "tagId", required = false) Long tagId,
        @Parameter(name = "status", description = "Use for filtering projects per status.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "status", required = false) ProjectStatusModel status
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 }, { \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workspaces/{id}/projects : Get projects by workspace id
     * Get projects by workspace id.
     *
     * @param id The id of a workspace. (required)
     * @param categoryId The category id used for filtering projects. (optional)
     * @param projectInstances Use for filtering projects for which project instances exist. (optional)
     * @param tagId The tag id of used for filtering projects. (optional)
     * @param status Use for filtering projects per status. (optional)
     * @return The list of projects. (status code 200)
     */
    @Operation(
        operationId = "getWorkspaceProjects",
        summary = "Get projects by workspace id",
        description = "Get projects by workspace id.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of projects.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProjectModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workspaces/{id}/projects",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ProjectModel>> getWorkspaceProjects(
        @Parameter(name = "id", description = "The id of a workspace.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "categoryId", description = "The category id used for filtering projects.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "categoryId", required = false) Long categoryId,
        @Parameter(name = "projectInstances", description = "Use for filtering projects for which project instances exist.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "projectInstances", required = false) Boolean projectInstances,
        @Parameter(name = "tagId", description = "The tag id of used for filtering projects.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "tagId", required = false) Long tagId,
        @Parameter(name = "status", description = "Use for filtering projects per status.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "status", required = false) ProjectStatusModel status
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 }, { \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /projects/{id}/publish : Publishes existing project.
     * Publishes existing project.
     *
     * @param id The id of a project. (required)
     * @param publishProjectRequestModel  (optional)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "publishProject",
        summary = "Publishes existing project.",
        description = "Publishes existing project.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/projects/{id}/publish",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> publishProject(
        @Parameter(name = "id", description = "The id of a project.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "PublishProjectRequestModel", description = "") @Valid @RequestBody(required = false) PublishProjectRequestModel publishProjectRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /projects/{id} : Update an existing project.
     * Update an existing project.
     *
     * @param id The id of a project. (required)
     * @param projectModel  (required)
     * @return The updated project object. (status code 200)
     */
    @Operation(
        operationId = "updateProject",
        summary = "Update an existing project.",
        description = "Update an existing project.",
        tags = { "project" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The updated project object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/projects/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<ProjectModel> updateProject(
        @Parameter(name = "id", description = "The id of a project.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "ProjectModel", description = "", required = true) @Valid @RequestBody ProjectModel projectModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 2, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 1, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, \"projectWorkflowIds\" : [ \"projectWorkflowIds\", \"projectWorkflowIds\" ], \"projectVersion\" : 5, \"workspaceId\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
