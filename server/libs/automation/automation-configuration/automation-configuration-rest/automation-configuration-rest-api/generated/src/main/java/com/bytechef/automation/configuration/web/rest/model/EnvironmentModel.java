package com.bytechef.automation.configuration.web.rest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The environment of a project.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-16T06:17:02.431395+02:00[Europe/Zagreb]", comments = "Generator version: 7.4.0")
public enum EnvironmentModel {
  
  DEVELOPMENT("DEVELOPMENT"),
  
  STAGING("STAGING"),
  
  PRODUCTION("PRODUCTION");

  private String value;

  EnvironmentModel(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EnvironmentModel fromValue(String value) {
    for (EnvironmentModel b : EnvironmentModel.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

