import org.apache.http.HttpStatus;

import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class GetRequests extends TestConfig {
    @Test
    public void verifySuccessResponse() {
        try {
            given()
            .when()
                    .get(Resources.getUserPage2EndPointUri())
            .then()
                    .assertThat().statusCode(HttpStatus.SC_OK).body("page", equalTo(2))
                    .and().body("data", hasItems());
                    //.and().body();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
        }
    }

    /*@Test
    public void verifySchema() {
        try {
            given().log().all()
                    .when().log().all()
                    .get(Resources.getUsersIndex2EndPointUri())
                    .then()
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/userDataJsonSchema.json"))
                    .and().statusCode(HttpStatus.SC_OK).log().all();
            //.and().body();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
        }
    }*/



}
