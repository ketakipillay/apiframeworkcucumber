package hooks;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import static io.restassured.RestAssured.*;
import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import  io.restassured.specification.RequestSpecification;
import utils.RestAssuredRequestFilter;

public class Hooks {


	private static final Logger LOG = LogManager.getLogger(Hooks.class);
	
	
	
	@Before
	public void testStart(Scenario scenario) {
		LOG.info("*****************************************************************************************");
		LOG.info("	Scenario: "+scenario.getName());
		LOG.info("*****************************************************************************************");
	
		reset();
		Options options = Options.builder().logStacktrace().build();
		 config = CurlRestAssuredConfigFactory.createConfig(options);
		baseURI = "http://localhost:3030";
		 RestAssured.requestSpecification =given().config(config).filter(new RestAssuredRequestFilter()).contentType("application/json").accept("application/json");
	}
}
