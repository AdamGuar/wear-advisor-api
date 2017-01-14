package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import logic.ConditionHandler;
import model.Conditions;

@Path("/conditions")
public class RestService {
	
	private static final Logger logger = Logger.getLogger(RestService.class);
	
	@GET
	@Path("/{city}")
	@Produces(MediaType.APPLICATION_JSON)
	public Conditions returnConditions(@PathParam("city") String city){
		
		logger.info("Rest call for city {city} registered");
		
		ConditionHandler conditionHandler = new ConditionHandler();
		
		JSONObject jsonObj = new JSONObject();
		
		
		Conditions conditions = new Conditions();
		
		conditionHandler.fetchConditions(city,conditions);
		
		jsonObj.put("Conditions",conditions);
		
		
		String result = "@Produces(\"application/json\")" +jsonObj;
		
		logger.info("Call succed, returning result=");
		
		return conditions;
	}

}
