package application;
	
import java.io.IOException;

import controller.LoginController;
import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Login;
import model.PasswordNotMatchException;
import model.UserNotFoundException;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Login login;
	private Stage currentStage;
	
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
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
