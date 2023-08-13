package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.ButtonBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class HelloController{

    @FXML
    private TableColumn<?, ?> CedulaColmn;

    @FXML
    private TableColumn<?, ?> CiudadColunm;

    @FXML
    private TableColumn<?, ?> IDColmn;

    @FXML
    private TableColumn<?, ?> NombreColmn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableView<?> table;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtNombre;

    @FXML
    void Add(ActionEvent event) {

    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }

}