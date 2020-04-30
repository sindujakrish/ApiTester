package com.restCountriesApi.ApiTester;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class App {
 
    public static void main(String args[]) {
        //The base URI to be used
        RestAssured.baseURI = "https://restcountries.eu/rest/v2/capital/london";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET);
 
        String capital = response.getBody().jsonPath().getString("capital");
        System.out.println("The capital city is: "+capital);
        String responseStr = response.asString();
        String hasValue = "False";
        if(responseStr != null && responseStr.length() > 0) {
        	if(responseStr.contains("British pound")) {
        		hasValue = "True";
        	}
        }
       System.out.println("Has 'British pound' in response? "+hasValue);
    }
}
