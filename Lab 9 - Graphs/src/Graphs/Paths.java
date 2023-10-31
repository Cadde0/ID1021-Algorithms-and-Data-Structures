package Graphs;

public class Paths {
    City[] path;
    int sp;
    Integer max;

    public Paths() {
        this.path = new City[54];
        this.sp = 0;
        this.max = null;
    }

    public static void main(String[] args) {
        Map map = new Map("/Users/oscarcaddeo/Code/IdeaProjects/ID1021/Lab 9 - Graphs/src/Graphs/trains.csv");
        Paths path = new Paths();

        String from = "Stockholm";
        String to = "Halmstad";
        Integer max = null;

        long t0 = System.nanoTime();
        Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
        long time = ((System.nanoTime() - t0) / 1_000_000);

        System.out.println("shortest " + dist + " min (" + time + " ms)");
    }


    public Integer shortest(City from, City to, Integer max) {
        this.max = max;
        return shortest(from, to);
    }

    private Integer shortest(City from, City to) {
        if (from.equals(to)) {
            return 0;
        }
        if (max != null && sp >= max) {
            return null;
        }

        //Check if already in path
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }

        path[sp++] = from;
        Integer shrt = null;

        for (Connection connection : from.neighbors) {
            Integer pathDist = shortest(connection.city, to);

            if (pathDist != null) {
                int totDist = pathDist + connection.distance;
                if (shrt == null || totDist < shrt) {
                    shrt = totDist;
                }
            }
        }

        path[sp--] = null;

        return shrt;
    }
}
