import java.util.LinkedList;

public class MyHashmap<K,V>{
    private LinkedList<Entry<K,V>>[] buckets;
    private int size=0;
     @SuppressWarnings("unchecked")
     public MyHashmap(){
         buckets=new LinkedList[16];
     }
     public void put(K key,V value){
         int index=getIndex(key);
         if (buckets[index]==null) {
             buckets[index]=new LinkedList<>();
         }
         for (Entry<K,V>entry:buckets[index]){
             if(entry.key.equals(key)){
                 entry.value=value;
                 return;
             }
         }
         buckets[index].add(new Entry<>(key,value));
         size++;
     }
      public V get(K key){
         int index=getIndex(key);
         if(buckets[index]==null){
             return null;
         }
         for (Entry<K,V>entry:buckets[index]){
             if(entry.key.equals(key)){
                 return entry.value;
             }
         }
         return null;
      }
      private  int getIndex(K key){
         if(key==null){return 0;}
         return (key.hashCode())%buckets.length;
      }
      private static class Entry<K,V>{
         K key;
         V value;
         Entry(K key,V value){
             this.key=key;
             this.value=value;
         }
      }
      public static void main(String[] args){
         MyHashmap<String,Integer> map=new MyHashmap<>();
         map.put("向伟",20);
         map.put("岑森",25);
         System.out.println(map.get("向伟"));
         System.out.println(map.get("岑森"));
         System.out.println(map.get("文臣"));
      }
}