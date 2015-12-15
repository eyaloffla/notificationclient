package com.offla.servlet;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/offla")
@ServletSecurity(@HttpConstraint(rolesAllowed={"TAIUserRole"}))
public class BaseServlet extends HttpServlet{
	
	

}
