// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
// The cache is initialized with a positive capacity.
//
// Follow up:
// Could you do both operations in O(1) time complexity?
//
// Example:
//
//
// LRUCache cache = new LRUCache( 2 /* capacity */ );
//
// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4
//
//
//  
//


class LRUCache {
    private class Node {
        int key, val;
        Node  prev, next;
        Node (int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node head = new Node(-1,-1,null,null);
    
    private Map<Integer, Node> map = new HashMap<>();
    
    private void move2head(Node cur) {
        if (cur == head) {
            head = head.prev;
            return;
        }
        // detach;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        // attach;
        cur.next = head.next;
        cur.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }
    
    public LRUCache(int capacity) {
        Node cur = head;
        for (int i = 0; i< capacity-1; ++i) {
            cur.next = new Node(-1,-1,cur,null);
            cur = cur.next;
        }
        cur.next = head;
        head.prev = cur;

    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        move2head(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            move2head(cur);
        } else {
            if (head.val != -1)  map.remove(head.key);
            head.key = key;
            head.val = value;
            map.put(key, head);
            head = head.prev;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
