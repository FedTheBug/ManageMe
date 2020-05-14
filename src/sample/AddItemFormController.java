package sample;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.Date;

public class AddItemFormController{


    private int UserID;

    private DBHandler dbHandler;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField DescriptionField;

    @FXML
    private TextField TaskField;

    @FXML
    private JFXButton SaveTaskButton;

    @FXML
    void initialize()  {
        dbHandler = new DBHandler();
        SaveTaskButton.setOnAction(event -> {
            Task task = new Task();
            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());

            String TaskText = TaskField.getText().trim();
            String TaskDescription = DescriptionField.getText().trim();

            if(!TaskText.equals("") || !TaskDescription.equals("")){
                System.out.println("UserID: "+ AddItemController.UserID);
                task.setTask(TaskText);
                task.setUserID(AddItemController.UserID);
                task.setDateCreated(timestamp);
                task.setDescription(TaskDescription);

                dbHandler.InsertTask(task);
                System.out.println("Task Added Successfully");
            }
            else{
                System.out.println("Wrong! Nth Added");
            }
        });

    }
    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
        System.out.println("USerID from Form:" + UserID);
    }
}
