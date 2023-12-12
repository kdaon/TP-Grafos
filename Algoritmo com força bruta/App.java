/*
 * Algoritmo de coloração de vértices
 * Utilização de força bruta (função recursiva) 
 * @author Olivia Campos, Mathias Silva Sousa, Raynner Taniguchi
 */

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de vértices: ");
        int nVertices = scanner.nextInt();

        int[][] matriz = lerMatriz(nVertices);

        int[] cores = colorirVertices(matriz, nVertices);

        // Exibir resultados
        for (int i = 0; i < nVertices; i++) {
            System.out.println("Vértice " + (i + 1) + " colorido com a cor " + cores[i]);
        }
    }

    public static int[][] lerMatriz(int nVertices) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[nVertices][nVertices];

        System.out.println("Digite a matriz de adjacência (0 ou 1):");
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }
    
    public static int[] colorirVertices(int[][] matriz, int nVertices) {
        int[] cores = new int[nVertices];
        Arrays.fill(cores, -1); // Inicializa todos os vértices sem cor

        colorirRecursivo(matriz, nVertices, cores, 0);

        return cores;
    }

    private static boolean colorirRecursivo(int[][] matriz, int nVertices, int[] cores, int vertice) {
        if (vertice == nVertices) {
            return true; // Todas as cores atribuídas, solução encontrada
        }

        for (int cor = 0; cor < nVertices; cor++) {
            if (podeAtribuirCor(matriz, cores, vertice, cor)) {
                cores[vertice] = cor;

                if (colorirRecursivo(matriz, nVertices, cores, vertice + 1)) {
                    return true; // Solução encontrada
                }
                cores[vertice] = -1; // Backtrack
            }
        }

        return false; // Nenhuma solução encontrada para a configuração atual
    }

    private static boolean podeAtribuirCor(int[][] matriz, int[] cores, int vertice, int cor) {
        for (int verticeAdj = 0; verticeAdj < vertice; verticeAdj++) {
            if (matriz[vertice][verticeAdj] == 1 && cores[verticeAdj] == cor) {
                return false; // Conflito de cor
            }
        }
        return true;
    }
}
