package utils;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class RestClient {

    public static Response post(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .log().all()
            .when()
                .post(endpoint)
            .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response get(String endpoint) {
        return given()
                .contentType("application/json")
                .log().all()
            .when()
                .get(endpoint)
            .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response put(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .log().all()
            .when()
                .put(endpoint)
            .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response delete(String endpoint) {
        return given()
                .contentType("application/json")
                .log().all()
            .when()
                .delete(endpoint)
            .then()
                .log().all()
                .extract()
                .response();
    }
}
