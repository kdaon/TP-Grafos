/*
 * Algoritmo de coloração de vértices
 * utilizando força bruta
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

    // Lê a matriz de adjacência do grafo
    public static int[][] lerMatriz(int nVertices) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[nVertices][nVertices];

        System.out.println("Insira a matriz de adjacência com 0 ou 1:");
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz; 
    }
    
    // Função principal para colorir os vértices. Retorna um vetor com as cores atribuídas
    public static int[] colorirVertices(int[][] matriz, int nVertices) {
        int[] cores = new int[nVertices];
        for (int i = 0; i < nVertices; i++) {
            cores[i] = -1; // Inicializa todas as cores como -1
        }

        // Chama a função recursiva para colorir os vértices, passando por parâmetro a matriz de adjacência, o vetor de cores, o número de vértices e o vértice inicial
        colorirRecursivo(matriz, nVertices, cores, 0);

        return cores;
    }

    // Função recursiva para colorir os vértices
    private static boolean colorirRecursivo(int[][] matriz, int nVertices, int[] cores, int vertice) {
        if (vertice == nVertices) {
            return true; // Todas as cores atribuídas, solução encontrada
        }

        // Testa todas as cores possíveis para o vértice atual
        for (int cor = 0; cor < nVertices; cor++) {
            if (podeAtribuirCor(matriz, cores, vertice, cor)) {
                cores[vertice] = cor;

                // Testa recursivamente as cores para os vértices restantes
                if (colorirRecursivo(matriz, nVertices, cores, vertice + 1)) {
                    return true; // Solução encontrada
                }
                cores[vertice] = -1; // Se a cor não funcionou, remove a atribuição (backtracking) = volta ao estado anterior
            }
        }

        return false; // Nenhuma solução encontrada para a configuração atual
    }

    // Função para verificar se é possível atribuir uma cor a um vértice
    private static boolean podeAtribuirCor(int[][] matriz, int[] cores, int vertice, int cor) {
        
        // Verifica se o vértice já possui uma cor atribuída
        for (int verticeAdj = 0; verticeAdj < vertice; verticeAdj++) {
            if (matriz[vertice][verticeAdj] == 1 && cores[verticeAdj] == cor) {
                return false; // Cor já atribuída a um vértice adjacente, não pode atribuir
            }
        }
        return true; // Nenhuma cor atribuída a um vértice adjacente, pode atribuir
    }
}
