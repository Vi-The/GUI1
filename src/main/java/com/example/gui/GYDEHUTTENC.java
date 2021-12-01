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

public class GYDEHUTTENC  implements Initializable {

    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private Keylistener keylistener = new Keylistener(scene);

    @FXML
    void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) { //switch case
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {

                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
           if (shape1.getLayoutX() >= 0 && shape1.getLayoutX() <= 20 && shape1.getLayoutY() == 330 ){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Kantine.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Kantine");
                    shape1.setLayoutY(631);
                    shape1.setLayoutX(330);
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (shape1.getLayoutY() >= 0 && shape1.getLayoutY() <= 20 && shape1.getLayoutX() == 330 ){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("OUTSIDESDU.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("OUTSIDE SDU");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           else if(shape1.getLayoutX() >= 630 && shape1.getLayoutX() <= 655 && shape1.getLayoutY() == 330 ){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Classroom.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Classroom");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if (shape1.getLayoutX() < 350 && shape1.getLayoutX() > 300 && shape1.getLayoutY() >= 639){ // skal ændres så det ikke kun er på det korrdinatsæt at blokken vil skifte rum
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Gydehutten_S.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Gydehutten S");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }
    };


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
    }
}

/*
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GYDEHUTTENS.fxml"));
        primaryStage.setTitle("Gydehutten S");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }

}

*/
