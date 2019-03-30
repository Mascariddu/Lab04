package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	
	StudenteDAO stud = new StudenteDAO();
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(codins,numeroCrediti,nome,periodoDidattico));
			}
			
			return corsi;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorsoByCod(String codCorso) {
		// TODO
		final String sql= "SELECT * FROM corso WHERE codins = ?";
		Corso c=new Corso();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, codCorso);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				c = new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
			}
			
			System.out.println(c.toString());
			return c;
			
		} catch(SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}
	
	public Corso getCorso(String corso) {
		// TODO
		final String sql= "SELECT * FROM corso WHERE nome = ?";
		Corso c=new Corso();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, corso);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				c = new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
			}
			
			System.out.println(c.toString());
			return c;
			
		} catch(SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<String> getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		final String sql= "SELECT matricola FROM iscrizione WHERE codins= ? ";
		List<String> studenti = new LinkedList<String>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getId());
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				studenti.add(stud.getStudenteByMatricola(rs.getInt("matricola")).toString());
				
			}
			
			
			return studenti;
			
		} catch(Exception e) {
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
}
