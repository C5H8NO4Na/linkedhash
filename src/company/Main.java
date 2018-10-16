package company;

public class Main {

    /* Challenge 1:
    sing HashMaps, create a method that will allow a user to input two string values and determine if
    those strings are anagrams.


    Challenge 2:
    Using HashMaps, iterate through an Array of Strings to that are compared against a pattern. For example:

    stringList[] = ["good","food","hood","glad","hammer"]
    pattern = "wood"

    result = ["good","food","hood"]
     */

    static boolean anagram(String a, String b) {
        MyHashmap<Integer, String> aMap = new MyHashmap<>(true);
        MyHashmap<Integer, String> bMap = new MyHashmap<>(true);

        if (a == null || b == null) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            aMap.put(i, a.substring(i, i + 1));
        }
        for (int i = 0; i < b.length(); i++) {
            bMap.put(i, b.substring(i, i + 1));
        }

        if (aMap.size() != bMap.size()) {
            return false;
        }

        MyHashmap.Entry ae = aMap.head;
        MyHashmap.Entry be = bMap.head;
        while (aMap.size() != 0) {
            be=bMap.head;
            ae=aMap.head;
            if (be == null) {
                System.out.println("h");
                return false;
            }
            while (ae.getVal() != be.getVal()) {
                System.out.println("!");
                if(be.getAfter()==null){
                    System.out.println("a");
                    return false;
                }
                be=be.getAfter();
            }
            bMap.remove(be.getKey());
            aMap.remove(ae.getKey());
        }
        return true;
    }

    public static void main(String[] args) {
        MyHashmap<Integer, String> mymap12 = new MyHashmap<>(true);
        mymap12.put(1,"a");
        mymap12.put(2,"b");
        mymap12.remove(1);
        System.out.println(mymap12.size());
        mymap12.startFromFirst();

        //FIX ACCESS ORDEREOE
        MyHashmap<Integer, String> mymap = new MyHashmap<>(false);
        mymap.put(1,"a");
        mymap.put(2,"b");
        mymap.remove(1);
        System.out.print("Access: ");
        mymap.startFromFirst();
        System.out.println(mymap.size());

        String[] stringList = {"good","food","hood","glad","hammer"};
        String pattern = "wood";

        System.out.println(anagram("santa","satan"));
    }
}
