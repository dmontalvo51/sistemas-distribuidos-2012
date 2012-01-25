package lab.distribuidos;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPCliente {

	public static void main(String[] args) throws IOException {

		String frase = new String();
		String fraseModificada = new String();

		try {
			
			System.out.print("Ingrese mensaje > ");

			BufferedReader entradaDesdeUsuario = new BufferedReader(
					new InputStreamReader(System.in));

			Socket socketCliente = new Socket("localhost", 6789);
			
			DataOutputStream salidaAServidor = new DataOutputStream(
					socketCliente.getOutputStream());

			BufferedReader entradaDesdeServidor = new BufferedReader(
					new InputStreamReader(socketCliente.getInputStream()));

			frase = entradaDesdeUsuario.readLine();
			salidaAServidor.writeBytes(frase + '\n');
			fraseModificada = entradaDesdeServidor.readLine();
			System.out.println("DEL SERVIDOR: " + fraseModificada);
			socketCliente.close();

		} catch (UnknownHostException e) {
			System.out.println("No se encontro el host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada y salida");
			e.printStackTrace();
		}
	}
}
