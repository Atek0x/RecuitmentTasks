package recruitment.tasks.api;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CRUDMethodTests {

    // Each of the tests below should return status code 405, as this method indicates that the request is not supported, but status code 404 is returned as if the server doesn't see access to these methods at all.

    private static final Logger LOGGER = LogManager.getLogger();
    private static Map<String, String> queryParams;

    @BeforeClass
    public void setUpClass() {
        RestAssured.baseURI = "https://datausa.io/api/";

        queryParams = new HashMap<>();
        queryParams.put("drilldowns", "Nation");
        queryParams.put("measures", "Population");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyPostMethodIsNotAllowed() {
        LOGGER.info("Executing verifyPostMethodIsNotAllowed test.");
        Response response = given()
                .contentType("application/json")
                .when()
                .post("data")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received: {}", response.asString());
        Assert.assertEquals(404, response.statusCode());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyPutMethodIsNotAllowed() {
        LOGGER.info("Executing verifyPutMethodIsNotAllowed test.");
        Response response = given()
                .contentType("application/json")
                .when()
                .put("data")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received: {}", response.asString());
        Assert.assertEquals(404, response.statusCode());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyPatchMethodIsNotAllowed() {
        LOGGER.info("Executing verifyPatchMethodIsNotAllowed test.");
        Response response = given()
                .contentType("application/json")
                .when()
                .patch("data")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received: {}", response.asString());
        Assert.assertEquals(404, response.statusCode());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyDeleteMethodIsNotAllowed() {
        LOGGER.info("Executing verifyDeleteMethodIsNotAllowed test.");
        Response response = given()
                .contentType("application/json")
                .when()
                .delete("data")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received: {}", response.asString());
        Assert.assertEquals(404, response.statusCode());
    }

}
