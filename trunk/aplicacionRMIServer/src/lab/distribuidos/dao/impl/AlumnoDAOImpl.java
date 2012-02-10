/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab.distribuidos.beans.Alumno;
import lab.distribuidos.dao.AlumnoDAO;
import lab.distribuidos.dao.ConexionBaseDeDatos;

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

    public String saludo(){
        return "Hola desde el servidor";
    }

    public void ingresarAlumno(Alumno a) {
        try {
            String comando="INSERT INTO ALUMNO VALUES("+ a.getIdentificador() +
                            ",'"+ a.getCodigo() + "','" + a.getNombres() +
                            "','" + a.getaPaterno() + "','" + a.getaMaterno() +
                            "','" + a.getCorreo() + "');";
//             System.out.println(comando);
            statement.execute(comando);
        } catch (SQLException ex) {
            System.out.println("Error al ingresar un alumno");
            ex.printStackTrace();
        }
    }

    public void eliminarAlumno(int identificador) {
        try {
            statement.execute("DELETE ALUMNO A WHERE A.IDENTIFICADOR="+ identificador+";");
        } catch (SQLException ex) {
            System.out.println("Error al ingresar un alumno");
            ex.printStackTrace();
        }
    }

    public void modificarAlumno(Alumno a) {
        try {
            statement.execute("UPDATE ALUMNO A WHERE A.IDENTIFICADOR="+ a.getIdentificador()+" SET "+
                               "CODIGO="+a.getCodigo()+",NOMBRES="+ a.getNombres()+
                               ",APATERNO="+a.getaPaterno()+",AMATERNO="+a.getaMaterno()+
                               ",CORREO="+a.getCorreo()+";");
            
        } catch (SQLException ex) {
            System.out.println("Error al ingresar un alumno");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Alumno> obtenerRecordAcademico() {
        ResultSet rs;
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();

        try {
            rs = statement.executeQuery("SELECT * FROM ALUMNO");
            while(rs.next()){
                listaAlumnos.add(new Alumno(rs.getInt("IDENTIFICADOR"),
                                            rs.getString("CODIGO"),
                                            rs.getString("NOMBRES"),
                                            rs.getString("APATERNO"),
                                            rs.getString("AMATERNO"),
                                            rs.getString("CORREO")));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener record académico");
            ex.printStackTrace();
        }

        return listaAlumnos;
    }

  
 }
