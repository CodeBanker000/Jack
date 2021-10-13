/**
 * 
 */
package it.housework.controllers;

import java.io.IOException;

/**
 * Sample Skeleton for 'Outlet.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TableController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnLocals"
    private Button btnLocals; // Value injected by FXMLLoader

    @FXML // fx:id="btnOutlet"
    private Button btnOutlet; // Value injected by FXMLLoader

    @FXML // fx:id="boxLocals"
    private ComboBox<?> boxLocals; // Value injected by FXMLLoader

    @FXML // fx:id="boxOutlet"
    private ComboBox<?> boxOutlet; // Value injected by FXMLLoader

    @FXML
    void handleLocals(ActionEvent event) {

    }

    @FXML
    void handleOutlet(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Outlet.fxml"));
    	AnchorPane root = (AnchorPane) loader.load();
		
		//HomeController controller = loader.getController();
		//controller.passedUser(usr);
		//controller.setModel(new Model());
		//Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../styles/application.css").toExternalForm());
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.setTitle("RistoBar v1.0");
		stage.showAndWait();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnLocals != null : "fx:id=\"btnLocals\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert btnOutlet != null : "fx:id=\"btnOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert boxLocals != null : "fx:id=\"boxLocals\" was not injected: check your FXML file 'Outlet.fxml'.";
        assert boxOutlet != null : "fx:id=\"boxOutlet\" was not injected: check your FXML file 'Outlet.fxml'.";

    }
}
