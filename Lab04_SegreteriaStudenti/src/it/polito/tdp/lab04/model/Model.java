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

}
