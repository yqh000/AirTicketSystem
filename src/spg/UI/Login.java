package spg.UI;
/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class Login {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneLogin"
    private FlowPane paneLogin; // Value injected by FXMLLoader

    @FXML // fx:id="buttonLogin"
    private Button buttonLogin; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCancel"
    private Button buttonCancel; // Value injected by FXMLLoader

    @FXML // fx:id="textUsername"
    private TextField textUsername; // Value injected by FXMLLoader

    @FXML // fx:id="textPassword"
    private PasswordField textPassword; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneLogin != null : "fx:id=\"paneLogin\" was not injected: check your FXML file 'login.fxml'.";
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'login.fxml'.";
        assert buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'login.fxml'.";
        assert textUsername != null : "fx:id=\"textUsername\" was not injected: check your FXML file 'login.fxml'.";
        assert textPassword != null : "fx:id=\"textPassword\" was not injected: check your FXML file 'login.fxml'.";

    }
}
