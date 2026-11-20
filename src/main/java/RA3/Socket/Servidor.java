package RA3.Socket;

import java.io.*;
import java.net.*;

public class Servidor {

    public static final int PORT = 4444;

    public static void main(String[] args) throws IOException {
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }

        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        System.out.println("Escuchando: " + socketServidor);
        try {
            socketCliente = socketServidor.accept();
            System.out.println("Conexión aceptada: " + socketCliente);

            entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socketCliente.getOutputStream())), true);

            while (true) {
                String str = entrada.readLine();
                if (str == null) {
                    break;
                }
                System.out.println("Cliente: " + str);

                if (str.equals("Adios")) {
                    salida.println("Adios");
                    break;
                }

                salida.println(calcular(str));
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        if (salida != null) salida.close();
        if (entrada != null) entrada.close();
        if (socketCliente != null) socketCliente.close();
        socketServidor.close();
    }

    // Recibe una operación como "3+4" o "5-3" y devuelve el resultado
    private static String calcular(String operacion) {
        try {
            operacion = operacion.replace(" ", "");

            // Se busca el operador a partir de la posición 1
            // para permitir un primer número negativo (ej: -5+3)
            int pos = -1;
            for (int i = 1; i < operacion.length(); i++) {
                char c = operacion.charAt(i);
                if (c == '+' || c == '-') {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                return "Error: operación no válida";
            }

            double a = Double.parseDouble(operacion.substring(0, pos));
            double b = Double.parseDouble(operacion.substring(pos + 1));
            char operador = operacion.charAt(pos);

            double resultado = (operador == '+') ? a + b : a - b;

            // Si el resultado es entero se muestra sin decimales (7 en vez de 7.0)
            if (resultado == (long) resultado) {
                return String.valueOf((long) resultado);
            }
            return String.valueOf(resultado);

        } catch (NumberFormatException e) {
            return "Error: operación no válida";
        }
    }
}