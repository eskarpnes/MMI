package teknikk2;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

public class AppointmentView extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Appointment");
        Parent root = FXMLLoader.load(getClass().getResource("appointment.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}