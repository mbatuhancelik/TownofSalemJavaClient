import java.net.*;
import java.util.Random;
import java.io.*;

public class Client {
    public static String[] colors =new String[] {"black","green","purple","blue","pink"};
    private String hostIP;
    private int port;
    public String userName;
    public ReadThread ReadThread;
    public WriteThread WriteThread;
    public String color;
    private GUI Interface = new GUI();
    public Client(String hostIP, int port){
        this.hostIP = hostIP;
        this.port= port;
        Random n = new Random();
        int index = n.nextInt(colors.length-1);
        this.color = colors[index];
    }
    public void execute() {
        try{
            Socket socket = new Socket(hostIP, port);
            System.out.println("Connected to "+hostIP+":"+port);
            
            this.ReadThread  = new ReadThread(socket, this,Interface);
            this.ReadThread.start();
            this.WriteThread = new WriteThread(socket, this,Interface);
            this.WriteThread.start();
        }
        catch(UnknownHostException ex){
            System.out.println("Server not found" + ex.getMessage());
        }
        catch(IOException ex){
            System.out.println("I/O error" + ex.getMessage());
        }
    }
    public String getUserName(){
        return this.userName;
        
    }
    public void setUserName(String userName) {
        if(userName != null)
            this.userName = userName;
    }
    public static Client client;
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Syntax: java Client IP Port ");
            return;
        }
        String hostname = args[0];
        int port  = Integer.parseInt(args[1]);
        client = new Client(hostname, port);
        client.execute();
    }


}