package teknikk2;

/**
 * Created by Erlend on 16.02.2017.
 */

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

public class AppointmentView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Appointment");


        //A gridpane will be the container for the input objects.
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(10);

        Label reason = new Label("Formål: ");
        reason.setStyle("-fx-font-weight: bold");
        grid.add(reason, 0, 0);
        grid.setValignment(reason, VPos.TOP);

        TextArea reason_input = new TextArea();
        reason_input.setMaxHeight(75);
        reason_input.setMaxWidth(200);
        reason_input.setWrapText(true);
        reason_input.textProperty().addListener();
        grid.add(reason_input, 1,0);

        Label room = new Label("Rom: ");
        room.setStyle("-fx-font-weight: bold");
        grid.add(room, 0, 1);
        grid.setValignment(room, VPos.TOP);

        TextField room_input = new TextField();
        grid.add(room_input, 1, 1);

        Label date = new Label("Dato: ");
        date.setStyle("-fx-font-weight: bold");
        grid.add(date, 0, 2);
        grid.setValignment(date, VPos.TOP);

        DatePicker date_input = new DatePicker();
        grid.add(date_input, 1,2);

        Label from = new Label("Fra: ");
        from.setStyle("-fx-font-weight: bold");
        grid.add(from, 0, 3);
        grid.setValignment(from, VPos.TOP);

        TextField from_input = new TextField();
        from_input.setMaxWidth(50);
        grid.add(from_input, 1, 3);

        Label to = new Label("Til: ");
        to.setStyle("-fx-font-weight: bold");
        grid.add(to, 0, 4);
        grid.setValignment(to, VPos.TOP);

        TextField to_input = new TextField();
        to_input.setMaxWidth(50);
        grid.add(to_input, 1, 4);

        Label repetition = new Label("Repetisjonsfrekvens: ");
        repetition.setStyle("-fx-font-weight: bold");
        grid.add(repetition, 0, 5);
        grid.setValignment(repetition, VPos.TOP);

        ComboBox repetition_input = new ComboBox();
        repetition_input.getItems().addAll(1,2,3,7,14,21,28);
        grid.add(repetition_input, 1, 5);

        Label end_date = new Label("Slutt-dato: ");
        end_date.setStyle("-fx-font-weight: bold");
        grid.add(end_date, 0, 6);
        grid.setValignment(end_date, VPos.TOP);

        DatePicker end_date_input = new DatePicker();
        grid.add(end_date_input, 1,6);

        Scene scene = new Scene(grid, 800, 600, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
