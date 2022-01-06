package pojo.serialization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class SerializationTest {

	public static void main(String[] args) {

		AddPlace ap = new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("French-IN");
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		ap.setTypes(list);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String postResponse = given().relaxedHTTPSValidation().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(ap).when().post("maps/api/place/add/json").then()
				.assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

		System.out.println(postResponse);

	}

}
