package com.offla.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ws")
public class SimpleWS01 {
	
	@GET
    @Produces("application/xml")
    @Path("/hi01")
    public String getXml() {
        return "<xml>Hello Rest World !</xml>";
    }

}
