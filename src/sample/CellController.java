package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
