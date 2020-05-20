package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Producto;

public class ProductoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//guardar
	public boolean guardar(Producto producto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			// campos de la base de datos donde se inserta, MODIFICAR
			sql="INSERT INTO productos(id, nombre, cantidad, precio, fecha_crear, fecha_actualizar) VALUES(?,?,?,?,?,?)"; //los signos de interrogación son la cantidad de campos de la tabla a modificar
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setString(2, producto.getNombre()); //obtener valor del objeto producto
			statement.setDouble(3, producto.getCantidad());
			statement.setDouble(4, producto.getPrecio());
			statement.setDate(5, producto.getFechaCrear());
			statement.setDate(6, producto.getFechaActualizar());
			
			estadoOperacion = statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		
		return estadoOperacion;
	}
	
	//editar
	public boolean editar(Producto producto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql="UPDATE productos SET nombre=?, cantidad=?, precio=?, fecha_actualizar=? WHERE id=?";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, producto.getNombre());
			statement.setDouble(2, producto.getCantidad());
			statement.setDouble(3, producto.getPrecio());
			statement.setDate(4, producto.getFechaActualizar());
			statement.setInt(5, producto.getId());
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	//eliminar
	public boolean eliminar(int idProducto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql="DELETE FROM productos WHERE id=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idProducto);
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	//Obtener lista de productos producto
	public List<Producto> obtenerProductos() throws SQLException {
		ResultSet resultSet=null;
		List<Producto> listaProductos= new ArrayList<>();
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		
		try {
			sql="SELECT * FROM productos";
			resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
				Producto p = new Producto();
				p.setId(resultSet.getInt(1));
				p.setNombre(resultSet.getString(2));
				p.setCantidad(resultSet.getDouble(3));
				p.setPrecio(resultSet.getDouble(4));
				p.setFechaCrear(resultSet.getDate(5));
				p.setFechaActualizar(resultSet.getDate(6));
				listaProductos.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaProductos;
	}
	
	// Obtener producto
	public Producto obtenerProducto(int idProducto) throws SQLException {
		ResultSet resultSet=null;
		Producto p = new Producto();
		
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		
		try {
			sql="SELECT * FROM productos WHERE id =?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idProducto);
			
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
				
				p.setId(resultSet.getInt(1));
				p.setNombre(resultSet.getString(2));
				p.setCantidad(resultSet.getDouble(3));
				p.setPrecio(resultSet.getDouble(4));
				p.setFechaCrear(resultSet.getDate(5));
				p.setFechaActualizar(resultSet.getDate(6));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
