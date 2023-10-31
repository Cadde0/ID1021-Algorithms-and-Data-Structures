package Graphs;

public class Naive {


    public static void main(String[] args) {
        Map map = new Map("/Users/oscarcaddeo/Code/IdeaProjects/ID1021/Lab 9 - Graphs/src/Graphs/trains.csv");

        String from = "Umeå";
        String to = "Göteborg";
        Integer max = 750;

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = ((System.nanoTime() - t0) / 1_000_000);

        System.out.println("shortest " + dist + " min (" + time + " ms)");
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];

                Integer temp = shortest(conn.city, to, max-conn.distance);

                // When we find the "to" destination
                // Incase an other path is found, compare them. (Adds the distance from the prior city to this one,
                // since the current shrt already has it added).
                if(temp != null && (shrt == null || shrt > temp + conn.distance)) {
                    shrt = temp + conn.distance;
                }
            }
        }
        return shrt;
    }
}
