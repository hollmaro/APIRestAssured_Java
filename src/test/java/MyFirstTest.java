import config.VideoGameConfig;
import config.VideoGameEndPoints;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MyFirstTest extends VideoGameConfig {

    @Test
    public void myTest(){
        given().log().all();
        when().get("/videogame").
        then().
                log().all();
    }

    @Test
    public void myFirstTestWithEndPoints(){
        get(VideoGameEndPoints.ALL_VIDEO_GAMES)
                .then().log().all();
    }
}
