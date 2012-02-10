/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.dao;

import java.util.List;
import lab.distribuidos.beans.Alumno;

/**
 *
 * @author A-SOFT03
 */
public interface AlumnoDAO {

    public String saludo();

    public void ingresarAlumno(Alumno alumno);

    public void eliminarAlumno(int identificador);

    public void modificarAlumno(Alumno alumno);
    
    public List<Alumno> obtenerRecordAcademico();
    
}
