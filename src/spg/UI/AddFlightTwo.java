/**
 * Sample Skeleton for 'addFlightTwo.fxml' Controller Class
 */

package spg.UI;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

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
import spg.Flight;
import spg.FlightOperation;
import spg.Tool;

public class AddFlightTwo implements Tool {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneAddFlight"
    private FlowPane paneAddFlight; // Value injected by FXMLLoader

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

    @FXML // fx:id="textPrice2"
    private TextField textPrice2; // Value injected by FXMLLoader

    @FXML // fx:id="choicePlace1"
    private ChoiceBox<String> choicePlace1; // Value injected by FXMLLoader

    @FXML // fx:id="choicePlace3"
    private ChoiceBox<String> choicePlace3; // Value injected by FXMLLoader

    @FXML // fx:id="choicePlace2"
    private ChoiceBox<String> choicePlace2; // Value injected by FXMLLoader

    @FXML // fx:id="date3"
    private DatePicker date3; // Value injected by FXMLLoader

    @FXML // fx:id="choiceHour3"
    private ChoiceBox<String> choiceHour3; // Value injected by FXMLLoader

    @FXML // fx:id="choiceMin3"
    private ChoiceBox<String> choiceMin3; // Value injected by FXMLLoader

    @FXML // fx:id="date4"
    private DatePicker date4; // Value injected by FXMLLoader

    @FXML // fx:id="choiceHour4"
    private ChoiceBox<String> choiceHour4; // Value injected by FXMLLoader

    @FXML // fx:id="choiceMin4"
    private ChoiceBox<String> choiceMin4; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCancel"
    private Button buttonCancel; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEnsure"
    private Button buttonEnsure; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneAddFlight != null : "fx:id=\"paneAddFlight\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceAirways != null : "fx:id=\"choiceAirways\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert radioIsStop != null : "fx:id=\"radioIsStop\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert textFlightNum != null : "fx:id=\"textFlightNum\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert date1 != null : "fx:id=\"date1\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceHour1 != null : "fx:id=\"choiceHour1\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceMin1 != null : "fx:id=\"choiceMin1\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert date2 != null : "fx:id=\"date2\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceHour2 != null : "fx:id=\"choiceHour2\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceMin2 != null : "fx:id=\"choiceMin2\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert textPrice != null : "fx:id=\"textPrice\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert textPrice2 != null : "fx:id=\"textPrice2\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choicePlace1 != null : "fx:id=\"choicePlace1\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choicePlace3 != null : "fx:id=\"choicePlace3\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choicePlace2 != null : "fx:id=\"choicePlace2\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert date3 != null : "fx:id=\"date3\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceHour3 != null : "fx:id=\"choiceHour3\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceMin3 != null : "fx:id=\"choiceMin3\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert date4 != null : "fx:id=\"date4\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceHour4 != null : "fx:id=\"choiceHour4\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert choiceMin4 != null : "fx:id=\"choiceMin4\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        assert buttonEnsure != null : "fx:id=\"buttonEnsure\" was not injected: check your FXML file 'addFlightTwo.fxml'.";
        choiceAirways.setItems(FXCollections.observableArrayList(AIRWAYS));
        choicePlace1.setItems(FXCollections.observableArrayList(PLACE));
        choicePlace2.setItems(FXCollections.observableArrayList(PLACE));
        choicePlace3.setItems(FXCollections.observableArrayList(PLACE));
        choiceHour1.setItems(FXCollections.observableArrayList(HOUR));
        choiceHour2.setItems(FXCollections.observableArrayList(HOUR));
        choiceHour3.setItems(FXCollections.observableArrayList(HOUR));
        choiceHour4.setItems(FXCollections.observableArrayList(HOUR));
        choiceMin1.setItems(FXCollections.observableArrayList(MIN));
        choiceMin2.setItems(FXCollections.observableArrayList(MIN));
        choiceMin3.setItems(FXCollections.observableArrayList(MIN));
        choiceMin4.setItems(FXCollections.observableArrayList(MIN));

        buttonEnsure.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            FlightOperation operation = new FlightOperation();
            Flight newFlight = new Flight();
            String place[] = new String[3];
            place[0] = choicePlace1.getValue();
            place[1] = choicePlace2.getValue();
            place[2] = choicePlace3.getValue();
            Timestamp time[] = new Timestamp[4];
            time[0] = new Timestamp(date1.getValue().getYear() - 1900, date1.getValue().getMonthValue(),
                    date1.getValue().getDayOfMonth() - 1, Integer.parseInt(choiceHour1.getValue()),
                    Integer.parseInt(choiceMin1.getValue()), 0, 0);
            time[1] = new Timestamp(date2.getValue().getYear() - 1900, date2.getValue().getMonthValue(),
                    date2.getValue().getDayOfMonth() - 1, Integer.parseInt(choiceHour2.getValue()),
                    Integer.parseInt(choiceMin2.getValue()), 0, 0);
            time[2] = new Timestamp(date3.getValue().getYear() - 1900, date3.getValue().getMonthValue(),
                    date3.getValue().getDayOfMonth() - 1, Integer.parseInt(choiceHour3.getValue()),
                    Integer.parseInt(choiceMin3.getValue()), 0, 0);
            time[3] = new Timestamp(date4.getValue().getYear() - 1900, date4.getValue().getMonthValue(),
                    date4.getValue().getDayOfMonth() - 1, Integer.parseInt(choiceHour4.getValue()),
                    Integer.parseInt(choiceMin4.getValue()), 0, 0);
            int price[] = new int[2];
            price[0] = Integer.parseInt(textPrice.getText());
            price[1] = Integer.parseInt(textPrice2.getText()) - Integer.parseInt(textPrice.getText());
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
                Parent root = FXMLLoader.load(getClass().getResource("AddFlight.fxml"));
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
