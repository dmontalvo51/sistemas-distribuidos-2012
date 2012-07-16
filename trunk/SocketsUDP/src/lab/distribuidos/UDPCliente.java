package lab.distribuidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import sun.net.InetAddressCachePolicy;

public class UDPCliente {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws SocketException,
			UnknownHostException, IOException {

		BufferedReader entradaDesdeUsuario = new BufferedReader(
				new InputStreamReader(System.in));
		DatagramSocket socketCliente = null;

		socketCliente = new DatagramSocket();

		InetAddress direccionIP = null;
		direccionIP = InetAddress.getLocalHost();

		byte[] enviarDatos = new byte[1024];
		byte[] recibirDatos = new byte[1024];

		String frase = new String();

		frase = entradaDesdeUsuario.readLine();

		enviarDatos = frase.getBytes();

		DatagramPacket enviarPaquete = new DatagramPacket(enviarDatos,
				enviarDatos.length, direccionIP, 9876);

		System.out.println("Enviando paquete....");
		socketCliente.send(enviarPaquete);

		DatagramPacket recibirPaquete = new DatagramPacket(recibirDatos,
				recibirDatos.length);

		socketCliente.receive(recibirPaquete);

		String fraseModificada = new String(recibirPaquete.getData());
		System.out.println("DEL SERVIDOR: " + fraseModificada);

		socketCliente.close();
	}
}
