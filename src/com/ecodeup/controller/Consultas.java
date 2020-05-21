package com.ecodeup.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ecodeup.conexion.Conexion;


public class Consultas extends Conexion{

	public boolean autenticacion(String usuario, String contraseña) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String consulta = "select * from usuarios where usuario = ? and pass = ?";
			pst = getConnection().prepareStatement(consulta);
			pst.setString(1, usuario);
			pst.setString(2, contraseña);
			rs = pst.executeQuery();
			
			if(rs.absolute(1)) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("Error" + e);
		}finally {
			try {
				if(getConnection() != null) getConnection().close();
				if(pst != null) pst.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				System.err.println("Error" + e);
			}
		}
		return false;
	}
	
	public boolean registrar(String nombre, String apellido, String usuario, String contraseña, String correo ) {
		
		PreparedStatement pst = null;
		
		try {
			String consulta = "insert into usuarios (nombre, apellido, usuario, pass) values(?,?,?,?,?)";
			pst = getConnection().prepareStatement(consulta);
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setString(3, usuario);
			pst.setString(4, contraseña);
			pst.setString(5, correo);
			
			if(pst.executeUpdate() == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Error"+ e);
		}finally {
			try {
			if(getConnection() != null) getConnection().close();
			if(pst != null) pst.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return false;
	}
	
}
