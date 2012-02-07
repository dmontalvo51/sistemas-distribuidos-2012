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
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
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
            printSocketInfo(miSocket);
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

    public void saludo() {
        try {
            enviarComando(colaSalida, "HELO localhost");
            String resp = leerLineaRespuesta(colaEntrada);
            escribirConsola("S: " + resp);
        } catch (Exception e) {
            escribirConsola("Error al enviar comando de saludo");
            e.printStackTrace();
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
                escribirConsola("Error al cerrar conexión");
            }
        } else {
            escribirConsola("La conexión está cerrada, todo cambio ha sido actualizado en el servidor");
        }
    }

    public void enviarComando(DataOutputStream salida, String comando) throws IOException {
        escribirConsola("C: " + comando);
        salida.writeBytes(comando + "\r\n");
    }

    public String enviarConsulta(String consulta) throws IOException {
        enviarComando(colaSalida, consulta);
        return leerLineaRespuesta(colaEntrada);
    }

    public BufferedReader obtenerBufferRespuesta() {
        return this.colaEntrada;
    }

    private void printSocketInfo(Socket s) {
        escribirConsola("Socket class: " + s.getClass());
        escribirConsola("   Remote address = " + s.getInetAddress().toString());
        escribirConsola("   Remote port = " + s.getPort());
        escribirConsola("   Local socket address = "
                + s.getLocalSocketAddress().toString());
        escribirConsola("   Local address = " + s.getLocalAddress().toString());
        escribirConsola("   Local port = " + s.getLocalPort());
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
        String resp;
        try {
            enviarComando(colaSalida, "MAIL FROM: " + mensaje.getEmisor());
            resp = leerLineaRespuesta(colaEntrada);
            if (resp.startsWith("250")) {
                try {
                    enviarComando(colaSalida, "RCPT TO: " + mensaje.getReceptor());
                    resp = leerLineaRespuesta(colaEntrada);
                    if (resp.startsWith("250")) {
                        enviarComando(colaSalida, "DATA");
                        resp = leerLineaRespuesta(colaEntrada);
                        if (resp.startsWith("354")) {
                            
                            return true;
                        }else{
                            escribirConsola("Servidor no pudo procesar data del mensaje.");
                            return false;
                        }
                    } else {
                        escribirConsola("Servidor no pudo procesar receptor. Intentar de nuevo.");
                        return false;
                    }
                } catch (Exception e) {
                    escribirConsola("Error al enviar receptor");
                    e.printStackTrace();
                    return false;
                }
            } else {
                escribirConsola("Servidor no pudo procesar emisor. Intentar de nuevo.");
                return false;
            }
        } catch (IOException ex) {
            escribirConsola("Error al enviar emisor");
            ex.printStackTrace();
            return false;
        }
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
