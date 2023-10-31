package Graphs;

public class City {
    String name;
    Connection[] neighbors;

    public City(String name) {
        this.name = name;
        this.neighbors = null;
    }
    public void connect(City nxt, int dist) {
        if (neighbors == null) {
            neighbors = new Connection[1];
            neighbors[0] = new Connection(nxt, dist);
        } else {
            Connection[] temp = new Connection[neighbors.length + 1];
            for (int i = 0; i < neighbors.length; i++) {
                temp[i] = neighbors[i];
            }
            temp[neighbors.length] = new Connection(nxt, dist);
            neighbors = temp;
        }
    }
}
