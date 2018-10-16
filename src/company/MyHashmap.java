package company;

public class MyHashmap<K,V> {

    public boolean insertion=true;
    public static int DEFAULT_TABLE_SIZE = 16;
    Entry[] table;
    public Entry head=null;

    public Integer[] hashFunction(Integer[] arr, Integer[] hash){
        Integer[] a=new Integer[arr.length];
        for(int i=0; i<arr.length; i++){
            a[i]=(arr[i]%hash.length);
        }
        return a;
    }

    public MyHashmap(boolean insertion){
        this.insertion=insertion;
        table = new Entry[DEFAULT_TABLE_SIZE];
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

        public Entry getAfter(){ return after; }
        public V getVal(){ return val; }
        public K getKey(){ return key; }
    }

    public MyHashmap clone(){
        MyHashmap<K,V> newMap=new MyHashmap<>(this.insertion);
        Entry e=head;
        if(e==null){ return null; }
        while(e.after!=null){
            newMap.put((K)e.key, (V)e.val);
            e=e.after;
        }
        return newMap;
    }

    public boolean containsKey(Object k){
        if(get(k)==null){ return false; }
        return true;
    }

    public boolean containsValue(Object v){
        if(this.isEmpty()){ return false; }
        Entry e=head;
        while(e.val!=v&&e.after!=null){
            e=e.after;
        }
        if(e.val==v){ return true; }
        return false;
    }

    public Object getOrDefault(Object key, V defaultValue){
        Entry e=this.get(key);
        if(e==null){ return defaultValue; }
        return e;
    }

    public boolean isEmpty(){
        for(Entry e:table){
            if(e!=null){ return false; }
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
        if(this.put(key, value)==false){ return (V)this.get(key); }
        return null;
    }

    public boolean put(K k, V v){
        Entry p=new Entry(k, null);
        Entry e=table[p.hash];
        if(this.get(k)!=null){
            this.get(k).val=v;
            return true;
        }
        if(this.size()>=table.length){
            Entry[] t=new Entry[table.length*2];
            for(int i=0; i<table.length; i++){
                t[i]=table[i];
            }
            table=t;
        }
        Entry entry=new Entry(k, v);
        if(head==null){
            table[p.hash]=entry;
            head=entry;
            return true;
        }
        if(e==null){
            table[p.hash]=entry;
            if(this.insertion){
                e=head;
                while(e.after!=null){
                    e=e.after;
                }
                e.after=entry;
                entry.before=e;
                return true;
            }
            if(this.insertion){
                e=head;
                while(e.after!=null){
                    e=e.after;
                }
                e.after=entry;
                entry.before=e;
                return true;
            }
            entry.after=head;
            if(head!=null){head.before=e;}
            head=entry;
            return true;
        }
        while(e.next!=null){
            e=e.next;
        }
        e.next=entry;
        e.after=head;
        if(head!=null){head.before=e;}
        head=e;
        return true;
    }

    public void startFromFirst(){
        Entry e=head;
        boolean is=true;
        if(e==null){ is=false; }
        int i=1;
        while(e!=null&&is){
            System.out.print(i+": "+e.val+"  ");
            e=e.after;
            i++;
            if(i>10){
                System.out.println("infinite loop");
                is=false;
            }
        }
    }

    public boolean remove(Object key){
        Entry e=get(key);
        if(e==null){ return false; }

        Entry p=table[e.hash];
        if(e==p){
            if(e!=head){
                if(e.before!=null){ e.before.after = e.after; }
                if(e.after!=null){ e.after.before = e.before; }
            }
            else{
                if(e.after!=null){ e.after.before=null; }
                head=e.after;
            }
            table[p.hash]=e.next;
            e.before=null;
            e.after=null;
            e=null;
            return true;
        }
        while(p.next!=e){
            p=p.next;
        }
        p.next=e.next;
        if(e!=head){
            if(e.before!=null){
                e.before.after = e.after;
            }
            if(e.after!=null){
                e.after.before = e.before;
            }
        }
        else{
            if(e.after!=null){ e.after.before=null; }
            head=e.after;
        }
        e.before=null;
        e.after=null;
        e=null;
        return true;
    }

    public boolean remove(Object key, Object val){
        if(get(key)==null||get(key).val!=val){ return false; }
        return remove(key);
    }

    public V replace(K k, V v){
        Entry e=this.get(k);
        if(e==null){ return null; }
        V val=(V)e.val;
        e.val=v;
        return val;
    }

    public boolean replace(K key, V oldValue, V newValue){
        Entry e=get(key);
        if(e==null||e.val!=oldValue){ return false; }
        e.val=newValue;
        return true;
    }

    public Entry get(Object key){
        Entry p=new Entry(key, null);
        Entry e=table[p.hash];
        if(e == null){ return null; }
        while(!e.key.equals(key)){
            if(e==null){ return null; }e=e.next; }
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



/*
public Entry findItem(K key) {

 Entry currentPos = find(key);
 while(currentPos.key != key || currentPos.next != null) {
    currentPos = currentPos.next;

}


public void remove(K key) {
    Entry entryToRemove = find(key);
    prevEntry = entryToRemove.prev;
    if(entryToRemove.next != null) {
        nextEntry = entryToRemove.next
    }
    prevEntry.next = nextEntry;



    [   ]   ------ [   ]  ------ [     ]

    }
 */