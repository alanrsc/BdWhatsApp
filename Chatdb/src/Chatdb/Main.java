package Chatdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/chat_db";
        String usuario = "postgres";
        String contrasena = "2001";
		
		try {
			Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, usuario, contrasena); 
            String query = "SELECT id, name, lastname, username, password FROM public.users;";
            PreparedStatement prStatement = conn.prepareStatement(query);
           
            //ResultSet resultSet = query.executeQuery();
            /*
            while(resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
            	String lastname = resultSet.getString("lastname");
            	String username = resultSet.getString("username");
            	
            	System.out.println(id +" "+ name +" "+ lastname + " " + username);
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
	
}
