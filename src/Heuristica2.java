// distancia euclidiana
public class Heuristica2 implements Heuristica {
    @Override
    public double calculaH(Node n1, Node n2) {
        return Math.sqrt(Math.pow(n1.getX()-n2.getX(), 2) + Math.pow(n1.getY()-n2.getY(), 2));
    }
    
}
