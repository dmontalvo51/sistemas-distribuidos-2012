package lab.distribuidos;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServidor {

	public static void main(String[] args) throws Exception {
		String fraseCliente = new String();
		String fraseMayusculas = new String();

		ServerSocket socketAcogida = new ServerSocket(6789);

		while (true) {
			Socket socketConexion = socketAcogida.accept();
			BufferedReader entradaDesdeCliente = new BufferedReader(
					new InputStreamReader(socketConexion.getInputStream()));
			DataOutputStream salidaACliente=new DataOutputStream(socketConexion.getOutputStream());
			fraseCliente=entradaDesdeCliente.readLine();
			fraseMayusculas=fraseCliente.toUpperCase()+'\n';
			salidaACliente.writeBytes(fraseMayusculas);
		}
	}

}
