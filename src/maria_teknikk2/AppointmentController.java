package maria_teknikk2;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import teknikk2.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppointmentController {

    @FXML
    private TextField formål;

    @FXML
    private Label formål_error;

    @FXML
    private TextField rom;

    @FXML
    private Label rom_error;

    @FXML
    private DatePicker dato;

    @FXML
    private Label dato_error;

    @FXML
    private TextField fratidspunkt;

    @FXML
    private Label fratidspunkt_error;

    @FXML
    private TextField tiltidspunkt;

    @FXML
    private Label tiltidspunkt_error;

    @FXML
    private TextField repetisjonssekvens;

    @FXML
    private Label repetisjonssekvens_error;

    @FXML
    private DatePicker sluttdato;

    @FXML
    private Label sluttdato_error;

    @FXML
    private Label saved;


    private boolean legalRoom(String string) {
        Pattern p = Pattern.compile("[a-zA-Z0-9\\s\\-]+[\\s][0-9]+");
        Matcher m = p.matcher(string);
        return m.matches();
    }

    private boolean legalTidspunkt(String string) {
        Pattern p = Pattern.compile("[0-9]{2}[:][0-9]{2}");
        Matcher m = p.matcher(string);
        return m.matches();
    }

    private boolean legalTilTidspunkt(String fra, String til) {
        if (til.charAt(0) < fra.charAt(0)) {
            return false;
        }
        if (til.charAt(0) == fra.charAt(0)) {
            if (til.charAt(1) < fra.charAt(1)) {
                return false;
            }
            if (til.charAt(1) == fra.charAt(1)) {
                if (til.charAt(3) < fra.charAt(3)) {
                    return false;
                }
                if (til.charAt(3) == fra.charAt(3)) {
                    if (til.charAt(4) <= fra.charAt(4)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean legalRepetisjonssekvens(String string) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(string);
        return m.matches();
    }

    private boolean allFieldsCorrect() {
        return !formål.getText().isEmpty() && legalRoom(rom.getText()) && dato.getValue() != null
                && legalTidspunkt(tiltidspunkt.getText()) && legalTidspunkt(fratidspunkt.getText())
                && legalTilTidspunkt(fratidspunkt.getText(), tiltidspunkt.getText())
                && (repetisjonssekvens.getText().isEmpty() || sluttdato.getValue() != null);
    }

    public void button_clicked() {
        formål_error.setVisible(false);
        rom_error.setVisible(false);
        dato_error.setVisible(false);
        fratidspunkt_error.setVisible(false);
        tiltidspunkt_error.setVisible(false);
        tiltidspunkt_error.setText("Ikke gyldig tiltidspunkt.");
        repetisjonssekvens_error.setVisible(false);
        sluttdato_error.setVisible(false);

        if (formål.getText().isEmpty()) {
            formål_error.setVisible(true);
        }
        if (!legalRoom(rom.getText())) {
            rom_error.setVisible(true);
        }
        if (dato.getValue() == null) {
            dato_error.setVisible(true);
        }
        if (!legalTidspunkt(fratidspunkt.getText())) {
            fratidspunkt_error.setVisible(true);
        }
        if (!legalTidspunkt(tiltidspunkt.getText())) {
            tiltidspunkt_error.setVisible(true);
        }
        if (legalTidspunkt(fratidspunkt.getText()) && legalTidspunkt(tiltidspunkt.getText())) {
            if (!legalTilTidspunkt(fratidspunkt.getText(), tiltidspunkt.getText())) {
                tiltidspunkt_error.setText("Til-tidspunkt må være etter fra-tidspunkt.");
                tiltidspunkt_error.setVisible(true);
            }
        }
        if (!legalRepetisjonssekvens(repetisjonssekvens.getText()) && !repetisjonssekvens.getText().isEmpty()) {
            repetisjonssekvens_error.setVisible(true);
        }
        if (sluttdato == null && !repetisjonssekvens.getText().isEmpty()) {
            sluttdato_error.setVisible(true);
        }

        if (allFieldsCorrect()) {

           // updatemodel();

            formål.setText("");
            rom.setText("");
            dato.setValue(null);
            fratidspunkt.setText("");
            tiltidspunkt.setText("");
            repetisjonssekvens.setText("");
            sluttdato.setValue(null);

            saved.setVisible(true);
        }

    }
   /*
    maria_teknikk2.Appointment model = new teknikk2.Appointment();

    private void updatemodel() {
        updateFormålModel();
        updateRoomModel();
        updateDateModel();
        updateFratidspunktModel();
        updateTiltidspunktModel();
        updateRepetisjonsModel();
        updateSluttidspunktModel();
    }

    private void updateRepetisjonsModel() {
        if (model != null) {
            model.setDato(repetisjonssekvens.getText());
        }
    }

    private void updateDateModel() {
        if (model != null) {
            model.setDato(dato.getText());
        }
    }

    private void updateRoomModel() {
        if (model != null) {
            model.setRom(rom.getText());
        }
    }

    private void updateFormålModel() {
        if (model != null) {
            model.setFormal(formål.getText());
        }
    }

    private void updateFratidspunktModel() {
        if (model != null) {
            model.setDato(fratidspunkt.getText());
        }

    }

    private void updateTiltidspunktModel() {
        if (model != null) {
            model.setDato(tiltidspunkt.getText());
        }
    }

    private void updateSluttidspunktModel() {
        if (model != null) {
            if (!sluttdato.getText().isEmpty()) {
                model.setSlutt(sluttdato.getText());
            }
        }
    }
*/
}