import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AStar extends AlgorismeBase {

    @Override
    public Node cerca(int[][] matrix, Node inici, Node desti, Heuristica h) {
        List<Node> pends = new ArrayList<>();
        Set<String> visitats = new HashSet<>();

        pends.add(inici);

        while (!pends.isEmpty()) {
            pends.sort(Comparator.comparingDouble(n -> n.getCost() + h.calculaH(n, desti)));
            //System.out.println("Proxim pendent a tractar: " + "(" + pends.get(0).getX() + "," + pends.get(0).getY() + ")");
            
            Node actual = pends.remove(0);
            //System.out.println("Llista de visitats: " + visitats.toString());
            //System.out.println("Node actual: (" + actual.getX() + "," + actual.getY() + ")");

            if (actual.equals(desti)) { System.out.println("Total de nodes visitats: " + visitats.size()); return actual;}

            visitats.add(actual.x + "," + actual.y);
            pends.remove(actual);

            for (Node vecino : getGermans(matrix, actual)) {
                if (!visitats.contains(vecino.x + "," + vecino.y) && !pends.contains(vecino)) {
                    pends.add(vecino);
                }
            }
        }
        return null;
    }
    
}
