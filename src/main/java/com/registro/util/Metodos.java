package com.registro.util;

import com.registro.Model.persona;   // Importamos la clase persona del modelo de datos
import javafx.animation.RotateTransition;   // Importamos la clase RotateTransition de JavaFX para realizar transiciones de rotación
import javafx.event.ActionEvent;   // Importamos la clase ActionEvent de JavaFX para manejar eventos de acción
import javafx.event.EventHandler;   // Importamos la interfaz EventHandler de JavaFX para manejar eventos
import javafx.scene.control.TableView;   // Importamos la clase TableView de JavaFX para manejar tablas
import javafx.util.Duration;   // Importamos la clase Duration de JavaFX para manejar duraciones de tiempo

public class Metodos {

    // Método estático para crear una animación de rotación en caso de error
    public static void rotaError(TableView<persona> node) {
        RotateTransition rt = new RotateTransition(Duration.millis(100), node);   // Crea una transición de
        // rotación con una duración de 100 milisegundos en el nodo TableView
        rt.setCycleCount(4);   // Establece el número de ciclos de la animación
        rt.setAutoReverse(true);   // Configura la animación para reproducirse en reversa automáticamente
        rt.setFromAngle(-3);   // Define el ángulo de inicio de rotación en grados (-3 grados)
        rt.setToAngle(3);   // Define el ángulo final de rotación en grados (3 grados)

        // Define un evento que se ejecutará cuando la animación haya finalizado
        rt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                node.setRotate(0);   // Restablece la rotación del nodo TableView a cero cuando la animación haya terminado
            }
        });

        rt.play();   // Inicia la animación de rotación
    }
}
