package HP35;


public class Main{
    public static void main(String[] args) {

        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        /*Item[] expr = {
                Item.Value(10),
                Item.Value(2),
                Item.Value(5),
                Item.Mul(),
                Item.Add()
        };*/

        //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 + * + * + * + * + * + * + * +
        /*Item[] expr = {
                Item.Value(1),
                Item.Value(2),
                Item.Value(3),
                Item.Value(4),
                Item.Value(5),
                Item.Value(6),
                Item.Value(7),
                Item.Value(8),
                Item.Value(9),
                Item.Value(10),
                Item.Value(11),
                Item.Value(12),
                Item.Value(13),
                Item.Value(14),
                Item.Value(15),
                Item.Value(16),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),

        };*/
        //Benchmark
        Item[] expr = {
                Item.Value(0)
        };

        Calculator calc = new Calculator(expr);
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 100000; i++) {
            double t0 = System.nanoTime();
            for (int o = 0; o < 10000; o++) {
                calc.stack.push(i);
            }
            for (int c = 0; c < 10000; c++) {
                calc.stack.pop();
            }
            double t1 = System.nanoTime();
            double t = t1 - t0;
            
            if(t < min) {
                min = t;
            }
        }
        System.out.println("Minimum : " + min);
        //int res = calc.run();
        //System.out.println(" Calculator: res = " + res);
        //System.out.println("Time : " + );

    }
}
