import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

/**
 * This class implements a hash map using a hash table.
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {
    HashTable<K, V> ht;

    /**
     * Constructs an empty hash map.
     */
    public MyHashMap() {
        ht = new HashTable<K, V>();
    }

    /**
     * Removes all of the mappings from this map.
     */
    public void clear() {
        ht.clear();
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key
     * @return
     */
    public boolean containsKey(K key) {
        return ht.containsKey(key);
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     *
     * @param value
     * @return
     */
    public boolean containsValue(V value) {
        return ht.containsValue(value);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key
     * @return
     */
    public V get(K key) {
        return ht.get(key);
    }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return ht.isEmpty();
    }

    /**
     * Returns a set view of the keys contained in this map.
     *
     * @return set of keys
     */
    public Set<K> keySet() {
        return ht.keySet();
    }

    /**
     * Associates the specified value with the specified key in this map.
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        return ht.put(key, value);
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key
     * @return value
     */
    public V remove(K key) {
        return ht.remove(key);
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return int
     */
    public int size() {
        return ht.size();
    }

    /**
     * Prints the hash table.
     */
    public void printTable() {
        ht.printTable();
    }
}


/**
 * This class implements a hash table.
 *
 * @param <K>
 * @param <V>
 */
class HashTable<K, V> {
    private final static int TABLE_SIZE = 8;
    private ArrayList<LinkedList<Node<K, V>>> hashTable = new ArrayList<>(TABLE_SIZE);

    /**
     * This class implements a node.
     *
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> {
        K key;
        V value;

        /**
         * Constructs a node.
         *
         * @param key
         * @param value
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Constructs an empty hash table.
     */
    public HashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable.add(new LinkedList<Node<K, V>>());
        }
    }

    /**
     * Removes all of the mappings from this map.
     */
    public void clear() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable.get(i).clear();
        }
    }

    /**
     * Checks if the specified key is in the hash table.
     *
     * @param key
     * @return boolean
     */
    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = hashTable.get(index);
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the specified value is in the hash table.
     *
     * @param value
     * @return boolean
     */
    public boolean containsValue(V value) {
        for (int i = 0; i < TABLE_SIZE; i++) {
            LinkedList<Node<K, V>> list = hashTable.get(i);
            for (Node<K, V> node : list) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key
     * @return value
     */
    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = hashTable.get(index);
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    /**
     * Checks if the hash table is empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (!hashTable.get(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }


    /**
     * Returns a set view of the keys contained in this map.
     *
     * @return set of keys
     */
    public Set<K> keySet() {
        Set<K> keySet = new java.util.HashSet<>();
        for (int i = 0; i < TABLE_SIZE; i++) {
            LinkedList<Node<K, V>> list = hashTable.get(i);
            for (Node<K, V> node : list) {
                keySet.add(node.key);
            }
        }
        return keySet;
    }

    /**
     * Returns the hash code for the specified key.
     *
     * @param key
     * @return hash code
     */
    public V put(K key, V value) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = hashTable.get(index);
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        list.addFirst(new Node<K, V>(key, value));
        return null;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key
     * @return value
     */
    public V remove(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> list = hashTable.get(index);
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                list.remove(node);
                return oldValue;
            }
        }
        return null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return int
     */
    public int size() {
        int size = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            size += hashTable.get(i).size();
        }
        return size;
    }

    /**
     * Prints the hash table.
     */
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

    /**
     * Returns the index of the specified key.
     * @param key
     * @return index
     */
    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % TABLE_SIZE;
        return Math.abs(index);
    }
}