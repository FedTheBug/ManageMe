package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CellController extends JFXListCell<Task> {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane RootAnchorPane;

    @FXML
    private ImageView IconImageView;

    @FXML
    private Label TaskLabel;

    @FXML
    private Label DescriptionLabel;

    @FXML
    private Label DateLabel;

    @FXML
    private ImageView DeleteButton;

    @FXML
    private ImageView UpdateListButton;

    private FXMLLoader fxmlLoader;

    private DBHandler dbHandler;
    @FXML
    void initialize() {


    }


    @Override
    public void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);
        if(empty || myTask == null){
            setText(null);
            setGraphic(null);
        }else{
            if(fxmlLoader == null){
                fxmlLoader = new FXMLLoader(getClass().getResource("/sample/Cell.fxml"));
                fxmlLoader.setController(this) ;
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            TaskLabel.setText(myTask.getTask());
            DateLabel.setText(myTask.getDateCreated().toString());
            DescriptionLabel.setText(myTask.getDescription());

            int taskid = myTask.getTaskID();

//            UpdateListButton.setOnMouseClicked(event -> {
//
//
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(getClass().getResource("sample/UpdateTaskForm.fxml"));
//                try {
//                    loader.load();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                Parent root = loader.getRoot();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));
//                UpdateTaskController updateTaskController = loader.getController();
//                updateTaskController.setTaskField(myTask.getTask());
//                updateTaskController.setUpdateDescriptionField(myTask.getDescription());
//
//                updateTaskController.updateTaskButton.setOnAction(event1 -> {
//
//                    Calendar calendar = Calendar.getInstance();
//
//                    java.sql.Timestamp timestamp =
//                            new java.sql.Timestamp(calendar.getTimeInMillis());
//
//                    try {
//
//                        System.out.println("taskid " + myTask.getTaskId());
//
//                        databaseHandler.updateTask(timestamp, updateTaskController.getDescription(),
//                                updateTaskController.getTask(), myTask.getTaskId());
//
//                        //update our listController
//                        // updateTaskController.refreshList();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//
//                });
//
//                stage.show();
//
//
//            });
//            });

            DeleteButton.setOnMouseClicked(event ->{
                dbHandler = new DBHandler();
                try {
                    dbHandler.DeleteTask(AddItemController.UserID, taskid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                getListView().getItems().remove(getItem());
            });

            setText(null);
            setGraphic(RootAnchorPane);
        }
    }
}
