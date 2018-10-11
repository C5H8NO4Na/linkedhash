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
        System.out.print(mymap.get(1));
        mymap.startFromFirst();

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
        System.out.print(mymap2.get(1));
        mymap.startFromFirst();
    }
}
