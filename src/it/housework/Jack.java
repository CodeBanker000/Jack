package it.housework;
	
import it.housework.controllers.LoginController;
import it.housework.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;


public class Jack extends Application {
	
	@Override
	public void start(Stage window) throws Exception
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./views/Login.fxml"));
            Parent root = (Parent) loader.load();
            LoginController controller = loader.getController();
            controller.setModel(new Model());

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("./styles/application.css").toExternalForm());
            window.setScene(scene);
            window.setTitle("RistoBar v1.0 :: Login");
            window.show();
	}
	
	public static void main(String[] args) 
        {
		launch(args);
	}
}
