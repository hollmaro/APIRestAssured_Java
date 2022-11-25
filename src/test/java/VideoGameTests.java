import config.VideoGameConfig;
import config.VideoGameEndPoints;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VideoGameTests extends VideoGameConfig {

    String gameBodyJson = "{\n" +
            "  \"id\": 0,\n" +
            "  \"name\": \"SuperBall\",\n" +
            "  \"releaseDate\": \"2022-11-15T16:20:25.196Z\",\n" +
            "  \"reviewScore\": 10,\n" +
            "  \"category\": \"Fooz\",\n" +
            "  \"rating\": \"10\"\n" +
            "}";

    @Test
    public void getAllGamesGET(){
        given()
        .when()
                .get(VideoGameEndPoints.ALL_VIDEO_GAMES)
        .then();
    }

    @Test
    public void createNewGameJsonPOST(){


        given()
                .body(gameBodyJson)
        .when()
                .post(VideoGameEndPoints.ALL_VIDEO_GAMES)
        .then();
    }

    @Test
    public void createNewGameXmlPOST(){
        String gameBodyXml = "<VideoGameRequest>\n" +
                "    <category>platform</category>\n" +
                "    <name>Mario</name>\n" +
                "    <rating>Mature</rating>\n" +
                "    <releaseDate>2020-14-12</releaseDate>\n" +
                "    <reviewScore>85</reviewScore>\n" +
                "</VideoGameRequest>";
        given()
                .body(gameBodyXml)
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
        .when()
                .post(VideoGameEndPoints.ALL_VIDEO_GAMES)
        .then();
    }

    @Test
    public void updateGameJsonPUT(){
        given()
                .body(gameBodyJson)
        .when()
                .put("videogame/3")
        .then();

    }

    @Test
    public void deleteGameDELETE(){
        given()
                .accept(ContentType.TEXT)
        .when()
                .delete("videogame/3")
        .then();
    }

}
