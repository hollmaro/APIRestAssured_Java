package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class VideoGameConfig {

    private RequestSpecification reqSpec;
    private ResponseSpecification respSpec;

    @BeforeClass
    public void setup(){
        reqSpec = new RequestSpecBuilder().build();
        reqSpec.baseUri("https://videogamedb.uk/");
        reqSpec.basePath("api/v2/");
        reqSpec.port(443);
        reqSpec.contentType(ContentType.JSON);
        reqSpec.header("Accept", ContentType.JSON);
        reqSpec.filter(new RequestLoggingFilter());
        reqSpec.filter(new ResponseLoggingFilter());

        RestAssured.requestSpecification = reqSpec;

        respSpec = new ResponseSpecBuilder().build();
        respSpec.expect().statusCode(200);

        RestAssured.responseSpecification = respSpec;

    }
}
