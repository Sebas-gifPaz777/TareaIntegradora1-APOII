package controller;

import java.util.ArrayList;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.EmptyElementsException;
import model.Room1;
import model.Seat;

public class Cinema1Controller {
	
	private Main main;
	
	@FXML
	private ComboBox<String> cbFilms;

	@FXML
	private RadioButton a1,a2,a3,a4,a5,a6,a7,b1,b2,b3,b4,b5,b6,b7,c1,c2,c3,c4,c5,c6,c7,d1,d2,d3,d4,d5,d6,d7;

	@FXML
	private TextField tfId;

	@FXML
	private TextField tfName;
	
	@FXML
    private Button btBooking;
	
	private ArrayList<Room1>r1;
	
	private String[]films;
	
	private RadioButton[] seats={a1,a2,a3,a4,a5,a6,a7,b1,b2,b3,b4,b5,b6,b7,c1,c2,c3,c4,c5,c6,c7,d1,d2,d3,d4,d5,d6,d7};
	
	private Seat[] rm;
	
	public void initialize() {
		r1=main.getRoom1();
		
		films=new String[r1.size()];
		
		for(int i=0;i<films.length;i++) {
			films[i]=r1.get(i).getArray()[0].getNameFilm();
		}
		
		ObservableList<String> options = FXCollections.observableArrayList(films);
		cbFilms.setItems(options);
		
		btBooking.setOnAction((ActionEvent e) ->{
			
			try {
				if(tfId.getText().equals("") || tfName.getText().equals(""))
					throw new EmptyElementsException();
				for(int i=0;i<seats.length;i++) {
					if(seats[i].isSelected()) {
						rm[i].setNameOccupant(tfName.getText());
						seats[i].setDisable(true);
					}
				}
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("Registro");
				alert.setContentText("El estudiante ha sido registrado");
				tfName.setText("");
				tfId.setText("");
			}catch(EmptyElementsException | NullPointerException e1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				if(e1 instanceof EmptyElementsException) {
					alert.setHeaderText("Error en información ");
					alert.setContentText("Complete todos los campos requeridos");
				}
				if(e1 instanceof NullPointerException) {
					alert.setHeaderText("Error de Ejecución");
					alert.setContentText("Por favor inicialmente, cargue un filme programado");
				}
				alert.showAndWait();	
			}
			
		});
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	@FXML
	public void searchSeats(ActionEvent event) {
		
		try {
			String op=cbFilms.getValue();
			if(op.equals(""))
				throw new EmptyElementsException();
			searchSeatsC(op);
		}catch(EmptyElementsException e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Valor no seleccionado");
			alert.setContentText("Escoja una opción de los filmes disponibles");
			alert.showAndWait();
		}
		
	}
	
	public void searchSeatsC(String op) {
		for(int i=0;i<r1.size();i++) {
			if(r1.get(i).getArray()[0].getNameFilm().equals(op)) {
				rm=r1.get(i).getArray();
				for(int j=0;j<rm.length;j++) {
					if(!rm[j].getNameOccupant().equals(""))
						seats[j].setDisable(true);
				}
			}
		}
	}
	
	@FXML
	public void backScene() {
		main.showMainView();
	}
}
