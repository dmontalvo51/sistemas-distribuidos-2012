package lab.distribuidos;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPCliente {

	public static void main(String[] args) {

		String frase;
		String fraseModificada;
		
		System.out.print("Ingrese mensaje > ");
		BufferedReader entradaDeUsuario = new BufferedReader(
				new InputStreamReader(System.in));
		
		Socket socketCliente=null;
		try {
			socketCliente=new Socket("localhost",6789);
		} catch (UnknownHostException e) {
			System.out.println("No se encontro el host");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("Error de entrada y salida");
			e.printStackTrace();
		}
		
		DataOutputStream salidaAServidor=null;
		try {
			salidaAServidor = new DataOutputStream(socketCliente.getOutputStream());
		} catch (IOException e) {
			System.out.println("Error dal generar flujo de salida");
			e.printStackTrace();
		}
		

	}

}
