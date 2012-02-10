/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.servidor.service;

import java.util.List;
import lab.distribuidos.beans.Alumno;

/**
 *
 * @author Diego
 */
public interface Servidor {

    public String saludo();

    public void ingresarAlumno(Alumno alumno);

    public void eliminarAlumno(int identificador);

    public void modificarAlumno(Alumno alumno);

    public List<Alumno> obtenerRecordAcademico();
}
