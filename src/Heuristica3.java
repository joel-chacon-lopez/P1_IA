public class Heuristica3 implements Heuristica {
    @Override
    public double calculaH(Node n1, Node n2) {
        return Math.abs(n1.getX()-n2.getX()) + Math.abs(n1.getY()-n2.getY());
    }
    
}
