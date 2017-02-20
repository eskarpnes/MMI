package teknikk2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.List;


/**
 * Created by Erlend on 16.02.2017.
 */
public class AppointmentController {

    @FXML private TextArea reason_input;
    @FXML private Text reason_input_valid;

    @FXML private TextField room_input;
    @FXML private Text room_input_valid;

    @FXML private DatePicker date_input;

    @FXML private TextField from_input;
    @FXML private Text from_input_valid;
    private boolean valid_from_time;

    @FXML private TextField to_input;
    @FXML private Text to_input_valid;
    private boolean valid_to_time;

    @FXML private ComboBox repetition_input;

    @FXML private DatePicker end_date_input;

    private Appointment model;

    private void update_view() {
        //update_reason_view();
        //update_room_view();
        //update_from_view();
        //update_to_view();
    }

    private void update_reason_model() {
        if (model != null) {
            model.setFormal(reason_input.getText());
        }
    }

    private void update_room_model() {
        if (model != null) {
            model.setRom(room_input.getText().trim());
        }
    }

    private void update_date_model() {
        if (model != null) {
            model.setDato(date_input.getValue());
        }
    }

    //from_input must be LocalTime
    private void update_from_model() {
        if (model != null) {
            try {
                String[] from_tuple = from_input.getText().split(":");
                LocalTime time = LocalTime.of(Integer.valueOf(from_tuple[0]), Integer.valueOf(from_tuple[1]));
                model.setFra(time);
            } catch (DateTimeException | NumberFormatException e) {
                valid_from_time = false;
            }
        }
    }

    //to_input must be LocalTime
    private void update_to_model() {
        if (model != null) {
            try {
                String[] from_tuple = to_input.getText().split(":");
                LocalTime time = LocalTime.of(Integer.valueOf(from_tuple[0]), Integer.valueOf(from_tuple[1]));
                model.setTil(time);
            } catch (DateTimeException | NumberFormatException e) {
                valid_to_time = false;
            }
        }
    }

    private void update_repetition_model() {
        if (model != null) {
            model.setRepetisjon(Integer.valueOf(repetition_input.getValue().toString()));
        }
    }

    private void update_end_date_model() {
        if (model != null) {
            model.setSlutt(end_date_input.getValue());
        }
    }
}
