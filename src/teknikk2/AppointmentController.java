package teknikk2;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.beans.value.ChangeListener;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyStringProperty;

import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created by Erlend on 16.02.2017.
 */
public class AppointmentController implements Initializable {

    @FXML private TextArea reason_input;

    @FXML private ComboBox building_input;
    @FXML private ComboBox room_input;

    @FXML private DatePicker date_input;

    @FXML private ComboBox from_input_hours;
    @FXML private ComboBox from_input_minutes;

    @FXML private ComboBox to_input_hours;
    @FXML private ComboBox to_input_minutes;

    @FXML private CheckBox repetition_input;
    @FXML private TextField frequency_input;
    @FXML private DatePicker end_date_input;

    @FXML private Button submit_input;

    @FXML private Label rep1;
    @FXML private Label rep2;
    @FXML private Label rep3;

    @FXML
    private void building_changed() {
        System.out.println("hehe focus");
        set_room_list();
    }

    private void set_room_list() {
        String selected_item = building_input.getSelectionModel().getSelectedItem().toString();
        if (selected_item.equals("Hovedbygget")) {
            room_input.getItems().removeAll(room_input.getItems());
            room_input.getItems().addAll(100,101,102);
        }

        else if (selected_item.equals("IT-Bygget")){
            room_input.getItems().removeAll(room_input.getItems());
            room_input.getItems().addAll(200,201,202);
        }

        else if (selected_item.equals("P15")){
            room_input.getItems().removeAll(room_input.getItems());
            room_input.getItems().addAll(300,301,302);
        }

        else if (selected_item.equals("Realfagsbygget")){
            room_input.getItems().removeAll(room_input.getItems());
            room_input.getItems().addAll(400,401,402);
        }
    }

    @FXML
    private void room_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void date_changed() {

    }

    @FXML
    private void from_hour_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void from_minutes_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void to_hour_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void to_minutes_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void repetition_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void frequency_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void end_date_changed() {
        System.out.println("hehe focus");
    }

    @FXML
    private void button_clicked() {
        submit_input.setText("Done");
        update_model();
    }

    private void sanitize_input() {
        if (reason_input != null && building_input != null && room_input != null && date_input != null &&
                from_input_hours != null && from_input_minutes != null && to_input_hours != null && to_input_minutes != null) {

        }
    }

    public void update_model() {
        update_reason_model();
        update_room_model();
        update_date_model();
        update_from_model();
        update_to_model();
        update_repetition_model();
        update_end_date_model();
    }

    Appointment model = new Appointment();

    private void update_reason_model() {
        if (model != null) {
            model.setFormal(reason_input.getText());
            print("The reason is: " + reason_input.getText());
        }
    }

    private void update_room_model() {
        if (model != null) {
            model.setRom(building_input.getValue().toString() + " " + room_input.getValue().toString());
            print("The room is: " + building_input.getValue().toString() + " " + room_input.getValue().toString());
        }
    }

    private void update_date_model() {
        if (model != null) {
            model.setDato(date_input.getValue());
            print("The date is: " + date_input.getValue().toString());
        }
    }

    //from_input must be LocalTime
    private void update_from_model() {
        if (model != null) {
            LocalTime time = LocalTime.of(Integer.parseInt(from_input_hours.getValue().toString()), Integer.parseInt(from_input_minutes.getValue().toString()));
            model.setFra(time);
            print("The start time is: " + time.toString());
        }
    }

    //to_input must be LocalTime
    private void update_to_model() {
        if (model != null) {
            LocalTime time = LocalTime.of(Integer.parseInt(to_input_hours.getValue().toString()), Integer.parseInt(to_input_minutes.getValue().toString()));
            model.setTil(time);
            print("The end time is: " + time.toString());
        }
    }

    private void update_repetition_model() {
        if (model != null) {
            model.setRepetisjon(Integer.parseInt(repetition_input.getText()));
            print("The repetition frequency is: " + repetition_input.getText());
        }
    }

    private void update_end_date_model() {
        if (model != null) {
            model.setSlutt(end_date_input.getValue());
            print("The end date is: " + end_date_input.getValue().toString());
        }
    }

    private void print(String out) {
        System.out.println(out);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        from_input_hours.getItems().addAll("08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23");
        to_input_hours.getItems().addAll("08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23");
        from_input_minutes.getItems().addAll("00","15","30","45");
        to_input_minutes.getItems().addAll("00","15","30","45");

        building_input.getItems().addAll("Hovedbygget","IT-Bygget", "P15", "Realfagsbygget");

        frequency_input.setDisable(true);
        end_date_input.setDisable(true);
        rep1.setDisable(true);
        rep2.setDisable(true);
        rep3.setDisable(true);
    }
}
