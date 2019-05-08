/**
 * Sample Skeleton for 'initial.fxml' Controller Class
 */
package spg.UI;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;

public class Initial {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneInitial"
    private BorderPane paneInitial; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAdmin"
    private Button buttonAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="buttonPassenger"
    private Button buttonPassenger; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneInitial != null : "fx:id=\"paneInitial\" was not injected: check your FXML file 'initial.fxml'.";
        assert buttonAdmin != null : "fx:id=\"buttonAdmin\" was not injected: check your FXML file 'initial.fxml'.";
        assert buttonPassenger != null : "fx:id=\"buttonPassenger\" was not injected: check your FXML file 'initial.fxml'.";

        buttonPassenger.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                paneInitial.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonAdmin.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AdminOperation.fxml"));
                paneInitial.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
