package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
			
			//System.out.println(s.getCognome());
			if(s!= null)
			return s.getCognome();
			else return null;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public Studente getStudenteByMatricola(int matricola) {
		// TODO Auto-generated method stub
		
		Studente s=new Studente();
		final String sql = "SELECT * FROM studente WHERE matricola=?";
		
		try {
			
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				s.setMatricola(rs.getInt("matricola"));
				s.setCDS(rs.getString("CDS"));
				s.setCognome(rs.getString("cognome"));
				s.setNome(rs.getString("nome"));
			}
			
			return s;
			
		} catch(Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	public List<String> getCorsiStudenteByMatricola(int text) {
		// TODO Auto-generated method stub
		final String sql = "SELECT * FROM iscrizione WHERE matricola = ? ";
		CorsoDAO corso= new CorsoDAO();
		List<String> corsi = new LinkedList<String>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, text);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				corsi.add(corso.getCorsoByCod(rs.getString("codins")).toString());
			}
			
			return corsi;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
			
		}
		
	}

}
