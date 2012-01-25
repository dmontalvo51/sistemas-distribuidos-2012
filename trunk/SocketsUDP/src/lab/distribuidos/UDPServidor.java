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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket socketServidor=null;
		try {
			socketServidor=new DatagramSocket(9876);
		} catch (SocketException e) {
			System.out.println("Error al inicializar el Socket UDP");
			e.printStackTrace();
		}
		
		byte[] enviarDatos=new byte[1024];
		byte[] recibirDatos=new byte[1024];
		
		while(true){
			DatagramPacket recibirPaquete=new DatagramPacket(recibirDatos, recibirDatos.length);
			try {
				socketServidor.receive(recibirPaquete);
			} catch (IOException e) {
				System.out.println("Error al recibir el paquete");
				e.printStackTrace();
			}
			
			String frase=new String(recibirPaquete.getData());
			InetAddress direccionIP=recibirPaquete.getAddress();
			int puerto=recibirPaquete.getPort();
			
			String fraseMayusculas=frase.toUpperCase();
			
			enviarDatos=fraseMayusculas.getBytes();
			DatagramPacket enviarPaquete=new DatagramPacket(enviarDatos, enviarDatos.length,direccionIP,puerto);
			
			try {
				socketServidor.send(enviarPaquete);
			} catch (IOException e) {
				System.out.println("Error al enviar paquete");
				e.printStackTrace();
			}
		}
	}
}
