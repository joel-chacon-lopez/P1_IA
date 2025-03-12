// distancia Manhattan amb penalització per diferència d'altures
public class Heuristica3 implements Heuristica {
    @Override
    public double calculaH(Node n1, Node n2) {
        int alturaActual = n1.getAltura();
        int alturaMeta = n2.getAltura();
        return Math.abs(n2.getX() - n1.getX()) + Math.abs(n2.getY() - n1.getY()) + Math.max(0, (alturaMeta - alturaActual)) / 2.0;
    }
    
}
