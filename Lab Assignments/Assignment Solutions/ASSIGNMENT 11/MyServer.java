import java.net.*;  
import java.io.*;  

public class MyServer 
{
	public static void main(String args[]) throws Exception 
	{
		ServerSocket server = new ServerSocket(3333);
		
		System.out.println("Server set up at port 3333.Waiting for client to connect");
		
		Socket connection = server.accept();
		
		System.out.println("Connected!");
		
		DataInputStream input=new DataInputStream(connection.getInputStream());
		DataOutputStream output=new DataOutputStream(connection.getOutputStream());
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		
		String str="";  
		System.out.println("Start comminicating with Client. Write stop when done");
		
		while(!str.equals("stop"))
		{ 
			
			str=input.readUTF();  
			System.out.println("client wants the information of the file: "+str);  

            System.out.println("Seraching for file....");
            File file = new File(str);
            
            if(file.exists()){
                int count =0;
                FileInputStream fis = new FileInputStream(file);
                byte[] bytesArray = new byte[(int)file.length()];
                fis.read(bytesArray);
                String s = new String(bytesArray);
                String [] data = s.split(" ");
                for (int i=0; i<data.length; i++) {
                   count++;
                }
                String path = file.getAbsolutePath();
                output.writeUTF("Path of the file is " + path + " and the total word count is " + count);  
            }

            else{
                String alert = "No file found!";
                output.writeUTF(alert);
            }

			output.flush();
		}
		

		input.close();
		connection.close();
		server.close();
	}
}