import java.net.*;
import java.io.*;

public class MyClient {
    public static void main(String[] args) throws Exception{
	{  
		System.out.println("Connecting to server... ");
		
		Socket socket = new Socket("localhost",3333);  
		
		System.out.println("Connected to server... ");
		
		DataInputStream input=new DataInputStream(socket.getInputStream());  
		DataOutputStream output=new DataOutputStream(socket.getOutputStream());
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		
				
		
		String str="",str2="";
		System.out.println("Start comminicating with Server. Write stop to finish ");
		System.out.println("Note that since this code only searches for a file.The code is designed in a way that nothing has to be written from server's end intentionally. Once you get file details search for another file using client's chat portal..Each time server will only fetch the details of file");
		
		while(!str.equals("stop"))
		{  
			str=br.readLine();  
			System.out.println("I want the file details of the file named: "+str);
			
			output.writeUTF(str);  
			output.flush();  
			
			str2=input.readUTF();  
			System.out.println("Details:"+str2);
		  
		}
		
		output.close();  
		socket.close();
    }

}
}