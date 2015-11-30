package com.offla.rest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;


@WebServlet("/RestClientServlet")
public class RestClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RestClientServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===doGet===");
		
		String url= "https://mobile.ng.bluemix.net/imfpush/v1/apps/b70335bf-cd13-4fc2-86d3-03d53ec50487/messages";
	    String message01= "{ \"message\": { \"alert\":\" Hi There whats up\"}}";
	    
	     org.apache.wink.client.ClientConfig clientConfig = new org.apache.wink.client.ClientConfig();
	     org.apache.wink.client.RestClient client= new org.apache.wink.client.RestClient(clientConfig);
	     org.apache.wink.client.Resource resource= client.resource(url);
	     resource.accept("application/json");
	     resource.acceptLanguage("en-US");
	     resource.contentType(MediaType.APPLICATION_JSON);
	     resource.header("appSecret", "3021fa6c-5fa0-4149-ad4c-cee7160a8b34");
	     resource.header("Application-Mode", "SANDBOX");
	    
	     org.apache.wink.client.ClientResponse resp= resource.post(message01);
	     String msg= (String) resp.getMessage();
	     System.out.println(msg);
	     System.out.println(resp.getStatusCode());
	     System.out.println(resp.getEntity(String.class));
	    
	     java.io.PrintWriter printWriter = response.getWriter();		
		 printWriter.println(resp.getEntity(String.class));
		 response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	}
	    
	    
	    /*
	    
	   org.apache.wink.client.ClientConfig clientConfig = new org.apache.wink.client.ClientConfig();
		
		org.apache.wink.client.RestClient client = new org.apache.wink.client.RestClient(clientConfig);
		org.apache.wink.client.Resource resource = client.resource("http://restservicessamples.mybluemix.net/banking/Greeting");
		org.apache.wink.client.ClientResponse resp = resource.get();
		String msg = (String) resp.getMessage();
		System.out.println(msg);
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getEntity(String.class));
		
		java.io.PrintWriter printWriter = response.getWriter();		
		printWriter.println(resp.getEntity(String.class));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*/

}
