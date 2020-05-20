package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Producto;

public class ProductoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//guardar
	public boolean guardar(Producto producto) {
		String sql=null;
		estadoOperacion=false;
		return true;
	}
	
	//editar
	public boolean editar(Producto producto) {
		return true;
	}
	
	//eliminar
	public boolean eliminar(int idProducto) {
		return true;
	}
	
	//Obtener lista de productos producto
	public List<Producto> obtenerProductos() {
		return null;
	}
	
	// Obtener producto
	public Producto obtenerProducto(int idProducto) {
		return null;
	}
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
