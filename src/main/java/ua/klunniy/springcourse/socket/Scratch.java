package ua.klunniy.springcourse.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Scratch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8085)) {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             new Thread(() -> {
                 while (true) {
                     printWriter.println("hello my socket");
                     printWriter.println(scanner.nextLine());
                 }
            }).start();


            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String word;

            while ((word = bufferedReader.readLine()) != null) {
                System.out.println(word);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
