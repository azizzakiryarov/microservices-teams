package se.azza.teamservice.constants;

public final class Urls {

    public static final String BASE_URL = "http://microservices-users-statefulset-0.microservices-users.microservices.svc.cluster.local:8081";

    public static final String GET_ALL_USERS_FOR = BASE_URL + "/users/getAllUsersFor/";

    private Urls() {}
}
