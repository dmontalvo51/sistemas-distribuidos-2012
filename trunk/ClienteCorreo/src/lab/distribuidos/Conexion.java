package lab.distribuidos;

import java.io.*;
import java.net.*;

import javax.net.ssl.*;

public class Conexion {

	DataOutputStream salidaAServidor;
	BufferedReader entradaDesdeServidor;

	SSLSocketFactory socketFactory;
	SSLSocket socketSSL;
	String respuestaServidor;

	public void conectar() throws UnknownHostException, IOException {

		socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		socketSSL = (SSLSocket) socketFactory
				.createSocket("pop.gmail.com", 995);
		printSocketInfo(socketSSL);
		socketSSL.startHandshake();

		salidaAServidor = new DataOutputStream(socketSSL.getOutputStream());
		entradaDesdeServidor = new BufferedReader(new InputStreamReader(
				socketSSL.getInputStream()));

		while ((respuestaServidor = entradaDesdeServidor.readLine()) != null) {
			System.out.println(respuestaServidor);
			/*
			respuestaServidor = entradaDesdeServidor.readLine();
			salidaAServidor.write(respuestaServidor, 0,respuestaServidor.length());
			salidaAServidor.newLine();
			salidaAServidor.flush();
			*/
		}

	}
	
	public void iniciarSesion(String cuenta,String password) throws IOException{
		
		
		enviarComando("USER " + cuenta);
		respuestaServidor=entradaDesdeServidor.readLine();
		System.out.println(respuestaServidor);
		
		enviarComando("USER " + cuenta);
		respuestaServidor=entradaDesdeServidor.readLine();
		System.out.println(respuestaServidor);
		
	}

	public void enviarComando(String mensaje) throws IOException {
		salidaAServidor.writeBytes(mensaje+"\r\n");
	}
	
	
	public void nose(){
				try {
			SSLSocket c = (SSLSocket) f.createSocket("localhost", 8888);

			c.startHandshake();
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(
					c.getOutputStream()));
			BufferedReader r = new BufferedReader(new InputStreamReader(
					c.getInputStream()));
			String m = null;
			while ((m = r.readLine()) != null) {
				System.out.println(m);
				m = entradaDesdeServidor.readLine();
				w.write(m, 0, m.length());
				w.newLine();
				w.flush();
			}
			w.close();
			r.close();
			c.close();
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}
	
public void cerrarConexion(boolean objetodebug){

    if(this.estaConectado())
    {
        try
         {
            enviarComando(salidaAServidor, "QUIT");
            if(objetodebug) Debug.Debug(debugger, "QUIT");
            String Respuesta = leerLineaRespuesta(colaEntrada);
            if(objetodebug) Debug.Debug(debugger, Respuesta);

            if(Respuesta.startsWith("+OK"))
            {
                miSocket.close();
            }
        }
        catch(IOException ex)
        {
            this.cerrarConexion(objetodebug);
        }
    }
    else
    {
        if(objetodebug) Debug.Debug(debugger, "-->Cliente dice: La conexión está cerrada, todo cambio ha sido actualizado en el servidor");
    }
}    

	

	public void printSocketInfo(SSLSocket s) {
		System.out.println("Socket class: " + s.getClass());
		System.out.println("   Remote address = "
				+ s.getInetAddress().toString());
		System.out.println("   Remote port = " + s.getPort());
		System.out.println("   Local socket address = "
				+ s.getLocalSocketAddress().toString());
		System.out.println("   Local address = "
				+ s.getLocalAddress().toString());
		System.out.println("   Local port = " + s.getLocalPort());
		System.out.println("   Need client authentication = "
				+ s.getNeedClientAuth());
		SSLSession ss = s.getSession();
		System.out.println("   Cipher suite = " + ss.getCipherSuite());
		System.out.println("   Protocol = " + ss.getProtocol());
	}
	
	public boolean estaConectado(){

        if(!socketSSL.isClosed())
        {
            if(socketSSL.isConnected())
                return true;
            else return false;
        }
        else return false;
    }
}
