/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.servidor.dto.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab.distribuidos.beans.Alumno;
import lab.distribuidos.servidor.dao.AlumnoDAO;
import lab.distribuidos.servidor.dao.ConexionBaseDeDatos;

/**
 *
 * @author A-SOFT03
 */
public class AlumnoDAOImpl implements AlumnoDAO {

    private ConexionBaseDeDatos conexion;
    private Statement statement;

    public AlumnoDAOImpl(ConexionBaseDeDatos con) {
        try {
            statement = con.getCon().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro al procesar conexion a la base de datos");
            ex.printStackTrace();
        }
    }

    public void ingresarAlumno(Alumno a) {
        try {
            statement.execute("INSERT INTO ALUMNO values(" + a.getCodigo() + "," + a.getNombres() + "," + a.getaPaterno() + "," + a.getaMaterno() + "," + a.getCorreo() + ");");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar un alumno");
            ex.printStackTrace();
        }
    }

    public void eliminarAlumno(Alumno a) {
        try {
            statement.execute("DELETE ALUMNO A WHERE A.CODIGO="+ a.getCodigo()+";");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar un alumno");
            ex.printStackTrace();
        }
    }

    public void modificarAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Alumno> obtenerRecordAcademico() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
