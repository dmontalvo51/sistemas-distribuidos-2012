/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.distribuidos.presentacion;

import java.rmi.Naming;
import lab.distribuidos.service.Servidor;

/**
 *
 * @author Diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            // Invocando el "rmi.policy" para permisos. Se le otorga todos los permisos
            System.setProperty("java.security.policy","D:/rmi.policy");
            // Inicializamos el Security Manager
            System.setSecurityManager(new SecurityManager());
            // Obtenemos una instancia usando el url.
            Servidor servidor = (Servidor) Naming.lookup("rmi://l:2320/Servidor");
            // Invocamos el metodo que se ejecutara remotamente
            System.out.println(servidor.saludo());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
