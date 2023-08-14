package com.registro.Controller;

import com.registro.Model.persona;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class RegistroController implements Initializable {

    @FXML
    private Button btneliminar;

    @FXML
    private Button btnguardar;

    @FXML
    private TableColumn<persona, String> columnApellido;

    @FXML
    private TableColumn<persona, String> columnCedula;

    @FXML
    private TableColumn<persona, LocalDate> columnFecha;

    @FXML
    private TableColumn<persona, String> columnNombre;

    @FXML
    private DatePicker dpfecha;

    @FXML
    private TableView<persona> tblregistro;

    @FXML
    private TextField txtapellido;

    @FXML
    private TextField txtcedula;

    @FXML
    private TextField txtnombre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void Eliminar(ActionEvent event) {

    }

    @FXML
    void Guardar(ActionEvent event) {

    }

}