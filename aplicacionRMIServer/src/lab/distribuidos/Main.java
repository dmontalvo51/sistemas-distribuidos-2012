package lab.distribuidos;

import lab.distribuidos.beans.Alumno;
import lab.distribuidos.servidor.dao.ConexionBaseDeDatos;
import lab.distribuidos.servidor.dao.impl.AlumnoDAOImpl;
import lab.distribuidos.servidor.service.impl.ServidorImpl;
import lab.distribuidos.servidor.service.Servidor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author A-SOFT03
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionBaseDeDatos con=new ConexionBaseDeDatos();
        Servidor servidor;
        servidor=new ServidorImpl(new AlumnoDAOImpl(con));
//        servidor.ingresarAlumno(new Alumno(5,"07200024","Diego", "Montalvo","Molina","dmontalvo@gmail.com"));
//        servidor.ingresarAlumno(new Alumno(6,"07200025","Diego", "Montalvo","Molina","dmontalvo@gmail.com"));
    }
}
