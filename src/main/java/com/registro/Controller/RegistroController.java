package com.registro.Controller;

import com.registro.DAO.personaDAO;
import com.registro.Model.persona;
import com.registro.util.ConexionBD;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    private ConexionBD conexionBD = new ConexionBD();
    private personaDAO PersonaDAO;
    ObservableList<persona> listaPersona = FXCollections.observableArrayList();
    private ObjectProperty<persona>objPersona = new SimpleObjectProperty<>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnCedula.setCellValueFactory(param -> param.getValue().cedulaProperty());
        columnNombre.setCellValueFactory(param -> param.getValue().nombreProperty());
        columnApellido.setCellValueFactory(param ->param.getValue().apellidoProperty());
        columnFecha.setCellValueFactory(param ->param.getValue().fechanacimientoProperty());
        listaPersona();
        tblregistro.setItems(listaPersona);

    }

    @FXML
    void Eliminar(ActionEvent event) {


    }

    @FXML
    void Guardar(ActionEvent event) {
        if (!txtcedula.getText().equals("") && !txtapellido.getText().equals("") &&
                !txtnombre.getText().equals("")){
            persona p = new persona();
            p.setCedula(txtcedula.getText());
            p.setNombre(txtnombre.getText());
            p.setApellido(txtapellido.getText());
            p.setFechanacimiento(dpfecha.getValue());

            try {
                this.conexionBD.conectar();
                PersonaDAO = new personaDAO(conexionBD);
                PersonaDAO.guardar(p);
                listaPersona();
            }catch (SQLException ex){
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                this.conexionBD.CERRAR();
            }

        }

    }

    public void listaPersona(){
       try {
            this.conexionBD.conectar();
            PersonaDAO = new personaDAO (conexionBD);
            listaPersona.setAll(PersonaDAO.getAll());
        }catch (SQLException ex){
           Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE,null, ex);
       }finally {
           this.conexionBD.CERRAR();
       }
    }



}