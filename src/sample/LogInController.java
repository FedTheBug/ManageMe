package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        String LoginUsrname = LoginUsername.getText().trim();
        String LoginPwd = LoginPassword.getText().trim();

        LoginButton.setOnAction(event -> {
            if(!LoginUsrname.equals("") || !LoginPwd.equals("")){
                loginUser(LoginUsrname, LoginPwd);
            }
            else{
                System.out.println("Error in Logging In");
            }
        });
        SignUpButton.setOnAction(event -> {
            //Take the user to signup screen
            LoginButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/SignUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

    private void loginUser(String UserName, String Password) {
        //Check in the DB if the user exists or not.

    }
}
