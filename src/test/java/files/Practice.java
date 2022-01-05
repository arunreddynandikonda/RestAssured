package files;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class Practice {

	public static void main(String[] args) {

		JsonPath jp = new JsonPath(ComplexJsonPayload.coursesList());

//		1. Print No of courses returned by API

		int count = jp.getInt("courses.size()");
		System.out.println(count);

//		2.Print Purchase Amount

		int purchaseAmount = jp.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

//		3. Print Title of the first course

		String firstCorse = jp.getString("courses[0].title");
		System.out.println(firstCorse);

//		4. Print All course titles and their respective Prices

		for (int i = 0; i < count; i++) {
			String courses = jp.getString("courses[" + i + "].title");
			int prices = jp.getInt("courses[" + i + "].price");
			System.out.print(courses);
			System.out.println(":" + prices);
		}

//		5. Print no of copies sold by RPA Course

		for (int i = 0; i < count; i++) {
			String course = jp.getString("courses[" + i + "].title");
			if (course.equals("RPA")) {
				int noOfCopies = jp.getInt("courses[" + i + "].copies");
				System.out.println(noOfCopies);
				break;
			}
		}

//		6. Verify if Sum of all Course prices matches with Purchase Amount

		int sum = 0;
		for (int i = 0; i < count; i++) {
			int prices = jp.getInt("courses[" + i + "].price");
			int copies = jp.getInt("courses[" + i + "].copies");
			sum = sum + (prices * copies);
		}
		System.out.println(sum);
		Assert.assertEquals(purchaseAmount, sum);

	}

}
