/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.beans;

/**
 *
 * @author A-SOFT03
 */
public class Alumno {

    private int identificador;
    private String codigo;
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private String correo;
    
    public Alumno(){
        super();
    }

    public Alumno(int identificador,String codigo, String nombres, String aPaterno, String aMaterno, String correo) {
        this.identificador=identificador;
        this.codigo = codigo;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.correo = correo;
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the aPaterno
     */
    public String getaPaterno() {
        return aPaterno;
    }

    /**
     * @param aPaterno the aPaterno to set
     */
    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    /**
     * @return the aMaterno
     */
    public String getaMaterno() {
        return aMaterno;
    }

    /**
     * @param aMaterno the aMaterno to set
     */
    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    
    
}
