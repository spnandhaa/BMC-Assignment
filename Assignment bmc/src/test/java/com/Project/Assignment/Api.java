package com.Project.Assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Api {
@Test
	public void Createbooking() {
		RestAssured.baseURI= "https://restful-booker.herokuapp.com/ ";
		String bearertoken= " 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";
		Response create= RestAssured.given()
				.header("Authorization","Bearer","Content-Type: application/json"+ bearertoken)
				.body(" {\r\n"
						+ "    \"firstname\" : \"Jim\",\r\n"
						+ "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}")
				.when().post("booking")
				.then().log().all().extract().response();
		
		int statuscode=create.getStatusCode();
		Assert.assertEquals(201,statuscode);
		
	}
@Test
public void getbooking() {
	RestAssured.baseURI= "https://restful-booker.herokuapp.com/ ";
	String bearertoken= " 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";
	Response create= RestAssured.given()
			.header("Authorization","Bearer","Content-Type: application/json"+ bearertoken)
			.when().get("booking")
			.then().log().all().extract().response();
	
	int statuscode=create.getStatusCode();
	Assert.assertEquals(200,statuscode);
}
@Test
public void updatebooking() {
	RestAssured.baseURI= "https://restful-booker.herokuapp.com/ ";
	String bearertoken= " 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";
	Response create= RestAssured.given()
			.header("Authorization","Bearer","Content-Type: application/json"+ bearertoken)
			.body(" {\r\n"
					+ "    \"firstname\" : \"James\",\r\n"
					+ "    \"lastname\" : \"Brown\"\r\n"
					+ "}")
			.when().put("booking")
			.then().log().all().extract().response();
	
	int statuscode=create.getStatusCode();
	Assert.assertEquals(200,statuscode);
}
@Test
public void deletebooking() {
	RestAssured.baseURI= "https://restful-booker.herokuapp.com/ ";
	String bearertoken= " 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";
	Response create= RestAssured.given()
			.header("Authorization","Bearer","Content-Type: application/json"+ bearertoken)
			.when().delete("booking/1")
			.then().log().all().extract().response();
	
	int statuscode=create.getStatusCode();
	Assert.assertEquals(204,statuscode);
}

}
