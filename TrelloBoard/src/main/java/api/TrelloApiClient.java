package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;

public class TrelloApiClient {
	
	private String apiKey;
    private String apiToken;

    public TrelloApiClient(String baseUrl, String apiKey, String apiToken) {
        this.apiKey = apiKey;
        this.apiToken = apiToken;
        RestAssured.baseURI = baseUrl;
    }
    
    public Response createBoard(String name) {
        return RestAssured.given()
        		.header("Content-Type", "application/json")
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .queryParam("name", name)
                .when()
                .post("/boards");
    }
    
    public Response getBoard(String boardId) {
        return RestAssured.given()
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .when()
                .get("/boards/{boardId}", boardId);
    }

    public Response updateBoard(String boardId, String newName) {
        return RestAssured.given()
        		.header("Content-Type", "application/json")
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .queryParam("name", newName)
                .when()
                .put("/boards/{boardId}", boardId);
    }

    public Response deleteBoard(String boardId) {
        return RestAssured.given()
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .when()
                .delete("/boards/{boardId}", boardId);
    }

}
