package Hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ZipKey {
    Node[] data;
    int max;

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
    public ZipKey(String file) {
        data = new Node[100_000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[code] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node Lookup(int zip) {
        if (data[zip] == null) {
            throw new Error("Zip Code Not Found");
        }
        System.out.println(data[zip].code);
        return data[zip];
    }
}

