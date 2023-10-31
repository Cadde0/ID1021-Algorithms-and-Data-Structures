package Hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class Hash {
    int m = 1000; //modulo
    int max;
    int[] keys = new int[10_000];
    Node[] data;

    public class Node {
        String code;
        String name;
        Integer pop;

        public Node(String code, String name, int pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }
    public Hash(String file) {
        data = new Node[100_000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                keys[i] = code; //Imp
                data[code] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public int hash(int value) {
        return value % m;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }
}
