package com.registro.DAO;

import com.registro.Model.persona;
import com.registro.util.ConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class personaDAO {

    private ConexionBD conexionBD;

    public personaDAO(ConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }

    public void guardar(persona p) throws SQLException{

        String sql = null;
        if (!p.getCedula().equals("")) {
            sql = "INSERT INTO public.persona "
                    + "(cedula, nombre, apellido, fechanacimiento) "
                    + "VALUES ('" + p.getCedula() + "','" + p.getNombre() + "','" + p.getApellido() + "','" + p.getFechanacimiento() + "')";
        }

        PreparedStatement pst = this.conexionBD.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.executeUpdate();

    }

    public List<persona> getAll()throws SQLException{
        List<persona> lista = new ArrayList<>();
        persona p=null;
        ResultSet rs = this.conexionBD.CONSULTAR("SELECT cedula, nombre, apellido, fechanacimiento FROM persona; ");
        while (rs.next()){
            p= new persona();
            p.setCedula(rs.getString("cedula").trim());
            p.setNombre(rs.getString("nombre").trim());
            p.setApellido(rs.getString("apellido").trim());
            p.setFechanacimiento(rs.getDate("fechanacimiento").toLocalDate());

            lista.add(p);
        }
        return lista;
    }





}
