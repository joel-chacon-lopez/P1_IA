import java.util.*;

public abstract class AlgorismeBase {
    public static final int[][] MOVIMENTS = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1} // abaix, dreta, adalt, esquerra
    };  

    public abstract Node cerca(int[][] matrix, Node inici, Node desti, Heuristica h);
    public List<Node> getGermans(int[][] matrix, Node n) {
        List<Node> germans = new ArrayList<>();
        for (int[] moviment : MOVIMENTS) {
            int x = n.getX() + moviment[0];
            int y = n.getY() + moviment[1];
            if (x >= 0 && x < 10 && y >= 0 && y < 10 && matrix[x][y] != -1) {
                double cost = (matrix[x][y] >= n.getAltura()) ? 1 + n.getCost() + (matrix[x][y] - n.getAltura()) : 0.5 + n.getCost();
                Node germà = new Node(x, y, matrix[x][y], cost, n);
                germans.add(germà);
            }
        }
        return germans;
    }
}
