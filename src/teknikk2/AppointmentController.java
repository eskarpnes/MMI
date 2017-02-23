package teknikk2;

import javafx.beans.property.IntegerProperty;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringJoiner;


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

    @FXML private Label time_error;
    @FXML private Label date_error;

    @FXML
    private void building_changed() {
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
        activate_button();
    }

    @FXML
    private void date_changed() {
        activate_button();
    }

    @FXML
    private void from_hour_changed() {
        activate_button();
    }

    @FXML
    private void from_minutes_changed() {
        activate_button();
    }

    @FXML
    private void to_hour_changed() {
        activate_button();
    }

    @FXML
    private void to_minutes_changed() {
        activate_button();
    }

    @FXML
    private void repetition_changed() {
        if(repetition_input.isSelected()){
            frequency_input.setDisable(false);
            end_date_input.setDisable(false);
            rep1.setDisable(false);
            rep2.setDisable(false);
            rep3.setDisable(false);
        } else {
            frequency_input.setDisable(true);
            end_date_input.setDisable(true);
            rep1.setDisable(true);
            rep2.setDisable(true);
            rep3.setDisable(true);
        }
    }

    @FXML
    private void frequency_changed() {
        activate_button();
    }

    @FXML
    private void end_date_changed() {
        activate_button();
    }

    private void activate_button() {
        if (sanitize_input()) {
           submit_input.setDisable(false);
        } else {
            submit_input.setDisable(true);
        }
    }

    @FXML
    private void button_clicked() {
        submit_input.setText("Done");
        if (sanitize_input()) {
            update_model();
        }
    }

    private boolean sanitize_input() {

        if (!(reason_input.getText() != null && building_input.getValue() != null && room_input.getValue() != null && date_input.getValue() != null &&
                from_input_hours.getValue() != null && from_input_minutes.getValue() != null && to_input_hours.getValue() != null && to_input_minutes.getValue() != null)) {
            return false;
        }
        if (!(!repetition_input.isSelected() || (repetition_input.isSelected() && frequency_input.getText() != null && date_input.getValue() != null))) {
            return false;
        }
        if (from_input_hours.getValue() != null && from_input_minutes.getValue() != null && to_input_hours.getValue() != null && to_input_minutes.getValue() != null) {
            LocalTime from = LocalTime.of(Integer.parseInt(from_input_hours.getValue().toString()), Integer.parseInt(from_input_minutes.getValue().toString()));
            LocalTime to = LocalTime.of(Integer.parseInt(to_input_hours.getValue().toString()), Integer.parseInt(to_input_minutes.getValue().toString()));
            if (to.isBefore(from)) {
                time_error.setVisible(true);
                return false;
            }
        }
        if (repetition_input.isSelected() && date_input.getValue() != null && end_date_input.getValue() != null){
            LocalDate start = date_input.getValue();
            LocalDate end = end_date_input.getValue();
            if (end.isBefore(start)) {
                date_error.setVisible(true);
                return false;
            }
        }
        time_error.setVisible(false);
        date_error.setVisible(false);
        return true;
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
            if (!frequency_input.isDisabled()) {
                model.setRepetisjon(Integer.parseInt(frequency_input.getText()));
                print("The repetition frequency is: " + frequency_input.getText());
            }
        }
    }

    private void update_end_date_model() {
        if (model != null) {
            if (!end_date_input.isDisabled()) {
                model.setSlutt(end_date_input.getValue());
                print("The end date is: " + end_date_input.getValue().toString());
            }
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
        submit_input.setDisable(true);
    }
}