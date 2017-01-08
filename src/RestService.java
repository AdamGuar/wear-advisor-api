
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/conditions")
public class RestService {
	
	
	@GET
	@Produces("application/json")
	public Response returnConditions(){
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Conditions", "zimno");
		
		String result = "@Produces(\"application/json\")" +jsonObj;
		
		return Response.status(200).entity(result).build();	
	}

}
