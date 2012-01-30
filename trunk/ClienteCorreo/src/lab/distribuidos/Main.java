package lab.distribuidos;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Conexion conexion=new Conexion("localhost",110);
		
		conexion.iniciarSesion("dmontalvo@neoalfanet.com","c0ntr4s3n4");

	}

}
