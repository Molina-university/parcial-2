// Paula
// Molina
// Que YISUS nos ampare

import java.util.Random;
import java.util.Scanner;

public class Parcial {

    public static void main(String[] args) {
        int[][] laberinto = new int[5][5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        for (int fila = 0; fila < laberinto.length; fila++) {
            for (int col = 0; col < laberinto[fila].length; col++) {
                laberinto[fila][col] = random.nextInt(9) + 1;
            }
        }
        System.out.println("=== LABERINTO UNIVERSITARIO ===");
        mostrarMatriz(laberinto);

        System.out.println("""
        ¡Bienvenido al Laberinto Universitario!
        Este sistema representa los pasillos secretos de tu facultad.
        Cada número indica un nivel de energía en ese punto.
        Tu misión es explorar este laberinto cumpliendo los siguientes desafíos:

        1. Contar cuántos números pares hay mayores a 4.
        2. Calcular el promedio de los números impares. 
        3. Calcular la suma de los valores de cada fila. 
        4. BONUS: Encuentra la posición del mayor número del laberinto.
        """);
        System.out.println("\n ANÁLISIS DEL LABERINTO:");
        System.out.println("=" + "=".repeat(40));
        contarParesMayoresA4(laberinto);
        promedioImpares(laberinto);
        sumarFilas(laberinto);
        encontrarMayorNumero(laberinto);
        scanner.close();
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static void contarParesMayoresA4(int[][] matriz) {
        int contador = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                int valor = matriz[fila][col];
                // Verificar si es par Y mayor a 4
                if (valor % 2 == 0 && valor > 4) {
                    contador++;
                }
            }
        }      
        System.out.println("Números pares mayores a 4: " + contador);
    }

    public static void promedioImpares(int[][] matriz) {
        int sumaImpares = 0;
        int cantidadImpares = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                int valor = matriz[fila][col];
                if (valor % 2 != 0) {
                    sumaImpares += valor;
                    cantidadImpares++;
                }
            }
        }

        if (cantidadImpares > 0) {
            double promedio = (double) sumaImpares / cantidadImpares;
            System.out.println("Promedio de números impares: " + String.format("%.2f", promedio));
        } else {
            System.out.println("No hay números impares en la matriz");
        }
    }

    public static void sumarFilas(int[][] matriz) {
        System.out.println("Suma por filas:");
        for (int fila = 0; fila < matriz.length; fila++) {
            int sumaFila = 0;
            for (int col = 0; col < matriz[fila].length; col++) {
                sumaFila += matriz[fila][col];
            }
            System.out.println("   Fila " + (fila + 1) + ": " + sumaFila);
        }
    }

    public static void encontrarMayorNumero(int[][] matriz) {
        int valorMaximo = matriz[0][0];
        int filaMaximo = 0;
        int columnaMaximo = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                if (matriz[fila][col] > valorMaximo) {
                    valorMaximo = matriz[fila][col];
                    filaMaximo = fila;
                    columnaMaximo = col;
                }
            }
        }
        System.out.println(" BONUS - Número más alto del laberinto:");
        System.out.println("   Valor: " + valorMaximo);
        System.out.println("   Posición: Fila " + (filaMaximo + 1) + ", Columna " + (columnaMaximo + 1));
        System.out.println("   Coordenadas matriz: [" + filaMaximo + "][" + columnaMaximo + "]");
    }
}