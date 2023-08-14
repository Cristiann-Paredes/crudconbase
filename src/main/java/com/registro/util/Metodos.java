package com.registro.util;

import com.registro.Model.persona;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.util.Duration;

public class Metodos {

    public static void rotaError(TableView<persona>node){
        RotateTransition rt= new RotateTransition(Duration.millis(100),node);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);
        rt.setFromAngle(-3);
        rt.setToAngle(3);
        rt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                node.setRotate(0);
            }
        });
        rt.play();
    }




}
