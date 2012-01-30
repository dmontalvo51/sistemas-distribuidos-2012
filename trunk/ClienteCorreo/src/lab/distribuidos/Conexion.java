package lab.distribuidos;

import java.io.*;
import java.net.*;

import javax.net.ssl.*;

public class Conexion {

	DataOutputStream salidaAServidor;
	BufferedReader entradaDesdeServidor;
	Socket socket;
	String respuestaServidor;

	public Conexion(String host,int puerto) {
		conectar(host,puerto);
	}

	public void conectar(String host,int puerto) {
		try {

			socket = new Socket(host,puerto);
			printSocketInfo(socket);
			salidaAServidor = new DataOutputStream(socket.getOutputStream());
			entradaDesdeServidor = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			while ((respuestaServidor = leerRespuesta()) != null)
				System.out.println(respuestaServidor);

		} catch (UnknownHostException e1) {
			escribirConsola("Error al traducir el dominio del servidor de correos");
			e1.printStackTrace();
		} catch (IOException e1) {
			escribirConsola("Error al conectar con el servidor de correo");
			e1.printStackTrace();
		}
	}

	public void iniciarSesion(String cuenta, String password) {

		String respuesta;

		enviarComando("USER " + cuenta);
		respuesta = leerRespuesta();
		escribirConsola(respuesta);

		enviarComando("PASS " + password);
		respuesta = leerRespuesta();
		escribirConsola(respuesta);

	}

	public void enviarComando(String mensaje) {

		escribirConsola("C: "+mensaje);
		
		try {
			salidaAServidor.writeBytes(mensaje + "\r\n");
		} catch (IOException e) {
			System.out
					.println("Error al escribir mensaje en el buffer de salida");
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {

		String respuesta;

		if (this.estaConectado()) {
			enviarComando("QUIT");
			respuesta = leerRespuesta();
			escribirConsola(respuestaServidor);

			if (respuestaServidor.startsWith("+OK")) {
				try {
					socket.close();
				} catch (IOException e) {
					escribirConsola("Error al cerrar la conexion");
					e.printStackTrace();
				}
			}
			
		} else {
			System.out
					.println("C: La conexión está cerrada, todo cambio ha sido actualizado en el servidor");
		}
	}

	public void printSocketInfo(Socket s) {
		escribirConsola("Socket class: " + s.getClass());
		escribirConsola("   Remote address = " + s.getInetAddress().toString());
		escribirConsola("   Remote port = " + s.getPort());
		escribirConsola("   Local socket address = "
				+ s.getLocalSocketAddress().toString());
		escribirConsola("   Local address = " + s.getLocalAddress().toString());
		escribirConsola("   Local port = " + s.getLocalPort());
	}

	public String leerRespuesta() {
		String respuesta = new String();

		try {
			respuesta = entradaDesdeServidor.readLine();
			return respuesta;
		} catch (IOException e) {
			escribirConsola("Error al leer linea desde el buffer de entrada");
			e.printStackTrace();
			return null;
			
		}
	}

	public boolean estaConectado() {

		if (!socket.isClosed()) {
			if (socket.isConnected())
				return true;
			else
				return false;
		} else
			return false;
	}

	public void escribirConsola(String mensaje) {
		System.out.println(mensaje);
	}

	public DataOutputStream getSalidaAServidor() {
		return salidaAServidor;
	}

	public void setSalidaAServidor(DataOutputStream salidaAServidor) {
		this.salidaAServidor = salidaAServidor;
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

	public String getRespuestaServidor() {
		return respuestaServidor;
	}

	public void setRespuestaServidor(String respuestaServidor) {
		this.respuestaServidor = respuestaServidor;
	}

}
