package Chatdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	static String url = "jdbc:postgresql://localHost:5432/chat_db";
	static String usuario = "postgres";
	static String contrasena = "2001";
		
	public static Connection open () throws SQLException{
		Connection conn = DriverManager.getConnection(url, usuario, contrasena);
		return conn;
	}
}