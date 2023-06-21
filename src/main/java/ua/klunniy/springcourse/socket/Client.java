package ua.klunniy.springcourse.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8085)) {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            new Thread() {
                @Override
                public synchronized void run() {
                    String s = null;
                    try {
                        s = bufferedReader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (s != null)
                        System.out.println(s);
                }
            }.start();


            while (true) {
                printWriter.println("hello my socket");
                printWriter.println(scanner.nextLine());




            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
