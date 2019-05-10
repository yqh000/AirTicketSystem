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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import spg.Flight;
import spg.FlightOperation;
import org.apache.commons.lang3.StringUtils;
import spg.Tool;

public class SeekFlight implements Tool {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneSeekFlight"
    private FlowPane paneSeekFlight; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightNum"
    private TextField textFlightNum; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCancel"
    private Button buttonCancel; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEnsure"
    private Button buttonEnsure; // Value injected by FXMLLoader

    @FXML // fx:id="textAirways"
    private TextField textAirways; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice1"
    private TextField textPrice1; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice2"
    private TextField textPrice2; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice"
    private TextField textPrice; // Value injected by FXMLLoader

    @FXML // fx:id="textResTicket1"
    private TextField textResTicket1; // Value injected by FXMLLoader

    @FXML // fx:id="textResTicket2"
    private TextField textResTicket2; // Value injected by FXMLLoader

    @FXML // fx:id="textResTicket"
    private TextField textResTicket; // Value injected by FXMLLoader

    @FXML // fx:id="textCity"
    private TextField textCity; // Value injected by FXMLLoader

    @FXML // fx:id="textTime"
    private TextArea textTime; // Value injected by FXMLLoader

    @FXML // fx:id="textWaybill"
    private TextArea textWaybill; // Value injected by FXMLLoader

    @FXML // fx:id="textAppoint"
    private TextArea textAppoint; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneSeekFlight != null : "fx:id=\"paneSeekFlight\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textFlightNum != null : "fx:id=\"textFlightNum\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert buttonEnsure != null : "fx:id=\"buttonEnsure\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textAirways != null : "fx:id=\"textAirways\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textPrice1 != null : "fx:id=\"textPrice1\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textPrice2 != null : "fx:id=\"textPrice2\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textPrice != null : "fx:id=\"textPrice\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textResTicket1 != null : "fx:id=\"textResTicket1\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textResTicket2 != null : "fx:id=\"textResTicket2\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textResTicket != null : "fx:id=\"textResTicket\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textCity != null : "fx:id=\"textCity\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textTime != null : "fx:id=\"textTime\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textWaybill != null : "fx:id=\"textWaybill\" was not injected: check your FXML file 'seekFlight.fxml'.";
        assert textAppoint != null : "fx:id=\"textAppoint\" was not injected: check your FXML file 'seekFlight.fxml'.";

        buttonEnsure.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                    FlightOperation operation = new FlightOperation();
                    Flight fli = operation.seekFlightByNum(textFlightNum.getText());
                    textAirways.setText(fli.getAirways());
                    textPrice1.setText("前半程：" + fli.getPrice()[0] + " 元");
                    textPrice2.setText("后半程：" + fli.getPrice()[1] + " 元");
                    textPrice.setText("全程：" + (fli.getPrice()[0] + fli.getPrice()[1]) + " 元");
                    textResTicket1.setText("前半程：" + fli.getResTicket()[0] + " 张");
                    if (!fli.getIsStop()) {
                        textResTicket2.setText("后半程：0 张");
                        textCity.setText(fli.getPlace()[0] + "--" + fli.getPlace()[2]);
                        textTime.setText(fli.getTime()[0] + "  --  " + fli.getTime()[1]);
                    } else {
                        textResTicket2.setText("后半程：" + fli.getResTicket()[1] + " 张");
                        textCity.setText(fli.getPlace()[0] + "--" + fli.getPlace()[1] + "--" + fli.getPlace()[2]);
                        textTime.setText(fli.getTime()[0] + "  --  " + fli.getTime()[1] + "\n" + fli.getTime()[2] + "  --  " + fli.getTime()[3]);
                    }
                    textResTicket.setText("全程：" + (fli.getResTicket()[0] < fli.getResTicket()[1] ? fli.getResTicket()[0] : fli.getResTicket()[1]) + " 张");
                    if (fli.getWaybill()[0] != 0) {
                        int j = 0;
                        for (int i = 0; fli.getWaybill()[i] != 0; i++) j++;
                        String[] d = new String[j];
                        for (int i = 0; i < j; i++)
                            d[i] = String.valueOf(fli.getWaybill()[i]);
                        textWaybill.setText(StringUtils.join(d, ","));
                    } else
                        textWaybill.setText("目前无乘客购买该航班机票");
                    if (!fli.getAppointList().isEmpty())
                        textAppoint.setText(StringUtils.join(fli.getAppointList(), ","));
                    else
                        textAppoint.setText("目前无乘客预约该航班");
                }
        );

        buttonCancel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AdminOperation.fxml"));
                paneSeekFlight.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
