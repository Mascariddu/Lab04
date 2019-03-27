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

	private Model modello = new Model();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button BtnFatto;

    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    private Button BtnCercaIscritti;

    @FXML
    private TextField TxtMatricola;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtCognome;

    @FXML
    private Button BtnCercaCorsi;

    @FXML
    private Button BtnIscriviti;

    @FXML
    private TextArea TxtResult;

    @FXML
    private Button BtnReset;

    @FXML
    void DoCercaCorsi(ActionEvent event) {

    }

    @FXML
    void DoCercaIscritti(ActionEvent event) {

    }

    @FXML
    void DoIscrizione(ActionEvent event) {

    }

    @FXML
    void DoReset(ActionEvent event) {

    }
    
    @FXML
    void DoFatto(ActionEvent event) {
    	TxtNome.setText(modello.getNomeCercato(Integer.parseInt(TxtMatricola.getText())));
    	TxtCognome.setText(modello.getCognomeCercato(Integer.parseInt(TxtMatricola.getText())));
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
        assert TxtNome != null : "fx:id=\"TxtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert TxtCognome != null : "fx:id=\"TxtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnCercaCorsi != null : "fx:id=\"BtnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnIscriviti != null : "fx:id=\"BtnIscriviti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert TxtResult != null : "fx:id=\"TxtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert BtnReset != null : "fx:id=\"BtnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
}

