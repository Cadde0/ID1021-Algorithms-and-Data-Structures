package Hash;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip2 {
    Node[] data;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(int code, String name, int pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }
    public Zip2(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node Lookup_Linear (int zip) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].code == zip) {
                System.out.println(data[i].code);
                return data[i];
            }
        }
        throw new Error("Zip code not found");
    }

    public Node Lookup_Binary(int zip) {
        int left = 0;
        int right = this.max;
        while (left <= right) {
            int mid = left + (right-left) / 2;

            if (data[mid].code == zip) {
                System.out.println(data[mid].code);
                return data[mid];
            }

            if (zip > data[mid].code)
                left = mid + 1;
            else
                right = mid - 1;
        }
        throw new Error("Zip code not found");
    }


}
