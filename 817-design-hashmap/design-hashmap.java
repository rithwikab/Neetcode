class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 769;   // Prime number
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = buckets[index];

        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }

            if (curr.next == null)
                break;

            curr = curr.next;
        }

        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);

        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key)
                return curr.value;

            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);

        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */