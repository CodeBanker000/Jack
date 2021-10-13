/**
 * Sample Skeleton for 'Home.fxml' Controller Class
 */

package it.housework.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.housework.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnOutlet"
    private Button btnOutlet; // Value injected by FXMLLoader

    @FXML // fx:id="btnOutlet"
    private Button btnArchive; // Value injected by FXMLLoader

    @FXML // fx:id="labelUser"
    private Label labelUser; // Value injected by FXMLLoader

    @FXML // fx:id="btnGraph"
    private Button btnGraph; // Value injected by FXMLLoader

    @FXML // fx:id="btnMenu"
    private Button btnMenu; // Value injected by FXMLLoader

    @FXML
    void handleOutlet(ActionEvent event) throws IOException 
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Table.fxml"));
    	AnchorPane root = (AnchorPane) loader.load();
		
		//HomeController controller = loader.getController();
		//controller.passedUser(usr);
		//controller.setModel(new Model());
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../styles/application.css").toExternalForm());
		window.hide();
		window.setScene(scene);
		window.setTitle("RistoBar v1.0");
		window.show();
    }

    @FXML
    void handleMenu(ActionEvent event) {

    }

    @FXML
    void handleGraph(ActionEvent event) {

    }

    @FXML
    void handleArchive(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnOutlet != null : "fx:id=\"btnOutlet\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnArchive != null : "fx:id=\"btnArchive\" was not injected: check your FXML file 'Home.fxml'.";
        assert labelUser != null : "fx:id=\"labelUser\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnGraph != null : "fx:id=\"btnGraph\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'Home.fxml'.";

    }
    
    public void passedUser(User user)
    {
    	labelUser.setText(user.getName());
    }
}