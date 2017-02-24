package maria_teknikk2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppointmentController {

    @FXML
    private TextField formål;

    @FXML
    private TextField rom;

    @FXML
    private TextField dato;

    @FXML
    private TextField fratidspunkt;

    @FXML
    private TextField tiltidspunkt;

    @FXML
    private TextField repetisjonssekvens;

    @FXML
    private TextField sluttdato;


    private boolean legalRoom(String string) {
        Pattern p = Pattern.compile("[a-zA-Z0-9\\s\\-]+[\\s][0-9]+");
        Matcher m = p.matcher(string);
        return m.matches();
    }

    private boolean legalDate(String string) {
        Pattern p = Pattern.compile("[0-9]{2}[.][0-9]{2}[.][0-9]{4}");
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

    public void button_clicked() {
        if (formål.getText().isEmpty()) {
            System.out.println("Fyll inn formål.");
        }
        else if (!legalRoom(rom.getText())) {
            System.out.println("Ikke gyldig rom.");
        }
        else if (!legalDate(dato.getText())) {
            System.out.println("Ikke gyldig dato.");
        }
        else if (!legalTidspunkt(fratidspunkt.getText())) {
            System.out.println("Ikke gyldig fra-tidspunkt.");
        }
        else if (!legalTidspunkt(fratidspunkt.getText())) {
            System.out.println("Ikke gyldig til-tidspunkt");
        }

        else if (!legalTilTidspunkt(fratidspunkt.getText(), tiltidspunkt.getText())) {
            System.out.println("Til-tidspunkt må være etter fra-tidspunkt.");
        }
        else if (!legalRepetisjonssekvens(repetisjonssekvens.getText())) {
            System.out.println("Repetisjonssekvens må være tall.");
        }
        else {
            System.out.println("riktig");
        }
    }

}