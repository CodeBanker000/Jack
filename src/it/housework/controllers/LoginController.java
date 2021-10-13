/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package it.housework.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.housework.model.Model;
import it.housework.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtFldUser"
    private TextField txtFldUser; // Value injected by FXMLLoader

    @FXML // fx:id="txtSms"
    private Text txtSms; // Value injected by FXMLLoader

    @FXML // fx:id="btnSubmit"
    private Button btnSubmit; // Value injected by FXMLLoader

    @FXML // fx:id="pwdFldPass"
    private PasswordField pwdFldPass; // Value injected by FXMLLoader

    @FXML
    void f50606(ActionEvent event) {}

    @FXML
    void handleSubmit(ActionEvent event) throws IOException
    {
    	String user = txtFldUser.getText();
        String pass = pwdFldPass.getText();
        
        User usr = this.model.findUser(user, pass);
        
        if (usr == null) {
            txtSms.setText("name or pass is invalid.");
        } else {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Home.fxml"));
        	VBox root = (VBox) loader.load();
			
			HomeController controller = loader.getController();
			controller.passedUser(usr);
			//controller.setModel(new Model());
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../styles/application.css").toExternalForm());
			window.hide();
			window.setScene(scene);
			window.setTitle("RistoBar v1.0 :: Home");
			window.show();
        	
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
        assert txtFldUser != null : "fx:id=\"txtFldUser\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtSms != null : "fx:id=\"txtSms\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnSubmit != null : "fx:id=\"btnSubmit\" was not injected: check your FXML file 'Login.fxml'.";
        assert pwdFldPass != null : "fx:id=\"pwdFldPass\" was not injected: check your FXML file 'Login.fxml'.";

    }
    
    /**
     * @param model name of the model to set
     */
    public void setModel(Model model) {
        this.model = model;
    }
}