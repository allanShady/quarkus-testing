package com.alsacad.quarkusTests;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

import java.util.UUID;

import com.alsacad.quarkusTests.services.GreetingServices;
import javax.inject.Inject;

@QuarkusTest
public class GreetingResourceTest {

    @Inject
    GreetingServices greetingService;

    private static final Logger LOGGER = LoggerFactory.getLogger("GreetingResourceTest");

    @Test
    public void testHelloEndpoint() {
        given().when().get("/hello").then().statusCode(200).body(is("Hello RESTEasy"));
    }

    @Test
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();

        given().when().pathParam("name", uuid).get("/hello/greeting/{name}").then().statusCode(200)
                .body(startsWith("Java is not bad: " + uuid));
    }

    @Test
    public void testGreetingService() {
        LOGGER.info(greetingService.greeting("quarkus tests"));
        Assertions.assertTrue(greetingService.greeting("quarkus tests").startsWith("Java"));
    }

}