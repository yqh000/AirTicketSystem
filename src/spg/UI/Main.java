package spg.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("initial.fxml"));
        primaryStage.setTitle("飞机票管理系统");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getIcons().add(new Image("/spg/UI/icon.jpg"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        return;
    }
}
