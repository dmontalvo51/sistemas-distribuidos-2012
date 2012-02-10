/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lab.distribuidos.beans.Alumno;
import lab.distribuidos.dao.AlumnoDAO;
import lab.distribuidos.service.Servidor;

public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    private AlumnoDAO alumnoDAO;

    public ServidorImpl(AlumnoDAO alumnoDAO)throws RemoteException{
        setAlumnoDAO(alumnoDAO);
    }

    public String saludo() throws RemoteException{
        return getAlumnoDAO().saludo();
    }

    public void ingresarAlumno(Alumno alumno) throws RemoteException{
        getAlumnoDAO().ingresarAlumno(alumno);
    }

    public void eliminarAlumno(int identificador) throws RemoteException{
        getAlumnoDAO().eliminarAlumno(identificador);
    }

    public void modificarAlumno(Alumno alumno) throws RemoteException{
        getAlumnoDAO().modificarAlumno(alumno);
    }

    public List<Alumno> obtenerRecordAcademico() throws RemoteException{
        return getAlumnoDAO().obtenerRecordAcademico();
    }

    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }

    public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }
    
}
