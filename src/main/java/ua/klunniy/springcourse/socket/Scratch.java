package ua.klunniy.springcourse.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Scratch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8085)) {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                printWriter.println("hello my socket");
                printWriter.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
