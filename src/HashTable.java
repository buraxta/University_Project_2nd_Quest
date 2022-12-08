
import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] entries = new LinkedList[10];
    public void put(String key, String value){
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];
        for (var entry : bucket){
            if (entry.key == key){
                entry.value = value;
                return;
            }
        }

        bucket.addLast(new Entry(key, value));
    }

    public String get(String key){
        var index = hash(key);
        var bucket = entries[index];
        if (bucket != null){
            for (var entry : bucket){
                if (key.equals(entry.key))
                    return entry.value;
            }
        }
        return null;
    }

    private int hash(String key){
        int hash = 0;
        for (var ch : key.toCharArray()){
            hash += ch;
        }
        return hash % entries.length;
    }
}
