package Hash;

public class Buckets {
    Node[] array = new Node[1];

    public class Node {
        int code;
        String name;
        int pop;

        public Node(int code, String name, int pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public void add(Node node) {
        array[array.length - 1] = node;
        Node[] source = array;
        Node[] copy = new Node[array.length + 1];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }
        this.array = copy;
    }

    public Node findByCode(int zip) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].code == zip) {
                return array[i];
            }
        }
        throw new Error("Zip Code Not Found");
    }
}
