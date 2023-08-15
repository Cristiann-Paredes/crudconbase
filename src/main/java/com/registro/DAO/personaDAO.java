package com.registro.DAO;

import com.registro.Model.persona;   // Importa la clase persona del modelo de datos
import com.registro.util.ConexionBD;  // Importa la clase de utilidad para la conexión a la base de datos

import java.sql.PreparedStatement;  // Importa la clase PreparedStatement para preparar consultas SQL precompiladas
import java.sql.ResultSet;   // Importa la clase ResultSet para manejar los resultados de las consultas
import java.sql.SQLException;   // Importa la clase SQLException para manejar excepciones de SQL
import java.sql.Statement;   // Importa la clase Statement para ejecutar instrucciones SQL simples
import java.util.ArrayList;   // Importa la clase ArrayList para manejar listas dinámicas
import java.util.List;   // Importa la interfaz List para manejar listas
import java.sql.*;   // Importa el paquete java.sql para otras clases relacionadas con SQL

public class personaDAO {

    private ConexionBD conexionBD;   // Instancia de la clase de conexión a la base de datos

    public personaDAO(ConexionBD conexionBD){
        this.conexionBD = conexionBD;   // Inicializa la instancia de la conexión a la base de datos
    }

    public void guardar(persona p) throws SQLException{
        // Prepara la consulta SQL para insertar un registro en la base de datos
        String sql = null;
        if (!p.getCedula().equals("")) {
            sql = "INSERT INTO public.persona "
                    + "(cedula, nombre, apellido, fechanacimiento) "
                    + "VALUES ('" + p.getCedula() + "','" + p.getNombre() + "','" + p.getApellido() + "','" + p.getFechanacimiento() + "')";
        }

        // Prepara y ejecuta la consulta SQL usando un PreparedStatement
        PreparedStatement pst = this.conexionBD.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.executeUpdate();
    }

    public List<persona> getAll()throws SQLException{
        List<persona> lista = new ArrayList<>();   // Crea una lista para almacenar objetos persona
        persona p=null;   // Instancia de persona para almacenar temporalmente registros

        // Ejecuta una consulta SQL para obtener todos los registros de la tabla persona
        ResultSet rs = this.conexionBD.CONSULTAR("SELECT cedula, nombre, apellido, fechanacimiento FROM persona; ");
        while (rs.next()){   // Itera a través de los resultados del conjunto de resultados
            p= new persona();   // Crea una nueva instancia de persona
            // Establece los atributos de la instancia de persona a partir de los datos del conjunto de resultados
            p.setCedula(rs.getString("cedula").trim());
            p.setNombre(rs.getString("nombre").trim());
            p.setApellido(rs.getString("apellido").trim());
            p.setFechanacimiento(rs.getDate("fechanacimiento").toLocalDate());

            lista.add(p);   // Agrega la instancia de persona a la lista
        }
        return lista;   // Devuelve la lista de objetos persona
    }

    public void delete(String cedula) throws SQLException{
        String sql= "DELETE FROM persona WHERE cedula= '" +cedula+"'";   // Consulta SQL para eliminar un registro por cédula
        conexionBD.GUARDAR(sql);   // Ejecuta la consulta SQL usando el método GUARDAR de la conexión a la base de datos
    }
}

