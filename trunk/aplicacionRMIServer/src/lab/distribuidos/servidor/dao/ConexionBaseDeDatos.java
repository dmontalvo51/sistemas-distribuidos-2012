/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.servidor.dao;

import java.sql.*;

/**
 *
 * @author A-SOFT03
 */
public class ConexionBaseDeDatos {

    private Connection con;

    public ConexionBaseDeDatos() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/");
        } catch (ClassNotFoundException e1) {
            System.out.println("Error al cargar el driver de HSQLDB");
            e1.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al crear conexion con la base de datos");
            e.printStackTrace();
        }
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }
}
