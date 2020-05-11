package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();

        LoginButton.setOnAction(event -> {

            String LoginUsrname = LoginUsername.getText().trim();
            String LoginPwd = LoginPassword.getText().trim();
            User user = new User();
            user.setUserName(LoginUsrname);
            user.setPassword(LoginPwd);
            try {
                ResultSet userRow = dbHandler.getUser(user);
                int count = 0;
                while(userRow.next()){
                    count++;
                }
                if(count == 1){
                    System.out.println("Login Successful");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
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


}
