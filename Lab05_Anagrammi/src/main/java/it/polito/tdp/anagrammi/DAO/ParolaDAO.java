package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import it.polito.tdp.anagrammi.model.Parola;


public class ParolaDAO {

	
	public boolean isCorrect (String anagramma) {
		final String sql = "SELECT nome FROM parola where nome= ? ";

		List<String> parolaNelDizionario = new ArrayList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				parolaNelDizionario.add(rs.getString("nome"));
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		if(parolaNelDizionario.size()==0)
		return false;
		else return true;
	}
	
	

}
