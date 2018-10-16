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
        MyHashmap<Integer, Character> aMap = new MyHashmap<>(true);
        MyHashmap<Integer, Character> bMap = new MyHashmap<>(true);

        if (a == null || b == null) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            aMap.put(i, a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            bMap.put(i, b.charAt(i));
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
                return false;
            }
            while (ae.getVal() != be.getVal()) {
                if(be.getAfter()==null){
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
        System.out.println(anagram("listen","silent"));
        System.out.println(anagram("boolean","boogieman"));
    }
}
