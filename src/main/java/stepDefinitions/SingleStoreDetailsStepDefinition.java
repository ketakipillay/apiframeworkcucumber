package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import utils.ResponseHandler;
import utils.TestContext;

import models.storesResponse.*;

public class SingleStoreDetailsStepDefinition {

	TestContext testContext;
	
	public SingleStoreDetailsStepDefinition(TestContext testContext){
		this.testContext=testContext;
	}
	
	@Given("{string} api is invoked with limit {int}")
	public void invokingApiWithLimit(String stores, int limit) {
	    	 
		System.out.println("baseUri "+RestAssured.baseURI);
		testContext.response = given().queryParam("$limit", "1").get("/"+stores);
	}
	
	@Then("Store id is retrieved")
	public void getStoreIdFromResposne() {
		
		int storeId =testContext.response.body().jsonPath().get("data[0].id");
		
		testContext.storeId = storeId;
		
	}
	
	
	
	@Given("{string} api is invoked for a single store")
	public void getStoreDetailsUsingStoreId(String apiEndPoint) {
		
		testContext.response = given().get("/"+apiEndPoint+"/"+testContext.storeId);
	}
	
	@Then("store the details of store in context")
	public void storeDetailsofStoreInContext(){
		StoresApiResponse storesApiResponse =  ResponseHandler.deserializedResponse(testContext.response,StoresApiResponse.class);
		Store store = storesApiResponse.data.get(0);
		testContext.session.put("storeDetails", store);
	}
	
	@Then("details of store are verified")
	public void verifyStoreDetails() {
		Store store = ResponseHandler.deserializedResponse(testContext.response, Store.class);
		System.out.println("store name :"+( (Store)(testContext.session.get("storeDetails"))).name);
		assertEquals(store.name,( (Store)(testContext.session.get("storeDetails"))).name);
	}
}
