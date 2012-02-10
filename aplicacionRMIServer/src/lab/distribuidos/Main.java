package lab.distribuidos;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab.distribuidos.beans.Alumno;
import lab.distribuidos.dao.ConexionBaseDeDatos;
import lab.distribuidos.dao.impl.AlumnoDAOImpl;
import lab.distribuidos.service.impl.ServidorImpl;
import lab.distribuidos.service.Servidor;

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
        
        try {
            Registry registro=LocateRegistry.createRegistry(2320);
            servidor=new ServidorImpl(new AlumnoDAOImpl(con));
            registro.rebind("Servidor",servidor);
    //        servidor.ingresarAlumno(new Alumno(6,"07200025","Diego", "Montalvo","Molina","dmontalvo@gmail.com"));
    //        servidor.ingresarAlumno(new Alumno(6,"07200025","Diego", "Montalvo","Molina","dmontalvo@gmail.com"));
            
            System.out.print("Servidor iniciado correctamente. Esperando llamadas en el puerto 2320");
            
        } catch (RemoteException ex) {
            System.out.println("Error al crear el registro del servidor");
            ex.printStackTrace();
        }
    }
}
