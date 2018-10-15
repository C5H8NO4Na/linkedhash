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

    static boolean anagram(String a, String b){
        MyHashmap<Integer, String> aMap=new MyHashmap<>(true);
        MyHashmap<Integer, String> bMap=new MyHashmap<>(true);

        if(a==null||b==null){ return false; }

        for(int i=0; i<a.length(); i++){
            aMap.put(i, a.substring(i,i+1));
        }
        for(int i=0; i<b.length(); i++){
            bMap.put(i, b.substring(i,i+1));
        }

        if(aMap.size()!=bMap.size()){ return false; }

        Object ae=aMap.head;
        Object be;

        //while in while
        while(aMap.size()!=0){
            be=bMap.head;
            while(((MyHashmap.Entry) ae).getVal()!=((MyHashmap.Entry) be).getVal()){
                if(be==null){ return false; }
                be=((MyHashmap.Entry) be).getAfter();
            }
            ae=((MyHashmap.Entry) ae).getAfter();
        }
        return true;
    }

    public static void main(String[] args) {

        MyHashmap<Integer, String> mymap = new MyHashmap<>(false);

        mymap.put(1,"a");
        mymap.put(2,"b");
        mymap.remove(1);
        System.out.print("Access: ");
        mymap.startFromFirst();

        System.out.println("\n");

        MyHashmap<Integer, String> mymap2 = new MyHashmap<>(true);

        mymap2.put(1,"a");
        mymap2.put(2,"b");
        mymap2.remove(1);
        System.out.print("Insertion: ");
        mymap2.startFromFirst();

        System.out.println("\n");

        MyHashmap<Integer, String> mymap3 = new MyHashmap<>(true);
        mymap3.put(1,"a");
        mymap3.put(2,"b");
        mymap3.put(3,"c");
        System.out.print("Insertion: ");
        mymap3.startFromFirst();

        System.out.println("\n");

        MyHashmap<Integer, String> mymap4 = new MyHashmap<>(false);
        mymap4.put(1,"a");
        mymap4.put(2,"b");
        mymap4.put(3,"c");
        System.out.print("Access: ");
        mymap4.startFromFirst();


        String[] stringList = {"good","food","hood","glad","hammer"};
        String pattern = "wood";

        //System.out.println(anagram("santa","satan"));

    }
}
