/**
 * Sample Skeleton for 'addFlight.fxml' Controller Class
 */

package spg.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import javax.swing.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import spg.Tool;
import spg.*;

public class AddFlight implements Tool {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneAddFlight"
    private FlowPane paneAddFlight; // Value injected by FXMLLoader

    @FXML // fx:id="choicePlace1"
    private ChoiceBox<String> choicePlace1; // Value injected by FXMLLoader

    @FXML // fx:id="choicePlace2"
    private ChoiceBox<String> choicePlace2; // Value injected by FXMLLoader

    @FXML // fx:id="choiceAirways"
    private ChoiceBox<String> choiceAirways; // Value injected by FXMLLoader

    @FXML // fx:id="radioIsStop"
    private RadioButton radioIsStop; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightNum"
    private TextField textFlightNum; // Value injected by FXMLLoader

    @FXML // fx:id="date1"
    private DatePicker date1; // Value injected by FXMLLoader

    @FXML // fx:id="choiceHour1"
    private ChoiceBox<String> choiceHour1; // Value injected by FXMLLoader

    @FXML // fx:id="choiceMin1"
    private ChoiceBox<String> choiceMin1; // Value injected by FXMLLoader

    @FXML // fx:id="date2"
    private DatePicker date2; // Value injected by FXMLLoader

    @FXML // fx:id="choiceHour2"
    private ChoiceBox<String> choiceHour2; // Value injected by FXMLLoader

    @FXML // fx:id="choiceMin2"
    private ChoiceBox<String> choiceMin2; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice"
    private TextField textPrice; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCancel"
    private Button buttonCancel; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEnsure"
    private Button buttonEnsure; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneAddFlight != null : "fx:id=\"paneAddFlight\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert choicePlace1 != null : "fx:id=\"choiceTime1\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert choicePlace2 != null : "fx:id=\"choiceTime2\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert choiceAirways != null : "fx:id=\"choiceAirways\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert radioIsStop != null : "fx:id=\"radioIsStop\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert textFlightNum != null : "fx:id=\"textFlightNum\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert date1 != null : "fx:id=\"date1\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert choiceHour1 != null : "fx:id=\"choiceHour1\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert choiceMin1 != null : "fx:id=\"choiceMin1\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert date2 != null : "fx:id=\"date2\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert choiceHour2 != null : "fx:id=\"choiceHour2\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert choiceMin2 != null : "fx:id=\"choiceMin2\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert textPrice != null : "fx:id=\"textPrice\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'addFlight.fxml'.";
        assert buttonEnsure != null : "fx:id=\"buttonEnsure\" was not injected: check your FXML file 'addFlight.fxml'.";

        choiceAirways.setItems(FXCollections.observableArrayList(AIRWAYS));
        choicePlace1.setItems(FXCollections.observableArrayList(PLACE));
        choicePlace2.setItems(FXCollections.observableArrayList(PLACE));
        choiceHour1.setItems(FXCollections.observableArrayList(HOUR));
        choiceHour2.setItems(FXCollections.observableArrayList(HOUR));
        choiceMin1.setItems(FXCollections.observableArrayList(MIN));
        choiceMin2.setItems(FXCollections.observableArrayList(MIN));
        buttonEnsure.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            FlightOperation operation = new FlightOperation();
            Flight newFlight = new Flight();
            String place[] = new String[3];
            place[0] = choicePlace1.getValue();
            place[1] = "无";
            place[2] = choicePlace2.getValue();
            Timestamp time[] = new Timestamp[4];
            time[0] = new Timestamp(date1.getValue().getYear() - 1900, date1.getValue().getMonthValue(),
                    date1.getValue().getDayOfMonth() - 1, Integer.parseInt(choiceHour1.getValue()),
                    Integer.parseInt(choiceMin1.getValue()), 0, 0);
            time[1] = new Timestamp(date2.getValue().getYear() - 1900, date2.getValue().getMonthValue(),
                    date2.getValue().getDayOfMonth() - 1, Integer.parseInt(choiceHour2.getValue()),
                    Integer.parseInt(choiceMin2.getValue()), 0, 0);
            for (int i = 2; i < 4; i++)
                time[i] = new Timestamp(0, 0, 0, 0, 0, 0, 0);
            int price[] = new int[2];
            price[0] = Integer.parseInt(textPrice.getText());
            price[1] = 0;
            newFlight.addFlight(textFlightNum.getText(), choiceAirways.getValue(),
                    radioIsStop.isSelected(), place, time, price);
            operation.saveFlight(newFlight);//将数据保存在数据库中*/
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AdminOperation.fxml"));
                paneAddFlight.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        radioIsStop.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AddFlightTwo.fxml"));
                paneAddFlight.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonCancel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AdminOperation.fxml"));
                paneAddFlight.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
