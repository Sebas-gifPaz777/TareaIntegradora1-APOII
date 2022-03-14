package application;
	
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import controller.Cinema1Controller;
import controller.Cinema2Controller;
import controller.LoginController;
import controller.MenuController;
import controller.NewEventController;
import controller.PreRoomController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CreateEvent;
import model.InterruptionOfHoursException;
import model.Login;
import model.PasswordNotMatchException;
import model.Room1;
import model.Room2;
import model.UserNotFoundException;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Login login;
	private Stage currentStage;
	private CreateEvent ce;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			showLogin();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showLogin() {
		try {
			
			BorderPane root;
			
			FXMLLoader loader= new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
			root= (BorderPane)loader.load();
			
			LoginController controller=loader.getController();
			controller.setMain(this);
			
			
			Scene scene=new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage= new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage=stage;
			login=new Login();
			ce= new CreateEvent();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void checkUser(String password, String id) throws UserNotFoundException, PasswordNotMatchException {
			login.searchInfor(password, id);
	}
	
	public void showMainView() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Menu.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			MenuController controller=loader.getController();
			
			controller.setMain(this);
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			stage.setHeight(list1.getPrefHeight());
			stage.setWidth(list1.getPrefWidth());	
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void showNewEvent() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/NewEvent.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			NewEventController controller=loader.getController();
			
			controller.setMain(this);
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void showPreRoom() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/PreRoom.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			PreRoomController controller=loader.getController();
			
			controller.setMain(this);
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void createFilm(LocalTime lt, LocalTime lt2, String type, String text, LocalDate date) throws InterruptionOfHoursException {
		ce.checkFilms( lt, lt2, type, text, date);
	}
	
	public ArrayList<Room1> getRoom1() {
		ArrayList<Room1>gt=ce.getRoom1();
		return gt; 
	}
	
	public ArrayList<Room2> getRoom2(){
		ArrayList<Room2>gt=ce.getRoom2();
		return gt; 
	}

	public void showCinema1() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Cinema1.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			Cinema1Controller controller=loader.getController();
			
			controller.setMain(this);
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void showCinema2() {
		try {
			BorderPane root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Cinema2.fxml"));
			BorderPane list1= (BorderPane)loader.load();
			
			Stage stage = currentStage;
			Cinema2Controller controller=loader.getController();
			
			controller.setMain(this);
			
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(null);
			root.setCenter(list1);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
