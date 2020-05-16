package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
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
    private JFXListView<String> TaskList;

    ObservableList<String> ListView = FXCollections.observableArrayList(
            "Java",
            "C++",
            "Python"
    );

    @FXML
    void initialize() {
        TaskList.setItems(ListView);
        TaskList.setCellFactory(param -> new JFXCell());
    }

    static class JFXCell extends JFXListCell<String> {
        HBox hBox = new HBox();
        Button HelloButton = new Button("Hello");
        Label Task = new Label() ;

        Pane pane = new Pane();
        Image icon = new Image("/sample/assets/addItem.png");
        ImageView IconImg = new ImageView(icon);


        public JFXCell() {
            super();

            hBox.getChildren().addAll(IconImg, Task, HelloButton);
            hBox.setHgrow(pane, Priority.ALWAYS);

        }
        public void updateItem(String TaskName, boolean empty){
            super.updateItem(TaskName, empty);
            setText(null);
            setGraphic(null);

            if(TaskName != null && !empty){
                Task.setText(TaskName);
                setGraphic(hBox);
            }
        }
    }
}
