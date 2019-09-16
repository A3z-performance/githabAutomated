import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiOneTest {

    @Test
    public void exampleTest() {

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://www.googleapis.com")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = requestSpec;


             given()
                    .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()))
             .when()
                    .get("/youtube/v3/videos")
             .then()
                    .assertThat().statusCode(HttpStatus.SC_FORBIDDEN);

    }
}
