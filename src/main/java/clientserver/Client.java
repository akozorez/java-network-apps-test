package clientserver;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String argv[]) throws Exception {
        Socket clientSocket = new Socket("127.0.0.1", 3000);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        out.println("Hello server, I`m user!");
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String result = in.readLine();
        System.out.println("server: "+ result);
        if(result.equals("We got your message bruda! Its ok!")){
            clientSocket.close();
        }
    }
}