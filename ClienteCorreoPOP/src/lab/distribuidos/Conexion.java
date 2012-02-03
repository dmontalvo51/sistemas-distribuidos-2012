package lab.distribuidos;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.swing.JTextArea;

public class Conexion {

    private DataOutputStream salidaAServidor;
    private BufferedReader entradaDesdeServidor;
    private Socket socket;
    private int modo = 1;
    private JTextArea consola;
    
    public static int CARGAR_ELIMINAR = 0;
    public static int CARGAR_GUARDAR = 1;

    public Conexion(String host, int puerto) {
        String respuesta;
        escribirConsola("Conectando ....");
        try {
            socket = new Socket(host, puerto);
            printSocketInfo(socket);
            salidaAServidor = new DataOutputStream(socket.getOutputStream());
            entradaDesdeServidor = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            escribirConsola(respuesta = leerRespuestaServidor());
        } catch (IOException e1) {
            escribirConsola("Error al conectar con el servidor de correo");
            e1.printStackTrace();
        }
    }
    
    public void cambiarModo(int modo) {
        setModo(modo);
    }

    public void iniciarSesion(String cuenta, String password) {
        String respuesta;

        escribirConsola("Iniciando sesion ....");

        enviarComando("USER " + cuenta);
        escribirConsola(respuesta = leerRespuestaServidor());

        enviarComando("PASS " + password);
        escribirConsola(respuesta = leerRespuestaServidor());
        
    }

    public void cerrarConexion() {

        String respuesta;

        if (this.estaConectado()) {
            enviarComando("QUIT");
            respuesta = leerRespuestaServidor();
            escribirConsola(respuesta);

            if (respuesta.startsWith("+OK")) {
                try {
                    socket.close();
                } catch (IOException e) {
                    escribirConsola("Error al cerrar la conexion");
                    e.printStackTrace();
                }
            }

        } else {
            System.out.println("C=> La conexión está cerrada");
        }
    }

    private void printSocketInfo(Socket s) {
        escribirConsola("Socket class: " + s.getClass());
        escribirConsola("   Remote address = " + s.getInetAddress().toString());
        escribirConsola("   Remote port = " + s.getPort());
        escribirConsola("   Local socket address = "
                + s.getLocalSocketAddress().toString());
        escribirConsola("   Local address = " + s.getLocalAddress().toString());
        escribirConsola("   Local port = " + s.getLocalPort());

        if (s.getClass().equals("SSLSocket")) {
            escribirConsola("   Need client authentication = "
                    + ((SSLSocket) s).getNeedClientAuth());
            SSLSession ss = ((SSLSocket) s).getSession();
            try {
                System.out.println("Session class: " + ss.getClass());
                System.out.println("   Cipher suite = " + ss.getCipherSuite());
                System.out.println("   Protocol = " + ss.getProtocol());
                System.out.println("   PeerPrincipal = "
                        + ss.getPeerPrincipal().getName());
                System.out.println("   LocalPrincipal = "
                        + ss.getLocalPrincipal().getName());
                System.out.println("   PeerPrincipal = "
                        + ss.getPeerPrincipal().getName());
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    public String[] listarMensajes() {

        String respuesta;

        enviarComando("LIST");
        escribirConsola(respuesta = leerRespuestaServidor());

        return null;
    }

    public void mostrarCorreo(String idCorreo) {

        String respuesta;

        enviarComando("RETR " + idCorreo);
        escribirConsola(respuesta = leerRespuestaServidor());

    }

    private String leerRespuestaServidor() {
        String respuesta = new String();

        try {
            respuesta = getEntradaDesdeServidor().readLine();
            return "S=> " + respuesta;
        } catch (IOException e) {
            escribirConsola("Error al leer linea desde el buffer de entrada");
            e.printStackTrace();
            return null;
        }
    }

    public void enviarComando(String mensaje) {

        escribirConsola("C=> " + mensaje);
        mensaje = mensaje + "\r\n";

        try {
            getSalidaAServidor().writeBytes(mensaje);
        } catch (IOException e) {
            System.out.println("Error al escribir mensaje en el buffer de salida");
            e.printStackTrace();
        }
    }

    public boolean estaConectado() {

        if (!socket.isClosed()) {
            if (socket.isConnected()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void escribirConsola(String mensaje) {
        if(consola!=null)
            consola.append(mensaje);
        else
            System.out.println(mensaje);
    }
    
    public void limpiarConsola(){
        consola.setText("");
    }

    public BufferedReader getEntradaDesdeServidor() {
        return entradaDesdeServidor;
    }

    public void setEntradaDesdeServidor(BufferedReader entradaDesdeServidor) {
        this.entradaDesdeServidor = entradaDesdeServidor;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return the salidaAServidor
     */
    public DataOutputStream getSalidaAServidor() {
        return salidaAServidor;
    }

    /**
     * @param salidaAServidor the salidaAServidor to set
     */
    public void setSalidaAServidor(DataOutputStream salidaAServidor) {
        this.salidaAServidor = salidaAServidor;
    }

    /**
     * @return the modo
     */
    public int getModo() {
        return modo;
    }

    /**
     * @param modo the modo to set
     */
    public void setModo(int modo) {
        this.modo = modo;
    }

    /**
     * @return the consola
     */
    public JTextArea getConsola() {
        return consola;
    }

    /**
     * @param consola the consola to set
     */
    public void setConsola(JTextArea consola) {
        this.consola = consola;
    }
}
