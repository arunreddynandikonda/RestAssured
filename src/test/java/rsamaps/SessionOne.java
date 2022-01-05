package rsamaps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SessionOne {

	public static String placeId;

	public static void main(String[] Args) throws IOException {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String postResponse = given().relaxedHTTPSValidation().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(new String(Files.readAllBytes(
						Paths.get("C:\\Users\\anandikonda\\Downloads\\Documents\\RahulShetty\\APITesting\\addPlace.json"))))
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response()
				.asString();

		System.out.println(postResponse);
		JsonPath jpPost = new JsonPath(postResponse);
		placeId = jpPost.getString("place_id");
//		String id = js.getString("id");
		System.out.println(placeId);
//		System.out.println(id);

		String putResponse = given().relaxedHTTPSValidation().queryParam("key", "qaclick123")
				.queryParam("place_id", placeId).header("Content-Type", "application/json").body(Payload.updatePlace())
				.when().put("maps/api/place/update/json").then().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"))
				.header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

		JsonPath jpPut = new JsonPath(putResponse);
		String msg = jpPut.getString("msg");
		System.out.println(msg);

		String getResponse = given().relaxedHTTPSValidation().queryParam("key", "qaclick123")
				.queryParam("place_id", placeId).when().get("maps/api/place/get/json").then().assertThat()
				.statusCode(200).header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

		JsonPath jpGet = new JsonPath(getResponse);
		String address = jpGet.getString("address");
		System.out.println(address);
		Assert.assertEquals(Payload.newAddress, address);

	}

}
