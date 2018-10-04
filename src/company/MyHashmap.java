package company;

public class MyHashmap<K,V> {


    //insertion order vs access order

    public static int DEFAULT_TABLE_SIZE = 16;
    Entry[] table = new Entry[DEFAULT_TABLE_SIZE];
    private Entry head=null;

    public Integer[] hashFunction(Integer[] arr, Integer[] hash){
        Integer[] a=new Integer[arr.length];
        for(int i=0; i<arr.length; i++){
            a[i]=(arr[i]%hash.length);
        }
        return a;
    }

    public class Entry <K, V>{
        public K key;
        public V val;
        private int hash;
        private Entry next;
        private Entry after;
        private Entry before;

        Entry(K k, V v){
            key=k;
            val=v;
            next=null;
            hash=key.hashCode()&(table.length-1);
        }

    }

    public boolean containsKey(Object k){
        if(get(k)==null){
            return false;
        }
        return true;
    }

    public boolean containsValue(Object v){
        if(this.isEmpty()){ return false; }
        Entry e=head;
        while(e.val!=v&&e.after!=null){
            e=e.after;
        }
        if(e.val==v){
            return true;
        }
        return false;
    }

    public Object getOrDefault(Object key, V defaultValue){
        Entry e=this.get(key);
        if(e==null){
            return defaultValue;
        }
        return e;
    }

    public boolean isEmpty(){
        for(Entry e:table){
            if(!e.equals(null)){
                return false;
            }
        }
        return true;
    }

    public boolean removeEldestEntryB(){
        if(this.isEmpty()){ return false; }
        Entry e=head;
        while(e.after!=null){
            e=e.after;
        }
        if(e.before!=null){
            e=e.before;
            e.after=null;
            return true;
        }
        e.val=null;
        e.key=null;
        return true;
    }

    public V putIfAbsent(K key, V value){
        if(this.put(key, value)==false){
            return (V)this.get(key);
        }
        return null;
    }

    //FIXX
    public boolean put(K k, V v){
        Entry p=new Entry(k, null);
        Entry e=table[p.hash];
        if(this.get(k)!=null){
            return false;
        }
        if(this.size()>=table.length){
            Entry[] t=new Entry[table.length*2];
            for(int i=0; i<table.length; i++){
                t[i]=table[i];
            }
            table=t;
        }
        if(e==null){
            table[p.hash]=new Entry(k, v);
            return true;
        }
        while(e.next!=null){
            e=e.next;
        }
        e.next=new Entry(k, v);
        return true;
    }

    //a
    public void startFromFirst(){

    }

    //FOXXXX
    public boolean remove(Object key){
        Entry p=new Entry(key, null);
        if(table[p.hash]==null) {
            return false;
        }
        Entry e=table[p.hash];

        if(e.key.equals(key)&&e.next==null){
            table[p.hash]=null;
            return true;
        }
        while(!e.key.equals(key) && e.next!=null){
            e=e.next;
        }
        if(e.next==null){
            return false;
        }
        e.next=e.next.next;
        return true;
    }

    public V replace(K k, V v){
        Entry e=this.get(k);
        if(e==null){
            return null;
        }
        V val=(V)e.val;
        e.val=v;
        return val;
    }

    public Entry get(Object key){
        Entry p=new Entry(key, null);
        Entry e=table[p.hash];
        if(e == null){
            return null;
        }
        while(!e.key.equals(key)){
            if(e==null){
                return null;
            }
            e=e.next;
        }
        return e;
    }

    public int size(){
        int n=0;
        for(Entry e:table){
            if(e!=null){
                n+=1;
                while(e.next!=null){
                    e=e.next;
                    n+=1;
                }
            }
        }
        return n;
    }

    private void clear(){
        table=new Entry[DEFAULT_TABLE_SIZE];
    }
}
