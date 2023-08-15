package com.registro.Model;

import javafx.beans.property.ObjectProperty;   // Importamos la clase ObjectProperty de JavaFX para gestionar propiedades de objetos
import javafx.beans.property.SimpleObjectProperty;   // Importamos la clase SimpleObjectProperty de JavaFX para crear propiedades de objetos simples
import javafx.beans.property.SimpleStringProperty;   // Importamos la clase SimpleStringProperty de JavaFX para crear propiedades de cadenas simples
import javafx.beans.property.StringProperty;   // Importamos la clase StringProperty de JavaFX para gestionar propiedades de cadenas
import java.time.LocalDate;   // Importamos la clase LocalDate de Java para manejar fechas

public class persona {

    // Propiedades que encapsulan los atributos de la clase persona
    private StringProperty cedula = new SimpleStringProperty();   // Propiedad para almacenar la cédula
    private StringProperty nombre = new SimpleStringProperty();   // Propiedad para almacenar el nombre
    private StringProperty apellido = new SimpleStringProperty();   // Propiedad para almacenar el apellido
    private ObjectProperty<LocalDate> fechanacimiento = new SimpleObjectProperty<>();   // Propiedad para almacenar la fecha de nacimiento

    // Métodos para obtener y establecer la cédula
    public String getCedula() {
        return cedula.get();
    }

    public StringProperty cedulaProperty() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    // Métodos para obtener y establecer el nombre
    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    // Métodos para obtener y establecer el apellido
    public String getApellido() {
        return apellido.get();
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    // Métodos para obtener y establecer la fecha de nacimiento
    public LocalDate getFechanacimiento() {
        return fechanacimiento.get();
    }

    public ObjectProperty<LocalDate> fechanacimientoProperty() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento.set(fechanacimiento);
    }
}

