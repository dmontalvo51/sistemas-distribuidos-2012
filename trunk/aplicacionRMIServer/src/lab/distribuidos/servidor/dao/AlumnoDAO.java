/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.servidor.dao;

import java.util.List;
import lab.distribuidos.beans.Alumno;

/**
 *
 * @author A-SOFT03
 */
public interface AlumnoDAO {

    public void ingresarAlumno(Alumno alumno);

    public void eliminarAlumno(Alumno alumno);

    public void modificarAlumno(Alumno alumno);
    
    public List<Alumno> obtenerRecordAcademico();
    
}
