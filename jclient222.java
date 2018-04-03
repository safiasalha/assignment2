

import java.io.IOException;

import java.io.PrintWriter;

import java.net.InetAddress;

import java.net.Socket;

import java.util.Scanner;

public class client222 {

    private Socket socket;

    private Scanner scanner;

    private client222(InetAddress serverAddress, int serverPort) 
throws Exception {

        this.socket = new Socket(serverAddress, serverPort);

        this.scanner = new Scanner(System.in);

    }

    private void start() throws IOException {

        String input;

        while (true) {

            input = scanner.nextLine();

            PrintWriter out = new 
PrintWriter(this.socket.getOutputStream(), true);

            out.println(input);

            out.flush();

        }

    }

    

    public static void main(String[] args) throws Exception {

        client222 client = new client222(

                InetAddress.getByName(args[0]), 

                Integer.parseInt(args[1]));

        

        System.out.println("\r\nConnected to Server: " + 
client.socket.getInetAddress());

        client.start();                

    }

}
