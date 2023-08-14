package com.registro.util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    private Connection conexion;
    private Statement statement;
    private boolean conectado=false;
    private static String IP= "localhost",PUERTO="5432",BD="registro",USER="root23",PASS="root23";
    public ConexionBD(){}

    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection("jdbc:postgresql://" + IP +":" +PUERTO+"/"+BD,USER,PASS);
            statement=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public ResultSet CONSULTAR(String sql) throws SQLException{
        ResultSet rs= null;
        rs= statement.executeQuery(sql);
        System.out.println(sql);
        return rs;
    }
    public boolean GUARDAR (String sql ) throws SQLException{
        return (statement.executeUpdate(sql) >0);
    }

    public void CERRAR(){
        try {
            if (conexion !=null ){
                conexion.close();
            }
            if (statement !=null){
                statement.close();
            }
            System.out.println("CONEXION CERRADA");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE,null, ex);
        }

    }
}

