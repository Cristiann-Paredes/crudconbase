package com.registro;

import javafx.application.Application;   // Importa la clase Application de JavaFX para gestionar la aplicación
import javafx.fxml.FXMLLoader;   // Importa la clase FXMLLoader de JavaFX para cargar archivos FXML
import javafx.scene.Parent;   // Importa la clase Parent de JavaFX para representar nodos gráficos
import javafx.scene.Scene;   // Importa la clase Scene de JavaFX para gestionar las escenas
import javafx.stage.Stage;   // Importa la clase Stage de JavaFX para gestionar las ventanas

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("registro.fxml"));   // Carga el archivo FXML
        // "registro.fxml" y crea un nodo gráfico Parent

        primaryStage.setTitle("hola");   // Establece el título de la ventana principal
        primaryStage.setScene(new Scene(root));   // Crea una escena y establece el nodo raíz
        primaryStage.show();   // Muestra la ventana principal
    }

    public static void main(String[] args) {
        launch(args);   // Inicia la aplicación JavaFX
    }
}
