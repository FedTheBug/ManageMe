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
            CreateUser();
        });
    }
    private void CreateUser(){
        DBHandler dbHandler = new DBHandler();
        String FirstName = SignUpFirstName.getText();
        String LastName = SignUpLastName.getText();
        String UserName = SignUpUsername.getText();
        String password = SignUpPassword.getText();
        String location = SignUpLocation.getText();
        String gender = "";
        if(SignUpMaleCheckbox.isSelected()){
            gender = "Male";
        }
        else if(SignUpFemaleCheckbox.isSelected()){
            gender = "Female";
        }
        else{
            System.out.println("Please Enter a Valid Gender");
        }
        User user = new User(FirstName, LastName,UserName, password, location, gender);

        dbHandler.SignUpUser(user);

    }
}
