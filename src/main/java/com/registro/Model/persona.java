package com.registro.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class persona {

    private StringProperty cedula= new SimpleStringProperty();
    private StringProperty nombre= new SimpleStringProperty();
    private StringProperty apellido= new SimpleStringProperty();
    private ObjectProperty<LocalDate> fechanacimiento =new SimpleObjectProperty<>();

    public String getCedula() {
        return cedula.get();
    }

    public StringProperty cedulaProperty() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellido() {
        return apellido.get();
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

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
