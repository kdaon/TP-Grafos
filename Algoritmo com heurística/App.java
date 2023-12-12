import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de vértices: ");
        int nVertices = scanner.nextInt();

        int[][] matriz = lerMatriz(nVertices);
        int[] cores = colorirHGulosa(matriz, nVertices);

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
    
    public static int[] colorirHGulosa(int[][] matriz, int nVertices) {
        int[] cores = new int[nVertices];
        Arrays.fill(cores, -1); // Inicializa todos os vértices sem cor
    
        for (int vertice = 0; vertice < nVertices; vertice++) {
            boolean[] coresVizinhas = new boolean[nVertices];
    
            for (int vAdj = 0; vAdj < nVertices; vAdj++) {
                if (matriz[vertice][vAdj] == 1 && cores[vAdj] != -1) {
                    coresVizinhas[cores[vAdj]] = true;}
            }
    
            for (int cor = 0; cor < nVertices; cor++) {
                if (!coresVizinhas[cor]) {
                    cores[vertice] = cor;
                    break;
                }
            }
        }
        return cores;
    }

}