package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequests {

	@Test
	public void testAllProducts() {

		RestAssured.baseURI = "http://localhost:8082/medicare/json/data/all/products";

		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		String ResponseBody = response.getBody().asString();

		System.out.println("Response body for all products request: " + ResponseBody);

		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 200);

		System.out.println("Response code is " + ResponseCode);
		
		System.out.println("List of all products:");
		
		JsonPath jpath = response.jsonPath();

		List<String> names = jpath.get("name");
		for (String s:names) {
			System.out.println(s);
		}
		
	}
		
		@Test
		public void testAllAntipyretics() {

			RestAssured.baseURI = "http://localhost:8082/medicare/json/data/category/1/products";

			RequestSpecification request = RestAssured.given();

			Response response = request.get();

			String ResponseBody = response.getBody().asString();

			System.out.println("Response body for all Antipyretics request: " + ResponseBody);
			assert(ResponseBody.contains("Paracetamol"));
			assert(ResponseBody.contains("Combiflame"));
			

			int ResponseCode = response.getStatusCode();
			Assert.assertEquals(ResponseCode, 200);

			System.out.println("Response code is " + ResponseCode);
			
			System.out.println("List of Antipyretics:");
			
			JsonPath jpath = response.jsonPath();

			List<String> names = jpath.get("name");
			for (String s:names) {
				System.out.println(s);
	
			}
		}
			

			@Test
			public void testMostViewedProducts() {

				RestAssured.baseURI = "http://localhost:8082/medicare/json/data/mv/products";

				RequestSpecification request = RestAssured.given();

				Response response = request.get();

				String ResponseBody = response.getBody().asString();

				System.out.println("Response body for most viewed products request: " + ResponseBody);
				assert(ResponseBody.contains("Amoxicillin"));
				

				int ResponseCode = response.getStatusCode();
				Assert.assertEquals(ResponseCode, 200);

				System.out.println("Response code is " + ResponseCode);
				
				System.out.println("List of most viewed products:");
				
				JsonPath jpath = response.jsonPath();

				List<String> names = jpath.get("name");
				for (String s:names) {
					System.out.println(s);
		
				}
			}
				
			
				@Test
				public void testMostPurchasedProducts() {

					RestAssured.baseURI = "http://localhost:8082/medicare/json/data/mp/products";

					RequestSpecification request = RestAssured.given();

					Response response = request.get();

					String ResponseBody = response.getBody().asString();

					System.out.println("Response body for most purchased products request: " + ResponseBody);
					assert(ResponseBody.contains("Diclofenac"));
					

					int ResponseCode = response.getStatusCode();
					Assert.assertEquals(ResponseCode, 200);

					System.out.println("Response code is " + ResponseCode);
					
					System.out.println("List of most purchased products:");
					
					JsonPath jpath = response.jsonPath();

					List<String> names = jpath.get("name");
					for (String s:names) {
						System.out.println(s);
			
					}
			
	}
}