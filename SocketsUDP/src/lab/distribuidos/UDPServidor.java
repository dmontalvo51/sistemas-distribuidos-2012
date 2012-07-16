package lab.distribuidos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SocketException, IOException {
		// TODO Auto-generated method stub
		DatagramSocket socketServidor = null;

		socketServidor = new DatagramSocket(9876);

		byte[] enviarDatos = new byte[1024];
		byte[] recibirDatos = new byte[1024];

		while (true) {
			DatagramPacket recibirPaquete = new DatagramPacket(recibirDatos,
					recibirDatos.length);

			socketServidor.receive(recibirPaquete);

			String frase = new String(recibirPaquete.getData());
			InetAddress direccionIP = recibirPaquete.getAddress();
			int puerto = recibirPaquete.getPort();

			String fraseMayusculas = frase.toUpperCase();

			enviarDatos = fraseMayusculas.getBytes();
			DatagramPacket enviarPaquete = new DatagramPacket(enviarDatos,
					enviarDatos.length, direccionIP, puerto);

			socketServidor.send(enviarPaquete);

		}
	}
}
