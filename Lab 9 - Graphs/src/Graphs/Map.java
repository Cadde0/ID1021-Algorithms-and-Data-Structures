package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 541;

    public Map(String file) {
        cities = new City[mod];

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                //Add both cities
                City from = lookup(row[0]);
                City to = lookup(row[1]);
                int dist = Integer.valueOf(row[2]);
                //Connect cities
                from.connect(to,dist);
                to.connect(from,dist);
            }

        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public City lookup(String name) {
        int i = hash(name);
        //Check if city exists
        while (cities[i] != null) {
            if (cities[i].name.equals(name)) {
                return cities[i];
            }
            //Last index
            i = (i + 1) % mod;
        }
        //Else create city
        cities[i] = new City(name);
        return cities[i];
    }
}
