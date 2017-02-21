package teknikk2;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.beans.value.ChangeListener;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyStringProperty;

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

    @FXML
    private void reason_fieldFocusChange(ReadOnlyBooleanProperty property, Boolean old_value, Boolean new_value) {
        if (!new_value) {
            update_reason_model();
        }
    }

    private ChangeListener<String> reason_change_listener = (property, old_value, new_value) -> {
       update_reason_view();
    };

    private ChangeListener<String> room_change_listener = (property, old_value, new_value) -> {
        update_room_view();
    };


    private ChangeListener<LocalTime> from_change_listener = (property, old_value, new_value) -> {
        update_from_view();
    };

    private ChangeListener<LocalTime> to_change_listener = (property, old_value, new_value) -> {
        update_to_view();
    };

    private Appointment model;

    public Appointment getModel() {
        return model;
    }

    public void setModel(Appointment model) {
        if (this.model != null) {
            model.formalProperty().removeListener(reason_change_listener);
            model.romProperty().removeListener(room_change_listener);
            model.fraProperty().removeListener(from_change_listener);
            model.tilProperty().removeListener(to_change_listener);
        }
        this.model = model;
        update_view();
        if (this.model != null) {
            model.formalProperty().addListener(reason_change_listener);
            model.romProperty().addListener(room_change_listener);
            model.fraProperty().addListener(from_change_listener);
            model.tilProperty().addListener(to_change_listener);
        }
    }

    private void update_view() {
        update_reason_view();
        update_room_view();
        update_from_view();
        update_to_view();
    }


    private void update_reason_view() {
        String reason = (model != null ? model.getFormal() : null);
        reason_input.setText(reason != null ? reason : "");
        reason_input.setEditable(model != null);
    }

    private void update_room_view() {
        String room = (model != null ? model.getRom() : null);
        room_input.setText(room != null ? room : "");
        room_input.setEditable(model != null);
    }

    private void update_from_view() {
        String from = (model != null ? model.getFra().toString() : null);
        from_input.setText(from != null ? from : "");
        from_input.setEditable(model != null);
    }

    private void update_to_view() {
        String to = (model != null ? model.getTil().toString() : null);
        to_input.setText(to != null ? to : "");
        to_input.setEditable(model != null);
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
                String[] to_tuple = to_input.getText().split(":");
                LocalTime time = LocalTime.of(Integer.valueOf(to_tuple[0]), Integer.valueOf(to_tuple[1]));
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
