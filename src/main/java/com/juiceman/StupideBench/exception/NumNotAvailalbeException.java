package com.juiceman.StupideBench.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NumNotAvailalbeException extends RuntimeException{


    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public NumNotAvailalbeException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("The number of %s is not available with %s in '%s'", resourceName, fieldName, fieldValue));
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
