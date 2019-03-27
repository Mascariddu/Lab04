package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public String getNomeByMatricola(int matricola) {
		// TODO Auto-generated method stub
		
		Studente s=new Studente();
		final String sql = "SELECT * FROM studente WHERE matricola= ?";
		
		try {
			
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				s= new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
			}
			
			conn.close();
			System.out.println(s.getNome());
			return s.getNome();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public String getCognomeByMatricola(int matricola) {
		// TODO Auto-generated method stub
		
		Studente s=null;
		final String sql = "SELECT * FROM studente WHERE matricola=?";
		
		try {
			
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				s= new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
			}
			
			conn.close();
			System.out.println(s.getCognome());
			return s.getCognome();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
