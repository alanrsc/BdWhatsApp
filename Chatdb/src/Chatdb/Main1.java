package Chatdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main1 {
	
	public class Conn {
		
		static String url = "jdbc:postgresql://localHost:5432/BaseDeDatos";
		static String usuario = "postgres";
		static String contrasena = "Alancito2004";
			
		public static Connection open () throws SQLException{
			Connection conn = DriverManager.getConnection(url, usuario, contrasena);
			return conn;
		}

	}
	
	public static void mostrarUsuarios() {
		Connection conn = null;
		PreparedStatement query;
		
		try {
			
			Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/BaseDeDatos";
            String usuario = "postgres";
            String contrasena = "Alancito2004";
            
            conn = DriverManager.getConnection(url, usuario, contrasena);

            String sql = "SELECT id_usuarios, nombre, apellidos, username, contraseña FROM public.usuarios;";
            query = conn.prepareStatement(sql);
            
            ResultSet resultSet = query.executeQuery();
            
            while(resultSet.next()) {
            	int id = resultSet.getInt("id_usuarios");
            	String name = resultSet.getString("nombre");
            	String lastname = resultSet.getString("apellidos");
            	String username = resultSet.getString("username");
            	
            	System.out.println(id +" "+ name +" "+ lastname + " " + username);
            }
            /*
            if (conn != null) {
            	System.out.println("Conexión exitosa a la base de datos PostgreSQL");
            }
			*/
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ingresarUsuario() {
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Ingrese id usuario: ");
		int id = leer.nextInt();
		System.out.println("Ingrese Nombre: ");
		String name = leer.next();
		System.out.println("Ingrese Apellido: ");
		String lastname = leer.next();
		System.out.println("Ingrese Nombre de Usuario: ");
		String username = leer.next();
		System.out.println("Ingrese Contraseña: ");
		int password = leer.nextInt();
		
		PreparedStatement query;
		try {
			
            String url = "jdbc:postgresql://localhost:5432/BaseDeDatos";
            String usuario = "postgres";
            String contrasena = "Alancito2004";
            Connection conn = DriverManager.getConnection(url, usuario, contrasena);
			
			String sql = "Insert into public.usuarios(id_usuarios, nombre, apellidos, username, contraseña) values(?,?,?,?,?);";
			query = conn.prepareStatement(sql);
			query.setInt(1, id);
			query.setString(2, name);
			query.setString(3, lastname);
			query.setString(4, username);
			query.setInt(5, password);
			query.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getCause());
		}
	}
	
	public static void modificarUsuario() {
		Scanner leer = new Scanner(System.in);
	    System.out.println("Ingrese id del usuario a modificar: ");
	    int id = leer.nextInt();
	    System.out.println("Ingrese el nuevo nombre: ");
	    String name = leer.next();
	    System.out.println("Ingrese el nuevo apellido: ");
	    String lastname = leer.next();
	    System.out.println("Ingrese el nuevo nombre de usuario: ");
	    String username = leer.next();
	    System.out.println("Ingrese la nueva contraseña: ");
	    int password = leer.nextInt();
	    PreparedStatement query;
	    
	    try {
	        String url = "jdbc:postgresql://localhost:5432/BaseDeDatos";
	        String usuario = "postgres";
	        String contrasena = "Alancito2004";
	        Connection conn = DriverManager.getConnection(url, usuario, contrasena);

	        //String sql = "UPDATE public.users SET name = " + name + ", lastname = " + lastname + ", username = " + username + ", password = " + password 
	        //		+ "WHERE id = " + id + ";";
	        
	        String sql = "UPDATE public.usuarios SET nombre= " + name + "apellidos=" + lastname + "username= " + username + "contraseña= " + password  
	        		+ "WHERE id + " + id +";";
	        
	        query = conn.prepareStatement(sql);
	        
	        ///query.setInt(1, id);
	        query.setString(1, name);
	        query.setString(2, lastname);
	        query.setString(3, username);
	        query.setInt(4, password);
	        
	        query.executeUpdate();
	        System.out.println("actualizado con exito");
	       
	    } catch (SQLException e) {
	        System.out.println(e.getCause());
	    }
	    
	}
	
	public static void eliminarUsuario() {
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Ingrese el id del usuario que desee eliminar: ");
		int id = leer.nextInt();
		
		PreparedStatement query;
		try {
			
            String url = "jdbc:postgresql://localhost:5432/BaseDeDatos";
            String usuario = "postgres";
            String contrasena = "Alancito2004";
            Connection conn = DriverManager.getConnection(url, usuario, contrasena);
			
			String sql = "DELETE FROM public.usuarios "
					+ "WHERE id = "
					+ id + ";";
			query = conn.prepareStatement(sql);
			
			query.executeUpdate();
			
			System.out.println("Usuario eliminado con exito...");
			
		}catch(SQLException e) {
			System.out.println(e.getCause());
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner ingreso = new Scanner(System.in);
		int options = -1;
		
		do {
			System.out.println("<1> Mostrar usuarios");
			System.out.println("<2> Ingresar usuarios");
			System.out.println("<3> Modificar usuario");
			System.out.println("<4> Eliminar usuarios");
			System.out.println("<0> salir");
			
			options = ingreso.nextInt();
			
			if(options == 1) {
				System.out.println("Usuarios/ln");
				mostrarUsuarios();
			}else if(options == 2) {
				System.out.println("Ingresar usuario/ln");
				ingresarUsuario();
			}else if(options == 3) {
				System.out.println("Modificar usuario");
				modificarUsuario();
			}else if(options == 4) {
				System.out.println("Eliminar usuario");
				eliminarUsuario();
			}
		}while(options != 0);
		
		System.out.println("....");
		
	}
}
