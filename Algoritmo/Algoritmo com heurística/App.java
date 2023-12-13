/*
 *  Algoritmo de coloração de vértices
 *  utilizando Heurística Gulosa
 */
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de vértices: ");
        int nVertices = scanner.nextInt();

        int[][] matriz = lerMatriz(nVertices);

        // vai calcular o grau de cada vértice
        int[] grau = calcularGrau(matriz, nVertices);

        // Cria um array de índices dos vértices em ordem decrescente de grau
        Integer[] indices = new Integer[nVertices];
        for (int i = 0; i < nVertices; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(grau[b], grau[a])); 

        int[] cores = colorirHeuristica(matriz, nVertices, indices);

        // exibe os vértices e suas respectivas cores
        for (int i = 0; i < nVertices; i++) {
            System.out.println("Vértice " + (i + 1) + " colorido com a cor " + cores[i]);
        }
    }

    // método para calcular o grau de cada vértice
    public static int[] calcularGrau(int[][] matriz, int nVertices) {
        int[] grau = new int[nVertices];
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                grau[i] = grau[i] + matriz[i][j];
            }
        }
        return grau;
    }

    public static int[][] lerMatriz(int nVertices) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[nVertices][nVertices];
        System.out.println("Insira a matriz de adjacência somente com 0 ou 1:");
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }

    public static int[] colorirHeuristica(int[][] matriz, int nVertices, Integer[] ordemVertices) {
        int[] cores = new int[nVertices];
        for (int i = 0; i < nVertices; i++) { 
            cores[i] = -1; 
        }
    
        // vai percorrer os vértices em ordem decrescente de grau
        for (int i : ordemVertices) {
            boolean[] coresVizinhas = new boolean[nVertices];
            
            // verificação pra evitar que se repita cor entre vértices vizinhos
            for (int vizinho = 0; vizinho < nVertices; vizinho++) {
                if (matriz[i][vizinho] == 1 && cores[vizinho] != -1) {
                    coresVizinhas[cores[vizinho]] = true;
                }
            }
            
            // vai usar a primeira cor disponível
            for (int cor = 0; cor < nVertices; cor++) {
                if (!coresVizinhas[cor]) {
                    cores[i] = cor;
                    break;
                }
            }
        }
        return cores;
    }
}
