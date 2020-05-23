package clientserver;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) throws Exception {
        int port = 3000;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Listen on ::*"+port);

        Socket client = ss.accept();
        System.out.println("Client connected");
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());

        String clientMsg = in.readLine();
        System.out.println("Client: "+clientMsg);

        if(clientMsg.equals("Hello server, I`m user!")){
            out.println("We got your message bruda! Its ok!");
            out.flush();
            client.close();
        }
    }
}