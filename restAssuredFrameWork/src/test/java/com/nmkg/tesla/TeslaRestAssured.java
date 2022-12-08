package com.nmkg.tesla;

import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.response.Response;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeslaRestAssured extends APITestCase {
	// static String API_PATH = API_ROOT + "/api/books/";
	static String API_PATH = "https://gorest.co.in/public/v1/users";
	

	@Test	
	public void testEmptyStore() {
		RestAssured.when().get(API_PATH)
		.then()
		.body("size()", CoreMatchers.is(0));
	}

	@Test
	public void testTitleIsRequired() {
		String requestBody = "{\n" + "  \"author\": \"Smith\"\n}";
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.put(API_PATH)
				.then()
				.extract().response();

		assertEquals("Field title is required", response.getBody().asString());
	}

	@Test
	public void testTitleIsNotEmpty() {
		String requestBody = "{\n" + "  \"title\": \"\",\n" + "  \"author\": \"Smith\"\n}";
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when().put(API_PATH)
				.then()
				.extract().response();

		assertEquals("{\"error\": \"Field \\\"title\\\" cannot be empty\"}", response.getBody().asString());
	}

	@Test
	public void testAuthorIsNotEmpty() {
		String requestBody = "{\n" + "  \"title\": \"SRE 101\",\n" + "  \"author\": \"\"\n}";
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.put(API_PATH)
				.then()
				.extract().response();

		assertEquals("{\"error\": \"Field \\\"author\\\" cannot be empty\"}", response.getBody().asString());
	}

	@Test
	public void testIdIsReadOnly() {
		String requestBody = "{\n" + "  \"id\": \"1234\",\n" + "  \"title\": \"SRE 101\",\n"
				+ "  \"author\": \"Archer\"\n}";
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.put(API_PATH)
				.then()
				.extract().response();

		assertEquals("{[\"error\": \"\\\"id\\\" is a read-only field\"]}", response.getBody().asString());
		assertNotEquals(200, response.statusCode());
	}

	@Test
    public void testCreateNewBook() {
       
        String requestBody = "{\n" +
            "  \"title\": \"SRE 101\",\n" +
            "  \"author\": \"Archer\"\n}";
           
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put(API_PATH)
                .then()
                .extract().response();
               
        String bookId = response.jsonPath().getString("id");
       
        Response bookData = RestAssured.given()
            .header("Content-type", "application/json")
            .when()
            .get(API_PATH + bookId + "/")
            .then()
            .extract().response();
           
        assertEquals("SRE 101", bookData.jsonPath().getString("title"));
        assertEquals("Archer", bookData.jsonPath().getString("author"));
    }

	@Test
	public void testDuplicateBook() {
		String requestBody = "{\n" + "  \"title\": \"SRE 101\",\n" + "  \"author\": \"Archer\"\n}";
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.put(API_PATH)
				.then()
				.extract().response();
		
		Response response1 = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.put(API_PATH)
				.then()
				.extract().response();
		String body = response1.getBody().asString();
		assertEquals(body, "{[\"error\": \"Another book with similar title and author already exists\"]}");
	}
}
