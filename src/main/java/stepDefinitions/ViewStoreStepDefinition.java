package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import utils.TestContext;

import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ViewStoreStepDefinition {

 private static final Logger LOG = LogManager.getLogger(ViewStoreStepDefinition.class);

	
	
	TestContext testContext;
		
	public ViewStoreStepDefinition(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("{string} api is invoked")
	public void api_is_invoked(String stores) {
	    	 
	  testContext.response = RestAssured.requestSpecification.get("/"+stores);
	}

	@Then("{int} response code is returned")
	public void response_code_is_returned(Integer respCode) {
	    // Write code here that turns the phrase above into concrete actions
	   assertEquals(Long.valueOf(respCode),Long.valueOf(testContext.response.statusCode()) );
	}
	
	@Then("verify the schema with {string}")
	public void verifySchema(String schemaFileName) {
		System.out.println("schema name :"+schemaFileName);
		testContext.response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/"+schemaFileName));
	}
}
