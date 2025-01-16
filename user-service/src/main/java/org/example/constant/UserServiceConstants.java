package org.example.constant;

public class UserServiceConstants {

    public static final String USER_BASE_URL = "/user";

    public static final String ORDER_BASE_URL = "/order";

    public static final String GET_BASE_URL = "/get";

    public static final String CREATE_BASE_URL = "/create";

    public static final String GET_ALL_ORDER = GET_BASE_URL + "/all-order";

    public static final String CREATE_USER = CREATE_BASE_URL + "/user";

    public static final String USER_SERVICE_INSTANCE_NAME_CK = "userService";

    public static final String GET_ALL_ORDER_FALLBACK_METHOD_NAME_CK = "getAllAvailableProducts";

    public static final String GET_USER_BY_ID = GET_BASE_URL + "/{userId}";
}
