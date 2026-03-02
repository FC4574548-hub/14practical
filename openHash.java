public class openHash {

    private String[] keys;
    private String[] values;
    private boolean[] deleted;
    private int m;
    private int size;
    public openHash(int size){
        m = size;
        keys = new String[m+1];
        values = new String[m +1];
    }

    private int hash(String key){
        int x = Integer.parseInt(key);
        return (x % m);
    }

    public void insert(String key, String value){
        int i = hash(key);

        while(keys[i] != null){
            if(keys[i].equals(key)){
                values[i] = value;
                return;
            }
            i = (i + 1) % m;
            if(i == 0) i = 1;
        }
        keys[i] = key;
        values[i] = value;
    }
    public String lookup(String key){
        int i = hash(key);

        while (keys[i] != null){
            if (keys[i].equals(key))
                return values[i];

            i = (i + 1) % m;
            if(i == 0) i = 1;

        }
        return null;
    }
    
    public String remove(String key){
        int i = hash(key);
        
        while(keys[i] != null){
            if(deleted[i] || keys[i].equals(key)){
                deleted[i] =true;
                size--;
                return values[i];
            }
            i = (i + 1) % m;
            if(i == 0) i = 1;
            
        }
        return null;
    }
    public boolean isInTable(String key){
        return lookup(key) != null;
    }
    public boolean isFull(){
        return size == m;
        
    }
    public boolean isEmpty(){
        return size == 0;
    }
}

