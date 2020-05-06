package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField SignUpFirstName;

    @FXML
    private TextField SignUpUsername;

    @FXML
    private CheckBox SignUpMaleCheckbox;

    @FXML
    private CheckBox SignUpFemaleCheckbox;

    @FXML
    private Button SignUpSubmitButton;

    @FXML
    private TextField SignUpLocation;

    @FXML
    void initialize() {

    }
}
