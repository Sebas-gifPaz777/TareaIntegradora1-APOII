package controller;

import java.util.ArrayList;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.EmptyElementsException;
import model.Room1;

public class Cinema1Controller {
	
	private Main main;
	
	@FXML
	private ComboBox<String> cbFilms;

	@FXML
	private Button a1,a2,a3,a4,a5,a6,a7,b1,b2,b3,b4,b5,b6,b7,c1,c2,c3,c4,c5,c6,c7,d1,d2,d3,d4,d5,d6,d7;

	@FXML
	private TextField tfId;

	@FXML
	private TextField tfName;
	
	private ArrayList<Room1>r1;
	
	private String[]films;
	
	private Button[] seats;
	
	public void initialize() {
		r1=main.getRoom1();
		
		films=new String[r1.size()];
		
		for(int i=0;i<films.length;i++) {
			films[i]=r1.get(i).getArray()[0].getNameFilm();
		}
		
		ObservableList<String> options = FXCollections.observableArrayList(films);
		cbFilms.setItems(options);
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	@FXML
	public void searchSeats() {
		
		try {
			if(cbFilms.getValue().equals(""))
				throw new EmptyElementsException();
		}catch(EmptyElementsException e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Valor no seleccionado");
			alert.setContentText("Escoja una opci�n de los filmes disponibles");
			alert.showAndWait();
		}
		
	}
}
