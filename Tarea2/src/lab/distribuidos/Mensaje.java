/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.distribuidos;

/**
 *
 * @author Diego
 */
public class Mensaje {
    
    private String emisor;
    private String receptor;
    private String asunto;
    private String cuerpo;

    
    public Mensaje(String emisor, String receptor, String asunto, String cuerpo){
        this.emisor=emisor;
        this.receptor=receptor;
        this.asunto=asunto;
        this.cuerpo=cuerpo;
    }
    
        
    /**
     * @return the emisor
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * @param emisor the emisor to set
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * @return the receptor
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }



}
