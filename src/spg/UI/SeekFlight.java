/**
 * Sample Skeleton for 'seekFlight.fxml' Controller Class
 */

package spg.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import spg.FlightOperation;

public class SeekFlight {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneDeleteFlight"
    private FlowPane paneDeleteFlight; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCancel"
    private Button buttonCancel; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightNum"
    private TextField textFlightNum; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEnsure"
    private Button buttonEnsure; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneDeleteFlight != null : "fx:id=\"paneDeleteFlight\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textFlightNum != null : "fx:id=\"textFlightNum\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert buttonEnsure != null : "fx:id=\"buttonEnsure\" was not injected: check your FXML file 'seekFlight.fxml'.";

        buttonEnsure.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            FlightOperation operation = new FlightOperation();
            operation.deleteFlight(textFlightNum.getText());
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AdminOperation.fxml"));
                paneDeleteFlight.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonCancel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AdminOperation.fxml"));
                paneDeleteFlight.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
