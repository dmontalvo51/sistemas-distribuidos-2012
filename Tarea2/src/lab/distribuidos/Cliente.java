/*Cliente.java
 * @author Alexis Leiva http://alexisleiva.com
 * Implementa las funciones para interactuar con el servidor pop3 usando sockets
 */
package lab.distribuidos;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Cliente {

    private Conexion conexion;
    private Socket miSocket;
    private BufferedReader colaEntrada;
    private DataOutputStream colaSalida;
    private JTextArea consola;

    public Cliente(JTextArea consola, Conexion cn) {
        this.consola = consola;
        this.conexion = cn;
    }

    public Cliente(Conexion cn) {
        this.conexion = cn;
    }

    public boolean abrirConexion() {
        try {
            miSocket = new Socket(this.conexion.servidor, this.conexion.puerto);  //abre su socket
            colaEntrada = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
            colaSalida = new DataOutputStream(miSocket.getOutputStream());
            String resp = leerLineaRespuesta(colaEntrada);
            escribirConsola(resp);
        } catch (Exception e) {
            escribirConsola("Error al abrir conexión");
            return false;
        }

        if (miSocket != null) {
            if (miSocket.isConnected()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void escribirConsola(String mensaje) {
        if (consola != null) {
            consola.append(mensaje + "\n");
        } else {
            System.out.println(mensaje);
        }
    }


    public void cerrarConexion() {

        if (this.estaConectado()) {
            try {
                enviarComando(colaSalida, "QUIT");
                String Respuesta = leerLineaRespuesta(colaEntrada);
                if (Respuesta.startsWith("221")) {
                    miSocket.close();
                }
            } catch (IOException ex) {

            }
        } else {
           escribirConsola("La conexión está cerrada, todo cambio ha sido actualizado en el servidor");
        }
    }

    public void enviarComando(DataOutputStream salida, String comando) throws IOException {
        escribirConsola(comando);
        salida.writeBytes(comando + "\r\n");
    }

    public String enviarConsulta(String consulta) throws IOException {
        enviarComando(colaSalida, consulta);
        return leerLineaRespuesta(colaEntrada);
    }

    public BufferedReader obtenerBufferRespuesta() {

        return this.colaEntrada;
    }

    public String leerLineaRespuesta(BufferedReader BufferRespuesta) {

        String linea = "";
        try {
            linea = BufferRespuesta.readLine();
            if (linea.substring(0, 2).equalsIgnoreCase("-ER")) {
                return null;
            }
            return linea;
        } catch (IOException ex) {
            return null;
        }
    }

   
    public boolean enviarMensaje(Mensaje mensaje) {

        return true;
    }

    public boolean estaConectado() {
        if (!miSocket.isClosed()) {
            if (miSocket.isConnected()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Conexion getConexion() {
        return this.conexion;
    }

    public void setConexion(Conexion cn) {
        this.conexion = cn;
    }

   
}
