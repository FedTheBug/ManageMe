package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TaskField;

    @FXML
    private TextField DescriptionField;

    @FXML
    private JFXButton SaveTaskButton;

    @FXML
    private JFXListView<Task> TaskList;

    private ObservableList<Task> tasks;

    private DBHandler dbHandler;

    @FXML
    void initialize() throws SQLException {


        tasks = FXCollections.observableArrayList();
        DBHandler dbHandler = new DBHandler();
        ResultSet resultSet = dbHandler.GetTaskByUser(AddItemController.UserID);
        while(resultSet.next()){
            Task task = new Task();
            task.setTaskID(resultSet.getInt("taskid"));
            task.setTask(resultSet.getString("task"));
            task.setDateCreated(resultSet.getTimestamp(("DateCreated")));
            task.setDescription(resultSet.getString("description"));
            System.out.println("User Tasks: " + resultSet.getString("task"));
            tasks.addAll(task);
        }


        TaskList.setItems(tasks);
        TaskList.setCellFactory(CellController -> new CellController());
        SaveTaskButton.setOnAction(event -> {
            try {
                AddNewTask();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public void AddNewTask() throws SQLException {
            if(!TaskField.getText().equals("") || !DescriptionField.getText().equals("")){
                Task MyNewTask = new Task();
                Calendar calendar = Calendar.getInstance();
                java.sql.Timestamp timestamp = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
                MyNewTask.setTask(TaskField.getText().trim());
                MyNewTask.setUserID(AddItemController.UserID);
                MyNewTask.setDateCreated(timestamp);
                MyNewTask.setDescription(DescriptionField.getText().trim());
                dbHandler = new DBHandler();
                dbHandler.InsertTask(MyNewTask);
                TaskField.setText("");
                DescriptionField.setText("");
                initialize();
            }
    }


}
