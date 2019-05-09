/**
 * Sample Skeleton for 'adminOperation.fxml' Controller Class
 */
package spg.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AdminOperation {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneAdminOperation"
    private BorderPane paneAdminOperation; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddFlight"
    private Button buttonAddFlight; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCancelFlight"
    private Button buttonCancelFlight; // Value injected by FXMLLoader

    @FXML // fx:id="buttonUpdateFlight"
    private Button buttonUpdateFlight; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSeekFlight"
    private Button buttonSeekFlight; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCancel"
    private Button buttonCancel; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneAdminOperation != null : "fx:id=\"paneAdminOperation\" was not injected: check your FXML file 'adminOperation.fxml'.";
        assert buttonAddFlight != null : "fx:id=\"buttonAddFlight\" was not injected: check your FXML file 'adminOperation.fxml'.";
        assert buttonCancelFlight != null : "fx:id=\"buttonCancelFlight\" was not injected: check your FXML file 'adminOperation.fxml'.";
        assert buttonUpdateFlight != null : "fx:id=\"buttonUpdateFlight\" was not injected: check your FXML file 'adminOperation.fxml'.";
        assert buttonSeekFlight != null : "fx:id=\"buttonSeekFlight\" was not injected: check your FXML file 'adminOperation.fxml'.";
        assert buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'adminOperation.fxml'.";

        buttonAddFlight.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AddFlight.fxml"));
                paneAdminOperation.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonCancelFlight.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("DeleteFlight.fxml"));
                paneAdminOperation.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonCancel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Initial.fxml"));
                paneAdminOperation.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
