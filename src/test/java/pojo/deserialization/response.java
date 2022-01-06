package pojo.deserialization;

import io.restassured.path.json.JsonPath;

public class response {
	
	public static void main(String[] Args) {
		 
		String response = "{\r\n"
		+ "  \"instructor\": \"rahulshetty\",\r\n"
		+ "  \"expertise\": \"Automation\",\r\n"
		+ "  \"url\": \"rahulshettyacademy.com\",\r\n"
		+ "  \"courses\": {\r\n"
		+ "    \"webautomation\": [\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"Selenium Python\",\r\n"
		+ "        \"price\": \"50\",\r\n"
		+ "        \"copies\": \"6\"\r\n"
		+ "      },\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"Cypress\",\r\n"
		+ "        \"price\": \"40\",\r\n"
		+ "        \"copies\": \"4\"\r\n"
		+ "      },\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"RPA\",\r\n"
		+ "        \"price\": \"45\",\r\n"
		+ "        \"copies\": \"10\"\r\n"
		+ "      }\r\n"
		+ "    ],\r\n"
		+ "    \"api\": [\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"Selenium Python api\",\r\n"
		+ "        \"price\": \"500\",\r\n"
		+ "        \"copies\": \"6\"\r\n"
		+ "      },\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"Cypress api\",\r\n"
		+ "        \"price\": \"400\",\r\n"
		+ "        \"copies\": \"4\"\r\n"
		+ "      },\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"RPA api\",\r\n"
		+ "        \"price\": \"450\",\r\n"
		+ "        \"copies\": \"10\"\r\n"
		+ "      }\r\n"
		+ "    ],\r\n"
		+ "    \"mobile\": [\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"Selenium Python\",\r\n"
		+ "        \"price\": \"50\",\r\n"
		+ "        \"copies\": \"6\"\r\n"
		+ "      },\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"Cypress\",\r\n"
		+ "        \"price\": \"40\",\r\n"
		+ "        \"copies\": \"4\"\r\n"
		+ "      },\r\n"
		+ "      {\r\n"
		+ "        \"title\": \"RPA\",\r\n"
		+ "        \"price\": \"45\",\r\n"
		+ "        \"copies\": \"10\"\r\n"
		+ "      }\r\n"
		+ "    ]\r\n"
		+ "  }\r\n"
		+ "}";
		
		JsonPath js = new JsonPath(response);
		
		
		System.out.println(js.get("url"));
			
	}

}
