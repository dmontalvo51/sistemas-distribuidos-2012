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
	
	public Conexion(){
		try {
			conectar();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

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
		escribirConsola(respuestaServidor);
		
		enviarComando("PASS " + password);
		respuestaServidor=entradaDesdeServidor.readLine();
		escribirConsola(respuestaServidor);
		
	}

	public void enviarComando(String mensaje) throws IOException {
		salidaAServidor.writeBytes(mensaje+"\r\n");
	}
	
	
	public void nose(){
				try {
			SSLSocket c = (SSLSocket) socketFactory.createSocket("localhost", 8888);

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
	
public void cerrarConexion(){

    if(this.estaConectado())
    {
        try
         {
            enviarComando("QUIT");
            respuestaServidor = entradaDesdeServidor.readLine();
            escribirConsola(respuestaServidor);
            
            if(respuestaServidor.startsWith("+OK"))
            {
                socketSSL.close();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    else
    {
       System.out.println("-->Cliente dice: La conexión está cerrada, todo cambio ha sido actualizado en el servidor");
    }
}    

	

	public void printSocketInfo(SSLSocket s) {
		escribirConsola("Socket class: " + s.getClass());
		escribirConsola("   Remote address = "
				+ s.getInetAddress().toString());
		escribirConsola("   Remote port = " + s.getPort());
		escribirConsola("   Local socket address = "
				+ s.getLocalSocketAddress().toString());
		escribirConsola("   Local address = "
				+ s.getLocalAddress().toString());
		escribirConsola("   Local port = " + s.getLocalPort());
		escribirConsola("   Need client authentication = "
				+ s.getNeedClientAuth());
		SSLSession ss = s.getSession();
		escribirConsola("   Cipher suite = " + ss.getCipherSuite());
		escribirConsola("   Protocol = " + ss.getProtocol());
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
	
	public void escribirConsola(String mensaje){
		System.out.println(mensaje);
	}
}
