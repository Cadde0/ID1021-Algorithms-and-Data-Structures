package Hash;

public class Main {
    public static void main(String[] args) {

        //"/Users/oscarcaddeo/Code/IdeaProjects/ID1021/Lab 8 - Hash/src/Hash/Postnummer.csv"

        Zip2 zip = new Zip2("/Users/oscarcaddeo/Code/IdeaProjects/ID1021/Lab 8 - Hash/src/Hash/Postnummer.csv");
        ZipKey zipKey = new ZipKey("/Users/oscarcaddeo/Code/IdeaProjects/ID1021/Lab 8 - Hash/src/Hash/Postnummer.csv");


        long t0;
        long t1;
        t0 = System.nanoTime();
        zipKey.Lookup(11115);
        t1 = System.nanoTime() - t0;
        System.out.println(t1);

        t0 = System.nanoTime();
        zipKey.Lookup(11115);
        t1 = System.nanoTime() - t0;
        System.out.println(t1);

        System.out.println();
        t0 = System.nanoTime();
        zip.Lookup_Binary(11115);
        t1 = System.nanoTime() - t0;
        System.out.println(t1);

        t0 = System.nanoTime();
        zip.Lookup_Binary(98495);
        t1 = System.nanoTime() - t0;
        System.out.println(t1);

        System.out.println();

        /*Zip2 zip2 = new Zip2("/Users/oscarcaddeo/Code/IdeaProjects/ID1021/Lab 8 - Hash/src/Hash/Postnummer.csv");

        zip2.Lookup_Binary(11115);
        zip2.Lookup_Binary(98495);

        System.out.println();

        ZipKey zipkey = new ZipKey("/Users/oscarcaddeo/Code/IdeaProjects/ID1021/Lab 8 - Hash/src/Hash/Postnummer.csv");

        zipkey.Lookup(11115);
        zipkey.Lookup(98495);*/
    }
}
