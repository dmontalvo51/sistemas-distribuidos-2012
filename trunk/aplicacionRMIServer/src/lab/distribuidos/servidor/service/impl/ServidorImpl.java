/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.servidor.service.impl;

import java.util.List;
import lab.distribuidos.beans.Alumno;
import lab.distribuidos.servidor.dao.AlumnoDAO;
import lab.distribuidos.servidor.service.Servidor;

/**
 *
 * @author Diego
 */
public class ServidorImpl implements Servidor {

    private AlumnoDAO alumnoDAO;

    public ServidorImpl(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    public String saludo() {
        return getAlumnoDAO().saludo();
    }

    public void ingresarAlumno(Alumno alumno) {
        getAlumnoDAO().ingresarAlumno(alumno);
    }

    public void eliminarAlumno(int identificador) {
        getAlumnoDAO().eliminarAlumno(identificador);
    }

    public void modificarAlumno(Alumno alumno) {
        getAlumnoDAO().modificarAlumno(alumno);
    }

    public List<Alumno> obtenerRecordAcademico() {
        return getAlumnoDAO().obtenerRecordAcademico();
    }

    /**
     * @return the alumnoDAO
     */
    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }

    /**
     * @param alumnoDAO the alumnoDAO to set
     */
    public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }
}
