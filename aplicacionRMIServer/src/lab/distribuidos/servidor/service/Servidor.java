/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.servidor.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import lab.distribuidos.beans.Alumno;

/**
 *
 * @author Diego
 */
public interface Servidor extends Remote{

    public String saludo() throws RemoteException;

    public void ingresarAlumno(Alumno alumno)throws RemoteException;

    public void eliminarAlumno(int identificador)throws RemoteException;

    public void modificarAlumno(Alumno alumno)throws RemoteException;

    public List<Alumno> obtenerRecordAcademico()throws RemoteException;
}
