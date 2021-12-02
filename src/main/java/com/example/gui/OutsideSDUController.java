package com.example.gui;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OutsideSDUController implements Initializable, iController {
    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode
    @FXML
    private AnchorPane scene1; // scene navn til navnet på det gældende rum
    private Keylistener keylistener = new Keylistener(scene1);

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for (int i = 0; i < 19; i++) {
            collision.addCollision(-30, changer, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(690, changer, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(changer, -30, STANDARD_LENGTH, STANDARD_LENGTH);
            changer += 40;
        }
        changer = -30;
        for (int i = 0; i < 9; i++) {
            collision.addCollision(changer, 690, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(changer + 400, 690, STANDARD_LENGTH, STANDARD_LENGTH);
            changer += 40;
        }
        collision.showCollisionAreas(scene1);

        collision.addCollision(50, 50, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(90, 50, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(50, 90, STANDARD_LENGTH, STANDARD_LENGTH);
    }

    AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long timestamp) {
            scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
            if (shape1.getLayoutX() < 350 && shape1.getLayoutX() > 300 && shape1.getLayoutY() == 690) { // skal ændres så det ikke kun er på det korrdinatsæt at blokken vil skifte rum
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("GYDEHUTTEN_N.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Gydehutten N");
                    collision.setDisableCollision(true);
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCollision();
        timer.start();
    }

}