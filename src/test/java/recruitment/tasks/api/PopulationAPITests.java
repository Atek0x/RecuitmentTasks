package recruitment.tasks.api;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PopulationAPITests {

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
    public void verifyStatusCode() {
        LOGGER.info("Executing verifyStatusCode test.");
        Response response = given()
                .queryParams(queryParams)
                .when()
                .get("data")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received with status code: {}", response.statusCode());
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyDataIsNotEmpty() {
        LOGGER.info("Executing verifyDataIsNotEmpty test.");
        Response response = given()
                .queryParams(queryParams)
                .when()
                .get("data")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received with status code: {}", response.statusCode());
        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();

        List<Object> data = jsonPath.getList("data");
        LOGGER.info("Data received: {}", data);
        Assertions.assertThat(data).isNotEmpty();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyPopulationIsANumber() {
        LOGGER.info("Executing verifyPopulationIsANumber test.");
        Response response = given()
                .when()
                .get("data?drilldowns=Nation&measures=Population")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received with status code: {}", response.statusCode());
        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();

        List<Object> list = jsonPath.getList("data.Population");
        LOGGER.info("Population data received: {}", list);
        list.forEach(el -> Assertions.assertThat(el).isInstanceOf(Integer.class));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyNationIsValidValue() {
        LOGGER.info("Executing verifyNationIsValidValue test.");
        Response response = given()
                .when()
                .get("data?drilldowns=Nation&measures=Population")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received with status code: {}", response.statusCode());
        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();

        List<String> list = jsonPath.getList("data.Nation");
        LOGGER.info("Nation data received: {}", list);
        Assertions.assertThat(list).containsOnly("United States");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyMeasuresIsSetToPopulation() {
        LOGGER.info("Executing verifyMeasuresIsSetToPopulation test.");
        Response response = given()
                .queryParams(queryParams)
                .when()
                .get("data")
                .then()
                .extract()
                .response();

        LOGGER.info("Response received with status code: {}", response.statusCode());
        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();

        List<Object> list = jsonPath.getList("source.measures[0]");
        LOGGER.info("Measures data received: {}", list);
        Assertions.assertThat(list).containsOnly("Population");
    }
}

