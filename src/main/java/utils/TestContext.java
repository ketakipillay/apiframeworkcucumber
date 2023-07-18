package utils;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class TestContext {

	public Response response;
	public int storeId;
	public Map<String, Object> session = new HashMap<String, Object>();
	
}
