package com.ecodeup.controller;

import com.ecodeup.controller.Consultas;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrarUsuarios
 */
@WebServlet("/nuevousuario")
public class RegistrarUsuarios extends HttpServlet {
	
	protected void processRequest (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String usuario = request.getParameter("usuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String contraseña = request.getParameter("pass");
		String correo = request.getParameter("correo");
		
		
		Consultas co = new Consultas();
		if(co.registrar(nombre, apellido, usuario, contraseña, correo)) {
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("registro.jsp");
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

