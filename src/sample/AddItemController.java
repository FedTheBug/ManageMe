package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {

    public static int UserID;

    @FXML
    private AnchorPane RootAnchorPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AddButton;

    @FXML
    private Label NoTaskLabel;

    @FXML
    void initialize() {
        AddButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Shaker ButtonShaker = new Shaker(AddButton);
            ButtonShaker.shake();

            System.out.println("Added Clicked");
            AddButton.relocate(0,20);
            AddButton.setOpacity(0);

            try {
                AnchorPane formPane = FXMLLoader.load(getClass().getResource("/sample/AddItemForm.fxml"));

//                AddItemFormController addItemFormController = new AddItemFormController();
//                addItemFormController.setUserID(getUserID());

                AddItemController.UserID = getUserID();

                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500), formPane);
                fadeTransition.setFromValue(0f);
                fadeTransition.setToValue(1f);
                fadeTransition.setCycleCount(1);
                fadeTransition.setAutoReverse(false);
                fadeTransition.play();

                RootAnchorPane.getChildren().setAll(formPane);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }
    public void setUserID(int UserID){
        this.UserID = UserID;
        System.out.println("UserID: "+UserID);
    }
    public int getUserID(){
        return this.UserID;
    }

    }
