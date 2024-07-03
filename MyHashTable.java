/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 *
 * @author Hongbiao Zeng
 * @version Nov 27, 2015
 */

import java.util.ArrayList;

public class MyHashTable<K extends Comparable<K>, V> {
    private ArrayList<ArrayList<MyHashEntry<K, V>>> table;
    private int count; // how many elements in table

    /**
     * Constructor. Construct an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize) {
        table = new ArrayList<>(tableSize);

        // Initialize each bucket as an empty ArrayList
        for (int i = 0; i < tableSize; i++) {
            table.add(new ArrayList<>());
        }

        count = 0;
    }

    /**
     * Constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable() {
        this(10);
    }

    /**
     * Get the number of elements in the table
     *
     * @return The number of elements in the table
     */
    public int size() {
        return count;
    }

    /**
     * Clear the table
     */
    public void clear() {
        // Clear each bucket's list
        for (ArrayList<MyHashEntry<K, V>> chain : table) {
            chain.clear();
        }
        count = 0;
    }

    /**
     * Get the value with given key
     *
     * @param key The given key
     * @return The value that has the key matching the given key. If no such value, return null
     */
    public V get(K key) {
        int index = hash(key);
        ArrayList<MyHashEntry<K, V>> chain = table.get(index);

        // Find the entry with the given key
        for (MyHashEntry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Insert (key, value) pair into the table
     *
     * @param key   The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value) {
        int index = hash(key);
        ArrayList<MyHashEntry<K, V>> chain = table.get(index);

        // Check if the key already exists
        for (MyHashEntry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                // Update the value if key already exists
                entry.setValue(value);
                return;
            }
        }

        // If the key doesn't exist, add a new entry to the chain
        MyHashEntry<K, V> newEntry = new MyHashEntry<>(key, value);
        chain.add(newEntry);
        count++;
    }

    /**
     * Remove the value with given key from the table
     *
     * @param key The given key
     * @return The value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key) {
        int index = hash(key);
        ArrayList<MyHashEntry<K, V>> chain = table.get(index);

        // Find the entry with the given key
        for (MyHashEntry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                // Remove the entry if key matches
                chain.remove(entry);
                count--;
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Check if the table is empty, i.e., no entry
     *
     * @return True if the table holds no elements; false otherwise
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Return a String representation of the table
     *
     * @return A String representation of the table
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Search each bucket in table
        for (int i = 0; i < table.size(); i++) {
            ArrayList<MyHashEntry<K, V>> chain = table.get(i);
            sb.append("Bucket ").append(i).append(": ");

            // Append each entry to string
            for (MyHashEntry<K, V> entry : chain) {
                sb.append("(").append(entry.getKey()).append(", ").append(entry.getValue()).append(") ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Computes the hash value for the specified key
     *
     * @param key The key to hash
     * @return The hash value
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.size();
    }
}
