package RA3.Socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        try {
            socketCliente = new Socket("localhost", 4444);
            entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("No puede establecer canales de E/S para la conexión");
            System.exit(-1);
        }

        Scanner stdIn = new Scanner(System.in);
        String linea;

        try {
            while (true) {
                System.out.print("Operación (ej: 3+4, 5-3) o Adios: ");
                linea = stdIn.nextLine();
                salida.println(linea);

                linea = entrada.readLine();
                if (linea == null) {
                    break;
                }
                System.out.println("Respuesta servidor: " + linea);

                if (linea.equals("Adios")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        salida.close();
        entrada.close();
        stdIn.close();
        socketCliente.close();
    }
}