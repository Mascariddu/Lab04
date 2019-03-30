package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model modello= new Model();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    private Button BtnCercaIscritti;

    @FXML
    private TextField TxtMatricola;

    @FXML
    private Button BtnFatto;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtCognome;

    @FXML
    private Button BtnCercaCorsi;

    @FXML
    private Button BtnIscriviti;

    @FXML
    private Button BtnIscrizione;

    @FXML
    private TextArea TxtResult;

    @FXML
    private Button BtnReset;



@FXML
    void DoCercaCorsi(ActionEvent event) {
    	
    	TxtResult.clear();
    	
    	try {
    		
    		if(modello.cercaCorsiStudente(Integer.parseInt(TxtMatricola.getText())) != "")
    			TxtResult.appendText(modello.cercaCorsiStudente(Integer.parseInt(TxtMatricola.getText())));
    		else if(modello.cercaStudente(Integer.parseInt(TxtMatricola.getText())) != null)
    			TxtResult.appendText("Matricola che non segue alcun corso");
    			else TxtResult.appendText("Matricola non esistente");
    		
    		
    	} catch (Exception e) {
    		TxtResult.appendText("Matricola non esistente");
    	}

    }

@FXML
void DoVerifica(ActionEvent event) {
	
	try {
		
		if(modello.cercaCorsiStudente(Integer.parseInt(TxtMatricola.getText())).contains(modello.getCorso(ComboBox.getValue())))
			TxtResult.appendText("Studente iscritto al corso \n");
		else TxtResult.appendText("Studente non iscritto al corso \n");
		
	} catch(Exception e) {
		
		TxtResult.appendText("Inserire valori validi");
		
	}
	
}

@FXML
void DoCercaIscritti(ActionEvent event) {

	TxtResult.clear();
	
	if(ComboBox.getValue()!= "") {
		if(modello.cercaIscrittiCorso(ComboBox.getValue()) != "")
			TxtResult.appendText(modello.cercaIscrittiCorso(ComboBox.getValue()));
		else TxtResult.appendText("Nessuno studente");
	}
	else TxtResult.appendText("Nessun corso selezionato");
	
	if(ComboBox.getValue() == null) {
		TxtResult.appendText("Nessun corso selezionato");
	}
	
	
}

@FXML
void DoIscrizione(ActionEvent event) {

}

@FXML
void DoReset(ActionEvent event) {
	
	TxtResult.clear();
	TxtMatricola.clear();
	TxtNome.clear();
	TxtCognome.clear();

}

@FXML
void DoFatto(ActionEvent event) {
	
	TxtResult.clear();
	
	try {
	TxtNome.setText(modello.getNomeCercato(Integer.parseInt(TxtMatricola.getText())));
	TxtCognome.setText(modello.getCognomeCercato(Integer.parseInt(TxtMatricola.getText())));
	} catch(Exception n) {
		TxtResult.appendText("Inserire una matricola numerica esistente");
	}
	

	if(modello.getNomeCercato(Integer.parseInt(TxtMatricola.getText())) == null)
		TxtResult.appendText("Studente inesistente");
		
}

public void setModel(Model m) {
	this.modello=m;
	this.ComboBox.getItems().addAll(modello.getCorsi());
}
    @FXML
    void initialize() {
        assert ComboBox != null : "fx:id=\"ComboBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnCercaIscritti != null : "fx:id=\"BtnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert TxtMatricola != null : "fx:id=\"TxtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnFatto != null : "fx:id=\"BtnFatto\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert TxtNome != null : "fx:id=\"TxtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert TxtCognome != null : "fx:id=\"TxtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnCercaCorsi != null : "fx:id=\"BtnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnIscriviti != null : "fx:id=\"BtnIscriviti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnIscrizione != null : "fx:id=\"BtnIscrizione\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert TxtResult != null : "fx:id=\"TxtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnReset != null : "fx:id=\"BtnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
}


