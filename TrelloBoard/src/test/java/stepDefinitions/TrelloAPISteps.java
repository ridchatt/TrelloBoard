package stepDefinitions;

import api.TrelloApiClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.ConfigReader;
import static org.junit.Assert.*;

public class TrelloAPISteps {
	
	private TrelloApiClient trelloApiClient;
    private Response response;
    private String createdBoardId;
    private String updatedBoardName = "Updated Board";

    public TrelloAPISteps() {
    	initializeClientWithValidCredentials();
    }
    
    private void initializeClientWithValidCredentials() {
        ConfigReader configReader = new ConfigReader();
        String baseUrl = configReader.getBaseUrl();
        String apiKey = configReader.getApiKey();
        String apiToken = configReader.getApiToken();
        trelloApiClient = new TrelloApiClient(baseUrl, apiKey, apiToken);
    }

    private void initializeClientWithInvalidCredentials() {
        // Use invalid API credentials
        String baseUrl = new ConfigReader().getBaseUrl();
        String invalidApiKey = "INVALID_API_KEY";
        String invalidApiToken = "INVALID_API_TOKEN";
        trelloApiClient = new TrelloApiClient(baseUrl, invalidApiKey, invalidApiToken);
    }

    @Given("I have API credentials")
    public void i_have_api_credentials() {
        assertNotNull(trelloApiClient);
    }

    @When("I create a board with name {string}")
    public void i_create_a_board_with_name(String boardName) {
        response = trelloApiClient.createBoard(boardName);
        assertEquals(200, response.getStatusCode());
        createdBoardId = response.jsonPath().getString("id");
        assertNotNull(createdBoardId);
    }

    @Then("the board {string} should be created successfully")
    public void the_board_should_be_created_successfully(String boardName) {
        response = trelloApiClient.getBoard(createdBoardId);
        assertEquals(200, response.getStatusCode());
        assertEquals(boardName, response.jsonPath().getString("name"));
    }

    @When("I retrieve the created board")
    public void i_retrieve_the_created_board() {
        response = trelloApiClient.getBoard(createdBoardId);
        assertEquals(200, response.getStatusCode());
    }

    @Then("the board name should be {string}")
    public void the_board_name_should_be(String expectedName) {
        assertEquals(expectedName, response.jsonPath().getString("name"));
    }

    @When("I update the created board name to {string}")
    public void i_update_the_created_board_name_to(String newName) {
        response = trelloApiClient.updateBoard(createdBoardId, newName);
        assertEquals(200, response.getStatusCode());
    }

    @Then("the board should be updated successfully")
    public void the_board_should_be_updated_successfully() {
        response = trelloApiClient.getBoard(createdBoardId);
        assertEquals(200, response.getStatusCode());
        assertEquals(updatedBoardName, response.jsonPath().getString("name"));
    }

    @When("I delete the created board")
    public void i_delete_the_created_board() {
        response = trelloApiClient.deleteBoard(createdBoardId);
        assertEquals(200, response.getStatusCode());
    }

    @Then("the board should be deleted successfully")
    public void the_board_should_be_deleted_successfully() {
        response = trelloApiClient.getBoard(createdBoardId);
        assertEquals(404, response.getStatusCode());
    }

    @Given("I have invalid API credentials")
    public void i_have_invalid_api_credentials() {
        initializeClientWithInvalidCredentials();
    }

    @When("I attempt to create a board with name {string} using invalid credentials")
    public void i_attempt_to_create_a_board_with_name_using_invalid_credentials(String boardName) {
        response = trelloApiClient.createBoard(boardName);
    }

    @Then("the board creation should fail with a {int} Unauthorized error")
    public void the_board_creation_should_fail_with_a_unauthorized_error(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("an error message indicating {string} should be displayed")
    public void an_error_message_indicating_should_be_displayed(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, response.getBody().asString());
    }


}
