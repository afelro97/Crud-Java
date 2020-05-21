package com.ecodeup.controller;

import com.ecodeup.controller.Consultas;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/iniciar")
public class InicioSesion extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-U");
		PrintWriter out = response.getWriter();
		
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("pass");
		String correo = request.getParameter("correo");
		
		Consultas co = new Consultas();
		if(co.autenticacion(usuario, contraseña)) { //cambiar a inicio de sesion de la app
			HttpSession objsession = request.getSession(true);
			objsession.setAttribute("usuario", usuario);
			
			response.sendRedirect("menu.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}
	
	protected void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	               throws ServletException,
	                      java.io.IOException {
	processRequest(request, response);
	}
	
	

}
