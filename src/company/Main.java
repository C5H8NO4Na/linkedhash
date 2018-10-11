package company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        MyHashmap<Integer, String> mymap = new MyHashmap<>(false);

        mymap.put(1,"a");
        System.out.println("1: "+mymap.get(1).val);
        mymap.put(1,"b");
        System.out.println("2: "+mymap.get(1).val);
        mymap.put(2,"c");
        System.out.println("3: "+mymap.get(2).val);
        mymap.remove(1);
        mymap.put(1,"d");
        System.out.println("4: "+mymap.get(1).val);
        mymap.remove(1);
        System.out.println("5: "+mymap.get(1).val);
        mymap.put(4,"e");
        mymap.put(3,"f");
        mymap.put(2, "g");
        System.out.print("Access Order: ");
        mymap.startFromFirst();

        System.out.println("\n");

        MyHashmap<Integer, String> mymap2 = new MyHashmap<>(true);

        mymap2.put(1,"a");
        System.out.println("1: "+mymap2.get(1).val);
        mymap2.put(1,"b");
        System.out.println("2: "+mymap2.get(1).val);
        mymap2.put(2,"c");
        System.out.println("3: "+mymap2.get(2).val);
        mymap2.remove(1);
        mymap2.put(1,"d");
        System.out.println("4: "+mymap2.get(1).val);
        mymap2.remove(1);
        System.out.println("5: "+mymap2.get(1).val);
        mymap2.put(4,"e");
        mymap2.put(3,"f");
        mymap2.put(2, "g");
        System.out.print("Insertion Order: ");
        mymap2.startFromFirst();
    }
}
