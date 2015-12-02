package com.offla.rest;



import javax.mail.internet.*;
import javax.mail.internet.AddressException;

public class MailTester {


	
//	public static boolean isValidEmailAddress(java.lang.String email) {
//		   return result;
//		}
	public static void main(String[] args) {
		
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress("sssddds1133335788@gmail.com");
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		System.out.println(" This mail is valid: " + result);

	}
//
}
