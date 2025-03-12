import java.io.*;
import java.util.*;

public class Test {
    private static int[][] matrix = new int[10][10];

    public static void readTxt(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int j = 0;
                for (String part : parts) {
                    matrix[i][j] = Integer.parseInt(part);
                    j++;
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void imprimirResultat(Node node) {
        if (node == null) {
            System.out.println("No s'ha trobat el cami!");
            return;
        }
        List<String> cami = new ArrayList<>();
        double costTotal = node.getCost();

        while (node != null) {
            cami.add("(" + node.getX() + "," + node.getY() + ")");
            node = node.getPare();
        }

        Collections.reverse(cami);
        System.out.println("Cami: " + cami);
        System.out.println("Cost total: " + costTotal);
    }

    public static void mostraTauler(int[][] m) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("Escull tauler: (1 o 2)");
                while (true) {
                    int tauler = sc.nextInt();
                    if (tauler == 1 || tauler == 2) {
                        readTxt("mapa" + tauler + ".txt");
                        break;
                    } else {
                        System.out.println("Tauler no vàlid, torna a intentar-ho");
                    }
                }
                mostraTauler(matrix);
                
                Node inici = new Node(0, 0, matrix[0][0]);
                Node fi = new Node(9, 9, matrix[9][9]);
                Heuristica h1 = new Heuristica1();
                Heuristica h2 = new Heuristica2();
                Heuristica h3 = new Heuristica3();
                AlgorismeBase bf = new BestFirst();
                AlgorismeBase a = new AStar();

                System.out.println("-----------------------------");
                System.out.println("Heuristica 1: Comparacio d'altures");
                System.out.println("Best First:");
                imprimirResultat(bf.cerca(matrix, inici, fi, h1));
                System.out.println("A*:");
                imprimirResultat(a.cerca(matrix, inici, fi, h1));

                System.out.println("-----------------------------");

                System.out.println("Heuristica 2: Distancia Euclidiana");
                System.out.println("Best First:");
                imprimirResultat(bf.cerca(matrix, inici, fi, h2));
                System.out.println("A*:");
                imprimirResultat(a.cerca(matrix, inici, fi, h2));
                
                System.out.println("-----------------------------");

                System.out.println("Heuristica 3: Distancia Manhattan");
                System.out.println("Best First:");
                imprimirResultat(bf.cerca(matrix, inici, fi, h3));
                System.out.println("A*:");
                imprimirResultat(a.cerca(matrix, inici, fi, h3));
            }
        }        
    }
}