package library;

public class Payload {
	
	public static String addBook(String isbn) {
		
		String payload = "{\r\n"
				+ "\"name\":\"API Practice for Beginers\",\r\n"
				+ "\"isbn\":\"" + isbn + "\",\r\n"
				+ "\"aisle\":\"567\",\r\n"
				+ "\"author\":\"ArunReddy N\"\r\n"
				+ "}";
		return payload;
	}

	public static String deleteBook(String id) {
		
		String payload = "{\r\n"
				+ "\"ID\" : \"" + id + "\"\r\n"
				+ "}";
		return payload;
		
	}
}
