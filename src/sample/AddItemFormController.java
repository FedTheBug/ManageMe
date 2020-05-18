package sample;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private Label SuccessLabel;

    @FXML
    private JFXButton TasksButton;

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
                task.setTask(TaskText);
                task.setUserID(AddItemController.UserID);
                task.setDateCreated(timestamp);
                task.setDescription(TaskDescription);

                dbHandler.InsertTask(task);

                SuccessLabel.setVisible(true);
                TasksButton.setVisible(true);
                int taskNumber = 0;
                try {
                    taskNumber = dbHandler.GetAllTask(AddItemController.UserID);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                TasksButton.setText("My Tasks: "+"[" + taskNumber +"]");
                TaskField.setText("");
                DescriptionField.setText("");
                TasksButton.setOnAction(event1 -> {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/List.fxml"));
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
