package com.offla.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@javax.ws.rs.ApplicationPath("/resources")
@Path("/simple")
public class SimpleWS extends javax.ws.rs.core.Application{
	
	@Context
    private UriInfo context;

    @GET
    @Produces("application/json")
    @Path("/hi")
    public String getXml() {
        return "Hello Rest World !";
    }
	
	
	//@Path("/message")
	//public String message(){
	//	return "Shalom";
	//}

}
