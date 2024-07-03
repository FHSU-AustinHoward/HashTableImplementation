/**
 * class MyHashEntry. A Hash Entry as a single linked list Node
 *
 * @author Austin Howard
 * @version Jul 3, 2024
 */

public class MyHashEntry<K extends Comparable<K>, V> {
    private K key;
    private V value;
    MyHashEntry<K, V> next;

    /**
     * Constructor
     * @param key The key of MyHashEntry
     * @param value The value of MyHashEntry
     */
    public MyHashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    /**
     * Get the key
     * @return The key of the ordered pair
     */
    public K getKey() {
        return key;
    }

    /**
     * Set the key for this ordered pair
     * @param key The key for this ordered pair
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Get the value of this ordered pair
     * @return The value of this ordered pair
     */
    public V getValue() {
        return value;
    }

    /**
     * Set the value of this ordered pair
     * @param value The new value of this ordered pair
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Set the next entry for this entry
     * @param next A reference to the next entry
     */
    public void setNext(MyHashEntry<K, V> next) {
        this.next = next;
    }

    /**
     * Get the next entry
     * @return A reference to the next entry
     */
    public MyHashEntry<K, V> getNext() {
        return next;
    }
}
