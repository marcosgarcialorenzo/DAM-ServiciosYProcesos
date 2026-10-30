package RA2.Practica1;

public class CalculadoraResta extends Thread {
    int a;
    int b;

    @Override
    public void run() {
        int resultado = a - b;
        System.out.println(resultado);
    }
}