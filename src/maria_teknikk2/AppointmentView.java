package maria_teknikk2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppointmentView extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Appointment");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("appointment.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (Exception ex) {
            System.out.print("feil");

        }
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}