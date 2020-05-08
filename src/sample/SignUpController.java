package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpFirstName;

    @FXML
    private TextField SignUpLastName;

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
    private PasswordField SignUpPassword;

    @FXML
    void initialize() {
        SignUpSubmitButton.setOnAction(event -> {
            System.out.println("Button Pressed");
        });

    }
}
