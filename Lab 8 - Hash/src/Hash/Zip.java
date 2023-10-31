package Hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Zip {

    Node[] data;
    int max;

    public class Node {

        String code;
        String name;
        Integer pop;

        public Node(String code, String name, Integer pop) {

            this.code = code;
            this.name = name;
            this.pop = pop;

        }
    }


    public Zip(String file) {

        data = new Node[10000];

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node Lookup_Linear (String zip) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null)
                break;
            else if (data[i].code.equals(zip)) {
                System.out.println(data[i].code);
                return data[i];
            }
        }
        throw new Error("Zip code not found");
    }

    public Node Lookup_Binary(String zip) {
        int left = 0;
        int right = this.max;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            int res = zip.compareTo(this.data[mid].code);
            if (res == 0) {
                System.out.println(data[mid].code);
                return data[mid];
            }

            if (res > 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        throw new Error("Zip code not found");
    }

}
