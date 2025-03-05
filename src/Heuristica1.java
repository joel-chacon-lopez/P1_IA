// aquesta heuristica compara l'altura del node a tractar amb l'altura del node final
public class Heuristica1 implements Heuristica {
    @Override
    public double calculaH(Node n1, Node n2) {
        return Math.abs(n1.getAltura()-n2.getAltura());
    }
    
}
