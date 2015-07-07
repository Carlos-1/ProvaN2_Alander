import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPServerThread implements Runnable {

    private Socket  _socket;
    private long    _id;
	private String  _mesg;
    
    public void TCPTServerhread(Socket socket, String msg, long id){
      _socket = socket;
	  _id = id;
	  _mesg = msg;
	  
    }
	public void gravarArquivo(String msg) throws Exception
	
{
		
File file = new File("C://tmp//teste.txt");
		
FileWriter w = new FileWriter(file);
	
w.write("msg:" + getMensagem());
	
w.close();
	
}
    private String getMensagem() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
    public void run()
    {
        try 
        {
           
            BufferedReader doCliente = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            
            String linha = doCliente.readLine();
            String delimitador = "[ /]+";
            
            String[] tokens = linha.split(delimitador);
            
            for (int i = 0; i < tokens.length; i++)
                System.out.println(tokens[i]);
            
     
            DataOutputStream paraCliente = new DataOutputStream(_socket.getOutputStream());
            
            FileReader ler = new FileReader(tokens[1]);
            
            BufferedReader buffer = new BufferedReader(ler);
            
            linha = buffer.readLine();
            
            while (linha != null) 
            {
                paraCliente.writeBytes(linha);
                
                linha = buffer.readLine();
            }        
            
            _socket .close();
            
             //_id .close();			
        }
        catch (Exception ex)
        {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
	
	


	private void setMensagem(String string) {
		// TODO Auto-generated method stub
		
	}
	private void gravarArquivo() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		TCPServerThread msg = new TCPServerThread();
	
   msg.setMensagem("testando a classe File e a classe FileWrite");
			
   msg.gravarArquivo();

}
  
  }
    