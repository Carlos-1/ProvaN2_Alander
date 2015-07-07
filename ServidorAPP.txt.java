import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
*
* @author Carlos Barromeu
*/

public class ServidorAPP{
	
	public static void main(String [] args) throws Exception{
		
		System.out.println("Inicialisando Servidor: ");
		
		ServerSocket sever = new ServerSocket(9090);
		
		System.out.println(" Aguardando Conexão: ");
		
		Socket socket = sever.accept();
		System.out.println(" Conexão Estabelecida: ");
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);
		
		while(true){
			String msg = in.readLine();
			
System.out.println( "Mensagem Recebida do Cliente [" + 
            "]: " + msg);
			
			if("Fim".equals(msg)){
				break;
			}
			out.println(msg);
		}
		System.out.println(" Encerrando a Conexão: ");
		
		in.close();
		out.close();
		socket.close();
		
		System.out.println(" Encerrando o Serv"
				+ "idor: ");
		
		sever.close();
	}
}
