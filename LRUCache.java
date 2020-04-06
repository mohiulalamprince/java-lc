import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        int val;
        int key;
        Node next;
        Node pre;
    }
    static int capacity = 0;
    static Node head;
    static Node tail;
    static Map<Integer, Node> map;

    public static void main(String args[]) {
        int ret = 0;
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        ret = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        ret = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        ret = cache.get(1);       // returns -1 (not found)
        ret = cache.get(3);       // returns 3
        ret = cache.get(4);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public static int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        remove(node);
        add(node);
        return node.val;
    }

    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key);
            map.get(key).val = value;
        } else {
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            add(node);
            map.put(key, node);
        }
    }

    public static void remove(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public static void add(Node node) {
        Node old = head.next;
        node.next = old;
        node.pre = head;
        old.pre = node;
        head.next = node;
    }
}
