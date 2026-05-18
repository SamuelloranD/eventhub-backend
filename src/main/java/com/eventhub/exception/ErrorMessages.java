package com.eventhub.exception;

public final class ErrorMessages {
    private ErrorMessages() {}

    public static final String EMAIL_ALREADY_EXISTS = "EMAIL_ALREADY_EXISTS";
    public static final String INVALID_CREDENTIALS = "INVALID_CREDENTIALS";
    public static final String UNAUTHENTICATED_USER = "UNAUTHENTICATED_USER";
    public static final String AUTHENTICATED_USER_NOT_FOUND = "AUTHENTICATED_USER_NOT_FOUND";

    public static final String CATEGORY_ALREADY_EXISTS = "CATEGORY_ALREADY_EXISTS";
    public static final String CATEGORY_NOT_FOUND = "CATEGORY_NOT_FOUND";

    public static final String EVENT_NOT_FOUND = "EVENT_NOT_FOUND";
    public static final String INVALID_EVENT_STATUS = "INVALID_EVENT_STATUS";

    public static final String USER_ALREADY_REGISTERED_IN_EVENT = "USER_ALREADY_REGISTERED_IN_EVENT";
    public static final String REGISTRATION_NOT_FOUND = "REGISTRATION_NOT_FOUND";
    public static final String USER_NOT_FOUND = "USER_NOT_FOUND";

    public static final String EVENT_ALREADY_SAVED = "EVENT_ALREADY_SAVED";
    public static final String SAVED_EVENT_NOT_FOUND = "SAVED_EVENT_NOT_FOUND";
}
