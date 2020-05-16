package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    }
}
