package library;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class test {

	public static String id;

	@Test(dataProvider = "getTestData")
	public void addBook(String isbn) {

		RestAssured.baseURI = "http://216.10.245.166";
		String postResponse = given().relaxedHTTPSValidation().header("Content-Type", "application/json")
				.body(Payload.addBook(isbn)).when().post("/Library/Addbook.php").then().statusCode(200).extract()
				.response().asString();

		JsonPath js = new JsonPath(postResponse);
		id = js.getString("ID");
		System.out.println(id);
	}

	@Test
	public void deleteBook() {

		RestAssured.baseURI = "http://216.10.245.166";
		String deleteResponse = given().relaxedHTTPSValidation().header("Content-Type", "application/json")
				.body(Payload.deleteBook(id)).when().delete("/Library/DeleteBook.php").then().statusCode(200).extract()
				.response().asString();

		JsonPath js1 = new JsonPath(deleteResponse);
		String msg = js1.getString("msg");
		System.out.println(msg);
	}

	@DataProvider
	public String[] getTestData() {
		String[] data = new String[5];
		data[0] = "bpc";
		data[1] = "hpc";
		data[2] = "ipc";
		data[3] = "qpc";
		data[4] = "zpc";
		return data;
	}

}
