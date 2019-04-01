package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	public List<String> getCorsi() {
		// TODO Auto-generated method stub
		CorsoDAO dao = new CorsoDAO();
		List<String> result= new ArrayList<String>();
		
		for(Corso c: dao.getTuttiICorsi())
			result.add(c.getNome());
		
		result.add("");
		return result;
	}

	public String getNomeCercato(int matricola) {
		// TODO Auto-generated method stub
		StudenteDAO dao= new StudenteDAO();
		System.out.println(dao.getNomeByMatricola(matricola));
		return dao.getNomeByMatricola(matricola);
	}

	public String getCognomeCercato(int matricola) {
		// TODO Auto-generated method stub
		StudenteDAO dao= new StudenteDAO();
		
		return dao.getCognomeByMatricola(matricola);
	}

	public String cercaIscrittiCorso(String value) {
		// TODO Auto-generated method stub
		CorsoDAO dao= new  CorsoDAO();
		String result="";
		
		for(String s: dao.getStudentiIscrittiAlCorso(dao.getCorso(value)))
			result+= s+"\n";
		
		return result.substring(0,result.length()-1);
	}

	public String cercaCorsiStudente(int text) {
		// TODO Auto-generated method stub
		StudenteDAO dao = new StudenteDAO();
		String result="";
		
		for(String s: dao.getCorsiStudenteByMatricola(text))
			result+= s+"\n";
			
		return result.substring(0,result.length()-1);
	}
	
	public String cercaCodCorsiStudente(int text) {
		// TODO Auto-generated method stub
		StudenteDAO dao = new StudenteDAO();
		String result="";
		
		for(String s: dao.getCodCorsiStudenteByMatricola(text))
			result+= s+"\n";
			
		return result.substring(0,result.length()-1);
	}

	public Studente cercaStudente(int text) {
		// TODO Auto-generated method stub
		StudenteDAO d = new StudenteDAO();
		
		return d.getStudenteByMatricola(text);
	}

	public String getCorso(String value) {
		// TODO Auto-generated method stub
		CorsoDAO dao = new CorsoDAO();
		
		return dao.getCorso(value).getId();
	}

	public String IscriviStudente(int parseInt, String value) {
		// TODO Auto-generated method stub

		CorsoDAO dao = new CorsoDAO();
		if(dao.inscriviStudenteACorso(this.cercaStudente(parseInt),this.getCorsoByNome(value)) == true)
			return "Iscrizione avvenuta con successo!";
		else return "Iscrizione non avvenuta!";
		
	}

	public Corso getCorsoByNome(String value) {
		// TODO Auto-generated method stub
		CorsoDAO c = new CorsoDAO();
		return c.getCorso(value);
	}

	public boolean verificaIscrizione(Studente cercaStudente, Corso corsoByNome) {
		// TODO Auto-generated method stub
		
		CorsoDAO c = new CorsoDAO();
		return c.verificaIscrizione(cercaStudente, corsoByNome);
	}

}
