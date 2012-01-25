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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader entradaDesdeUsuario=new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket socketCliente=null;
		
		try {
			socketCliente=new DatagramSocket();
		} catch (SocketException e1) {
			System.out.println("Error al inicializar el Socket UDP");
			e1.printStackTrace();
		}
				
		InetAddress direccionIP=null;
		try {
			//direccionIP=InetAddress.getByName("A-SOFT03-PC");
			direccionIP=InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.out.println("Error al obtener la direccion IP del servidor");
			e.printStackTrace();
		}
		
		byte[] enviarDatos=new byte[1024];
		byte[] recibirDatos=new byte[1024];
		
		String frase =new String();
		try {
			frase=entradaDesdeUsuario.readLine();
		} catch (IOException e) {
			frase="Hola Mundo!";
			e.printStackTrace();
		}
		
		enviarDatos=frase.getBytes();
		
		DatagramPacket enviarPaquete=new DatagramPacket(enviarDatos,enviarDatos.length,direccionIP,9876);
		try {
			System.out.println("Enviando paquete....");
			socketCliente.send(enviarPaquete);
		} catch (IOException e) {
			System.out.println("Error al enviar paquete");
			e.printStackTrace();
		}
		
		DatagramPacket recibirPaquete=new DatagramPacket(recibirDatos,recibirDatos.length);
		try {
			socketCliente.receive(recibirPaquete);
		} catch (IOException e) {
			System.out.println("Error al recibir el paquete");
			e.printStackTrace();
		}
		
		
		String fraseModificada=new String(recibirPaquete.getData());
		System.out.println("DEL SERVIDOR: " + fraseModificada);
		
		socketCliente.close();
	}
}
