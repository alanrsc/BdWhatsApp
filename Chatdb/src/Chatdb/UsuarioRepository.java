package Chatdb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//import dominio.Usuario;

public class UsuarioRepository {

	public List<Usuario> getUsuarios(){
		
		List<Usuario> usuarios = new ArrayList<Usuario>();	
		
		String sql = "SELECT id, name, lastname, username, password FROM public.users;";
        PreparedStatement query;
        
        /*
        try {
        	query = Conn.open().prepareStatement(sql);
        	ResultSet resulSet = query.executeQuery();
        	
        	while (resulSet.next()) {
        		int id = resulSet.getInt("id");
        		String name = resulSet.getString("name");
        		String lastname = resulSet.getString("lastname");
        		String username = resulSet.getString("username");
        		
        		Usuario user = new Usuario(id, name, lastname, username);
        		usuarios.add(user);
        	}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
		return null;
		
	}
	
}
