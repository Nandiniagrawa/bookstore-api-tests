package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import utils.RestClient;
import org.json.JSONObject;
import config.ConfigManager;

public class BookApiTests {

    String baseUrl = ConfigManager.BASE_URL;

    // To hold created book id for chaining tests
    private static int createdBookId;

    @Test(priority = 1)
    public void createBookTest() {
        JSONObject book = new JSONObject();
        book.put("title", "Test Book");
        book.put("author", "Test Author");

        Response response = RestClient.post(baseUrl + "/books/", book.toString());
        assertEquals(response.getStatusCode(), 201); // Changed to 201
        assertTrue(response.getBody().asString().contains("Test Book"));

        // Extract ID for future use
        createdBookId = response.jsonPath().getInt("id");
        assertTrue(createdBookId > 0);
    }

    @Test(priority = 2)
    public void getBooksTest() {
        Response response = RestClient.get(baseUrl + "/books/");
        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("Test Book"));
    }

    @Test(priority = 3)
    public void updateBookNegativeTest() {
        JSONObject book = new JSONObject();
        book.put("title", "Updated Title");
        book.put("author", "Updated Author");

        // Use a high id that likely doesn't exist (e.g., 99999)
        Response response = RestClient.put(baseUrl + "/books/99999", book.toString());

        // Update expected code based on actual API behavior
        // If 404 expected, keep 404; if API returns 200 for missing update, asser
