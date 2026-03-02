class Node {
    String key;
    String value;
    Node next;
    
    public Node (String k, String v) {
        key = k;
        value = v;
    }
}

public class chainedHash {

    private Node[] table;
    private int m;
    
    public chainedHash(int size) {
        
        m = size;
        table = new Node[m + 1];
    }
    private int hash(String key) {
        int x = Integer.parseInt(key);
        return (x % m) + 1;
    }
    public void insert(String key, String value) {
        int i = hash(key);
        Node head = table[i];
        Node current = head;
        
        while(current != null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current= current.next;
        }
        Node newN = new Node(key, value);
        newN.next = head;
        table[i] = newN;
        
        while(current!= null){
            if(current.key.equals(key))
                return current.value;
            current = current.next;
        }
        return null;
    }
}

