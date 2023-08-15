package com.registro.util;

import java.sql.*;   // Importamos las clases del paquete java.sql para manejar la conexión y las consultas SQL
import java.util.logging.Level;   // Importamos la clase Level para manejar los niveles de registro de eventos
import java.util.logging.Logger;   // Importamos la clase Logger para registrar eventos y errores

public class ConexionBD {

    private Connection conexion;   // Objeto de conexión a la base de datos
    private Statement statement;   // Objeto para ejecutar consultas SQL
    private boolean conectado = false;   // Variable para rastrear si la conexión está activa o no
    private static String IP = "localhost", PUERTO = "5432", BD = "registro", USER = "postgres", PASS = "root";   // Información de conexión por defecto

    public ConexionBD(){}   // Constructor por defecto

    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver");   // Carga el controlador de la base de datos PostgreSQL
            conexion = DriverManager.getConnection("jdbc:postgresql://" + IP + ":" + PUERTO + "/" + BD, USER, PASS);   // Establece la conexión a
            // la base de datos
            statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);   // Crea un objeto Statement
            // para ejecutar consultas
        } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);   // Registra un mensaje de error en el registro
        }
    }

    public ResultSet CONSULTAR(String sql) throws SQLException{
        ResultSet rs = null;   // Objeto para almacenar los resultados de la consulta
        rs = statement.executeQuery(sql);   // Ejecuta la consulta SQL y almacena los resultados en el objeto ResultSet
        System.out.println(sql);   // Imprime la consulta en la consola
        return rs;   // Devuelve el objeto ResultSet con los resultados de la consulta
    }

    public boolean GUARDAR(String sql) throws SQLException{
        return (statement.executeUpdate(sql) > 0);   // Ejecuta una consulta SQL de actualización (INSERT, UPDATE, DELETE) y devuelve verdadero si se afectaron filas
    }

    public void CERRAR(){
        try {
            if (conexion != null){
                conexion.close();   // Cierra la conexión a la base de datos
            }
            if (statement != null){
                statement.close();   // Cierra el objeto Statement
            }
            System.out.println("CONEXION CERRADA");   // Imprime un mensaje en la consola indicando que la conexión se ha cerrado
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);   // Registra un mensaje de error en el registro
        }
    }

    public Connection getConexion(){
        return conexion;   // Devuelve el objeto de conexión a la base de datos
    }
}

