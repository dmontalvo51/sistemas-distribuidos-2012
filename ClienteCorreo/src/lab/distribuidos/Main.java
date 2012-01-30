package lab.distribuidos;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Conexion conexion=new Conexion("127.0.0.1",110);
		
		conexion.iniciarSesion("dmontalvo@neoalfanet.com","123456");

	}

}
