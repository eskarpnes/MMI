package maria_teknikk2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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


    public boolean legalRoom(String string) {
        String[] array = string.split(" ");
        String numbers = array[-1];
        for (int i = 0; i < numbers.length(); i++) {
            char number = numbers.charAt(i);
            if (number <= 0 || number >= 9) {
                return false;
            }
        }
        for (String word : array) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' &&  ch <= '9' || ch == '-')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean legalDate(String string) {
        if (string.length()!=9) {
            return false;
        }
        if (string.charAt(0) <= 0 && string.charAt(0) >= 9) {
            return false;
        }
        if (string.charAt(1) <= 0 && string.charAt(1) >= 9) {
            return false;
        }
        if (string.charAt(2) != '/') {
            return false;
        }
        if (string.charAt(3) <= 0 && string.charAt(3) >= 9) {
            return false;
        }
        if (string.charAt(4) != '-') {
            return false;
        }
        if (string.charAt(5) <= 0 && string.charAt(5) >= 9) {
            return false;
        }
        if (string.charAt(6) <= 0 && string.charAt(6) >= 9) {
            return false;
        }
        if (string.charAt(7) <= 0 && string.charAt(7) >= 9) {
            return false;
        }
        if (string.charAt(8) <= 0 && string.charAt(8) >= 9) {
            return false;
        }
        return true;
    }

    public boolean legalTidspunkt(String string) {
        if (string.charAt(0) <= 0 && string.charAt(0) >= 9) {
            return false;
        }
        if (string.charAt(1) <= 0 && string.charAt(1) >= 9) {
            return false;
        }
        if (string.charAt(2) != ':') {
            return false;
        }
        if (string.charAt(3) <= 0 && string.charAt(3) >= 9) {
            return false;
        }
        if (string.charAt(4) <= 0 && string.charAt(4) >= 9) {
            return false;
        }
        return true;
    }

    public boolean legalTilTidspunkt(String fra, String til) {
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

    public void button_clicked() {
        print("hey");
    }


    private void print(String string) {
        System.out.println(string);
    }
}