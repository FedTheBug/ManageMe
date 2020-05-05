package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginUsername;

    @FXML
    private PasswordField LoginPassword;

    @FXML
    private Button LoginSubmitButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {
        LoginSubmitButton.setOnAction(event -> {
            System.out.println("Login Button Pressed");
        });

    }
}
