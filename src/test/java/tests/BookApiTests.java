package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import utils.RestClient;
import org.json.JSONObject;
import config.ConfigManager;

public class BookApiTests {

    String baseUrl = ConfigManager.BASE_URL;

    @Test(priority = 1)
    public void createBookTest() {
        JSONObject book = new JSONObject();
        book.put("title", "Test Book");
        book.put("author", "Test Author");

        Response response = RestClient.post(baseUrl + "/books/", book.toString());
        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("Test Book"));
    }

    @Test(priority = 2)
    public void getBooksTest() {
        Response response = RestClient.get(baseUrl + "/books/");
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void updateBookNegativeTest() {
        JSONObject book = new JSONObject();
        book.put("title", "Updated");
        book.put("author", "Unknown");

        Response response = RestClient.put(baseUrl + "/books/999", book.toString());
        assertEquals(response.getStatusCode(), 404);
    }

    @Test(priority = 4)
    public void deleteBookTest() {
        Response response = RestClient.delete(baseUrl + "/books/1");
        assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204);
    }
}