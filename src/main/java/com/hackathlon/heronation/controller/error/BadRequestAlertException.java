package com.hackathlon.heronation.controller.error;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class BadRequestAlertException extends BadRequestException {

    private static final long serialVersionUID = 1L;

    private final String entityName;

    private final String errorKey;

    public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
    }

    public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

//    public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
//        super(type, defaultMessage, Response.Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey));
//        this.entityName = entityName;
//        this.errorKey = errorKey;
//    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", "error." + errorKey);
        parameters.put("params", entityName);
        return parameters;
    }
}
