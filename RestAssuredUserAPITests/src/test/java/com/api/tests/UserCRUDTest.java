package com.api.tests;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends BaseTest {

    String username = "testUser123";

    @Test(priority = 1)
    public void createUser() {
        JSONObject req = new JSONObject();
        req.put("id", 1234);
        req.put("username", username);
        req.put("firstName", "John");
        req.put("lastName", "Doe");
        req.put("email", "john.doe@example.com");
        req.put("password", "12345");
        req.put("phone", "9999999999");

        Response res = given()
                .contentType("application/json")
                .body(req.toJSONString())
                .when()
                .post("/user");

        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println("User created successfully");
    }

    @Test(priority = 2)
    public void getUser() {
        Response res = given()
                .when()
                .get("/user/" + username);

        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.jsonPath().getString("username"), username);
        System.out.println("User fetched successfully");
    }

    @Test(priority = 3)
    public void updateUser() {
        JSONObject req = new JSONObject();
        req.put("id", 1234);
        req.put("username", username);
        req.put("firstName", "Johnny");
        req.put("lastName", "Doe");
        req.put("email", "johnny.doe@example.com");
        req.put("password", "54321");
        req.put("phone", "8888888888");

        Response res = given()
                .contentType("application/json")
                .body(req.toJSONString())
                .when()
                .put("/user/" + username);

        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println("User updated successfully");
    }

    @Test(priority = 4)
    public void deleteUser() {
        Response res = given()
                .when()
                .delete("/user/" + username);

        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println("User deleted successfully");
    }
}
