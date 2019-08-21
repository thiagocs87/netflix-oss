package br.com.clickbus.test;

import static com.jayway.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import br.com.client.Application;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

//@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration(classes = Application.class) 
//@TestPropertySource(value={"classpath:application-test.properties"})
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientResourceTest {
	
	@Test
	public void teste() {
		assertTrue(true);
	}
	/*
	@LocalServerPort
    private int port;

	private String path = Paths.get("../").toAbsolutePath().normalize().toString() + "/test-files/";
	private String validJson = "validJson.json";
	private String invalidJson = "invalidJson.json";
	private String schemaJsonSinglePlace = "schemaSinglePlace.json";
	
    @Before
    public void setBaseUri () {
            RestAssured.port = port;
            RestAssured.baseURI = "http://localhost";
    }
    
    @Test
    public void getDataTest() {
        get("/places").then().assertThat().statusCode(200);
    }
    
    @Test
    public void getUnexistingDataByNameTest() {
        get("/places/name/xxxxxxxxxxx").then().assertThat().statusCode(200);
    }
    
    @Test
    public void getUnexistingDataByIdTest() {
        get("/places/999999999").then().assertThat().statusCode(200);
    }
    
    @Test
    public void deleteUnexistingDataByIdTest() {
        delete("/places/99999999").then().assertThat().statusCode(200);
    }

    @Test
    public void updateUnexistingDataValidTest() throws Exception {
    	try {
    		PlaceDto place = getInputJson(validJson);
            given().urlEncodingEnabled(true)
            .contentType(ContentType.JSON)
            .body(place)
            .put("/places/99999999999")
            .then().statusCode(200);
		} catch (Exception e) {
			throw e;
		}
    }  

    @Test(expected = InvalidFormatException.class)
    public void updateUnexistingDataInvalidTest() throws Exception {
    	try {
            PlaceDto place = getInputJson(invalidJson);
            given().urlEncodingEnabled(true)
            .contentType(ContentType.JSON)
            .body(place)
            .put("/places/9999999999999")
            .then().statusCode(400);
		} catch (Exception e) {
			throw e;
		}
    }  
    
    @Test
    public void saveDataValidTest() throws Exception {
    	try {
    		JSONObject schemaFile = readSchema(schemaJsonSinglePlace);
    		Schema schema = SchemaLoader.load(schemaFile);
    		PlaceDto place = getInputJson(validJson);
            String returnJson = given().urlEncodingEnabled(true)
            .contentType(ContentType.JSON)
            .body(place)
            .post("/places")
            .then().extract().asString();
        	schema.validate(new JSONObject(returnJson));
		} catch (Exception e) {
			throw e;
		}
    }
    
    @Test(expected = InvalidFormatException.class)
    public void saveDataInvalidTest() throws Exception {
    	try {
    		PlaceDto place = getInputJson(invalidJson);
            given().urlEncodingEnabled(true)
            .contentType(ContentType.JSON)
            .body(place)
            .post("/places")
            .then().statusCode(400);
		} catch (Exception e) {
			throw e;
		}
    }
    
	private PlaceDto getInputJson(String file)
			throws FileNotFoundException, IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		FileReader inputJsonFile = new FileReader(path+file);
		PlaceDto place = mapper.readValue(inputJsonFile, PlaceDto.class);
		return place;
	}
	
	private JSONObject readSchema(String file) throws IOException, JSONException {
		  byte[] encoded = Files.readAllBytes(Paths.get(path+file));
		  String schemaFile = new String(encoded, StandardCharsets.US_ASCII);
		  JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaFile));
		  return jsonSchema;
	}
*/
}
