
public class Node {
    int altura;
    int x, y;
    double cost;
    Node pare;

    public Node(int x, int y, int altura) {
        this.x = x;
        this.y = y;
        this.altura = altura;
    }
    
    public Node(int x, int y, int altura, double cost, Node pare) {
        this.x = x;
        this.y = y;
        this.altura = altura;
        this.cost = cost;
        this.pare = pare;
    }
    
    public boolean equals(Node n) {
        return (x == n.x && y == n.y && altura == n.altura);
    }

    //getters & setters
    public int getAltura() { return altura; }
    public void setAltura(int altura) { this.altura = altura; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public Node getPare() { return pare; }
    public void setPare(Node pare) { this.pare = pare; }
}
