package com.registro.Controller;

import com.registro.DAO.personaDAO;  // Importamos la clase personaDAO para interactuar con la base de datos
import com.registro.Model.persona;   // Importamos la clase persona del modelo de datos
import com.registro.util.ConexionBD;  // Importamos la clase de utilidad para la conexión a la base de datos
import com.registro.util.Metodos;     // Importamos la clase de utilidad Metodos
import javafx.beans.property.ObjectProperty;  // Importamos la clase ObjectProperty de JavaFX para gestionar propiedades de objetos
import javafx.beans.property.SimpleObjectProperty;  // Importamos la clase SimpleObjectProperty de JavaFX para crear propiedades de objetos simples
import javafx.collections.FXCollections;  // Importamos la clase FXCollections de JavaFX para crear colecciones observables
import javafx.collections.ObservableList;   // Importamos la interfaz ObservableList de JavaFX para manejar colecciones observables
import javafx.fxml.Initializable;   // Importamos la interfaz Initializable de JavaFX para inicializar el controlador
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

// Estas son todas las importaciones necesarias para las clases y utilidades requeridas

public class RegistroController implements Initializable {

    @FXML
    private Button btneliminar;   // Botón en la interfaz para eliminar un registro

    @FXML
    private Button btnguardar;   // Botón en la interfaz para guardar un registro

    @FXML
    private TableColumn<persona, String> columnApellido;   // Columna de la tabla para mostrar los apellidos

    @FXML
    private TableColumn<persona, String> columnCedula;   // Columna de la tabla para mostrar las cédulas

    @FXML
    private TableColumn<persona, LocalDate> columnFecha;   // Columna de la tabla para mostrar las fechas de nacimiento

    @FXML
    private TableColumn<persona, String> columnNombre;   // Columna de la tabla para mostrar los nombres

    @FXML
    private DatePicker dpfecha;   // Selector de fecha en la interfaz

    @FXML
    private TableView<persona> tblregistro;   // Tabla en la interfaz para mostrar los registros de personas

    @FXML
    private TextField txtapellido;   // Campo de texto en la interfaz para ingresar apellidos

    @FXML
    private TextField txtcedula;   // Campo de texto en la interfaz para ingresar cédulas

    @FXML
    private TextField txtnombre;   // Campo de texto en la interfaz para ingresar nombres

    // Instancia objetos y propiedades necesarios
    private ConexionBD conexionBD = new ConexionBD();   // Instancia de la clase de conexión a la base de datos
    private personaDAO PersonaDAO;   // Instancia de la clase personaDAO para realizar operaciones de acceso a la base de datos
    ObservableList<persona> listaPersona = FXCollections.observableArrayList();   // Lista observable para almacenar los registros de personas
    private ObjectProperty<persona> objPersona = new SimpleObjectProperty<>();   // Propiedad observable para almacenar una persona seleccionada

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Establece las factorías de valor para cada columna
        columnCedula.setCellValueFactory(param -> param.getValue().cedulaProperty());   // Vincula la propiedad cedulaProperty de la clase persona a la columna de cédula
        columnNombre.setCellValueFactory(param -> param.getValue().nombreProperty());   // Vincula la propiedad nombreProperty de la clase persona a la columna de nombre
        columnApellido.setCellValueFactory(param -> param.getValue().apellidoProperty());   // Vincula la propiedad apellidoProperty de la clase persona a la columna de apellido
        columnFecha.setCellValueFactory(param -> param.getValue().fechanacimientoProperty());   // Vincula la propiedad fechanacimientoProperty de la clase persona a la columna de fecha de nacimiento

        // Rellena la tabla con datos
        listaPersona();   // Llama al método para cargar los registros de personas en la lista observable
        tblregistro.setItems(listaPersona);   // Asigna la lista observable a la tabla de registros

        // Vincula el elemento seleccionado en la tabla a la propiedad objPersona
        objPersona.bind(tblregistro.getSelectionModel().selectedItemProperty());   // Vincula la propiedad objPersona al elemento seleccionado en la tabla
    }

    @FXML
    void Eliminar(ActionEvent event) throws SQLException {
        // Verifica si hay un elemento seleccionado
        if (objPersona.get() == null) {   // Si no hay ninguna persona seleccionada en la tabla
            Metodos.rotaError(tblregistro);   // Llama al método para mostrar un error visual en la tabla
            return;   // Sale del método Eliminar
        }

        // Muestra un mensaje de confirmación
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "¿DESEA ELIMINAR ESTE REGISTRO?", ButtonType.YES, ButtonType.NO);   // Crea un cuadro de diálogo de confirmación
        a.setHeaderText(this.objPersona.get().getCedula());   // Establece el encabezado del cuadro de diálogo con la cédula de la persona seleccionada

        // Si el usuario confirma, realiza la operación de eliminación
        if (a.showAndWait().get() == ButtonType.YES) {   // Si el usuario hace clic en "Sí" en el cuadro de diálogo
            conexionBD.conectar();   // Abre la conexión a la base de datos
            PersonaDAO = new personaDAO(conexionBD);   // Crea una instancia de personaDAO pasándole la conexión a la base de datos
            PersonaDAO.delete(objPersona.get().getCedula());   // Llama al método delete de personaDAO para eliminar la persona seleccionada por su cédula
            listaPersona();   // Llama al método para recargar la lista de personas
            this.conexionBD.CERRAR();   // Cierra la conexión a la base de datos
        }
    }

    @FXML
    void Guardar(ActionEvent event) {
        // Verifica si los campos obligatorios no están vacíos
        if (!txtcedula.getText().equals("") && !txtapellido.getText().equals("") && !txtnombre.getText().equals("")) {
            persona p = new persona();   // Crea una nueva instancia de persona
            p.setCedula(txtcedula.getText());   // Establece la cédula de la persona con el valor del campo de texto
            p.setNombre(txtnombre.getText());   // Establece el nombre de la persona con el valor del campo de texto
            p.setApellido(txtapellido.getText());   // Establece el apellido de la persona con el valor del campo de texto
            p.setFechanacimiento(dpfecha.getValue());   // Establece la fecha de nacimiento de la persona con el valor seleccionado en el DatePicker

            try {
                // Conecta con la base de datos y guarda los datos de la persona
                this.conexionBD.conectar();   // Abre la conexión a la base de datos
                PersonaDAO = new personaDAO(conexionBD);   // Crea una instancia de personaDAO pasándole la conexión a la base de datos
                PersonaDAO.guardar(p);   // Llama al método guardar de personaDAO para guardar los datos de la persona
                listaPersona();   // Llama al método para recargar la lista de personas
            } catch (SQLException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);   // Registra un mensaje de error en el registro
            } finally {
                this.conexionBD.CERRAR();   // Cierra la conexión a la base de datos, independientemente del resultado
            }
        }
    }

    public void listaPersona() {
        try {
            // Conecta con la base de datos y recupera la lista de personas
            this.conexionBD.conectar();   // Abre la conexión a la base de datos
            PersonaDAO = new personaDAO(conexionBD);   // Crea una instancia de personaDAO pasándole la conexión a la base de datos
            listaPersona.setAll(PersonaDAO.getAll());   // Llama al método getAll de personaDAO para obtener todos los registros de personas
            // y los establece en la lista observable
        } catch (SQLException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);   // Registra un mensaje de error en el registro
        } finally {
            this.conexionBD.CERRAR();   // Cierra la conexión a la base de datos, independientemente del resultado
        }
    }
}
