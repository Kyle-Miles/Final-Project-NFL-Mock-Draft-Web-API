package com.promineo.mockdrafts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private String fieldName;
  
  private Object fieldValue;
  
  public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
  super(String.format("%S not found with %S: %S", resourceName, fieldName, fieldValue));
  this.resourceName = resourceName;
  this.fieldName = fieldName;
  this.fieldValue = fieldValue;
  }

  public String getResourceName() {
    return resourceName;
  }

  public String getFieldName() {
    return fieldName;
  }

  public Object getFieldValue() {
    return fieldValue;
  }

}
