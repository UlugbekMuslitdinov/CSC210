import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K, V> {
    HashTable<K, V> ht;

    public MyHashMap() {
        ht = new HashTable<K, V>();
    }

    public void clear() {
        ht.clear();
    }

    public boolean containsKey(K key) {
        return ht.containsKey(key);
    }

    public boolean containsValue(V value) {
        return ht.containsValue(value);
    }

    public V get(K key) {
        return ht.get(key);
    }

    public boolean isEmpty() {
        return ht.isEmpty();
    }

    public Set<K> keySet() {
        return ht.keySet();
    }

    public V put(K key, V value) {
        return ht.put(key, value);
    }

    public V remove(K key) {
        return ht.remove(key);
    }

    public int size() {
        return ht.size();
    }

    public void printTable() {
        ht.printTable();
    }

    public static void main(String[] args) {
    }
}

class HashTable<K, V> {
    private final static int TABLE_SIZE = 8;
    private ArrayList<LinkedList<Node<K,V>>> hashTable = new ArrayList<>(TABLE_SIZE);

    private class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable.add(new LinkedList<Node<K,V>>());
        }
    }

    public void clear() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable.get(i).clear();
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Node<K,V>> list = hashTable.get(index);
        for (Node<K,V> node : list) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < TABLE_SIZE; i++) {
            LinkedList<Node<K,V>> list = hashTable.get(i);
            for (Node<K,V> node : list) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K,V>> list = hashTable.get(index);
        for (Node<K,V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (!hashTable.get(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Set<K> keySet() {
        Set<K> keySet = new java.util.HashSet<>();
        for (int i = 0; i < TABLE_SIZE; i++) {
            LinkedList<Node<K,V>> list = hashTable.get(i);
            for (Node<K,V> node : list) {
                keySet.add(node.key);
            }
        }
        return keySet;
    }

    public V put(K key, V value) {
        int index = hash(key);
        LinkedList<Node<K,V>> list = hashTable.get(index);
        for (Node<K,V> node : list) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        list.addFirst(new Node<K,V>(key, value));
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        LinkedList<Node<K,V>> list = hashTable.get(index);
        for (Node<K,V> node : list) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                list.remove(node);
                return oldValue;
            }
        }
        return null;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            size += hashTable.get(i).size();
        }
        return size;
    }

    public void printTable() {
        int totalConflicts = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            int conflicts = hashTable.get(i).size();
            if (conflicts > 0) {
                conflicts--;
            }
            totalConflicts += conflicts;
            System.out.print("Index " + i + ": (" + conflicts + " conflicts), [");
            for (Node<K, V> node : hashTable.get(i)) {
                System.out.print(node.key + ", ");
            }
            System.out.println("]");
        }
        System.out.println("Total # of conflicts: " + totalConflicts);
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % TABLE_SIZE;
        return Math.abs(index);
    }
}