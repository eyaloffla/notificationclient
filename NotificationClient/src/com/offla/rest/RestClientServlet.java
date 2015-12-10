package com.offla.rest;

import java.io.IOException;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.ibm.websphere.security.cred.WSCredential;
import com.worklight.oauth.tai.WLCredential;
import com.ibm.json.java.JSONObject;
import com.ibm.websphere.security.WSSecurityException;
import com.ibm.websphere.security.auth.WSSubject;


@WebServlet("/RestClientServlet/07ba396e-a2ed-4a18-88e6-26c5401c75c0")
@ServletSecurity(@HttpConstraint(rolesAllowed={"TAIUserRole"}))
public class RestClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RestClientServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===doGet===");
		
		String url= "https://mobile.ng.bluemix.net/imfpush/v1/apps/49500464-58f0-4178-976d-a3d0b3c61170/messages";
	    String message01= "{ \"message\": { \"alert\":\" http://websphere-application-server-03.mybluemix.net/offlaFrontEnd/TextBitsMap\"}}";
	    
	     org.apache.wink.client.ClientConfig clientConfig = new org.apache.wink.client.ClientConfig();
	     org.apache.wink.client.RestClient client= new org.apache.wink.client.RestClient(clientConfig);
	     org.apache.wink.client.Resource resource= client.resource(url);
	     resource.accept("application/json");
	     resource.acceptLanguage("en-US");
	     resource.contentType(MediaType.APPLICATION_JSON);
	     resource.header("appSecret", "58533377-2567-47db-9b5b-69237b8eb199");
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
	
	private WSCredential getTokenSecurityCredentials() throws WSSecurityException{
		Subject callerSubject = WSSubject.getCallerSubject();
		WSCredential callerCredential = callerSubject.getPublicCredentials(WSCredential.class).iterator().next();
		
		WLCredential callerWLCredential = callerSubject.getPublicCredentials(WLCredential.class).iterator().next();
		
		JSONObject securityContext = callerWLCredential.getSecurityContext();
		String userIdentity = (String) securityContext.get("imf.sub");
		JSONObject imfUser = (JSONObject) securityContext.get("imf.user");
		JSONObject imfDevice = (JSONObject) securityContext.get("imf.device");
		JSONObject imfApplication = (JSONObject) securityContext.get("imf.application");
		
		return callerCredential;
	}
	    
	    

}
