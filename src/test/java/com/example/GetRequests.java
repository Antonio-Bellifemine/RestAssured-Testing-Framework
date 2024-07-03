package com.example;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequests {
    @BeforeSuite
    void setUp() {
        System.out.println("Setup");
    };

    @Test
    void get_req() {
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "ping";
        given().when().then().log().all().statusCode(200).body("result", equalTo("pong"));
    }

    @AfterSuite
    void tearDown() {
        System.out.println("Teardown");
    }

};
