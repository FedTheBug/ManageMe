package sample;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private JFXButton LoginButton;

    @FXML
    private JFXButton SignUpButton;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(event -> {
            System.out.println("SignUpButtonClicked");
        });

    }
}
