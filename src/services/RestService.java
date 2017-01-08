package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import logic.ConditionHandler;

@Path("/conditions")
public class RestService {
	
	
	@GET
	@Produces("application/json")
	public Response returnConditions(){
		
		ConditionHandler conditionHandler = new ConditionHandler();
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Conditions", "zimno");
		
		
		conditionHandler.calculateConditions();
		
		String result = "@Produces(\"application/json\")" +jsonObj;
		
		return Response.status(200).entity(result).build();	
	}

}
