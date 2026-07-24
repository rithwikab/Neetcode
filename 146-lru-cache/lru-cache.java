class LRUCache {
    class ListNode{
        ListNode prev;
        ListNode next;
        int key;
        int val;

        public ListNode(){}

        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    Map<Integer, ListNode> m ;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!m.containsKey(key))return -1;
        ListNode cur = m.get(key);
        remove(cur);
        insert(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            ListNode cur = m.get(key);
            cur.val = value;
            remove(cur);
            insert(cur);
            return;
        }
        if(m.size() == capacity){
            m.remove(head.next.key);
            remove(head.next);
        }
        ListNode cur = new ListNode(key,value);
        insert(cur);
        m.put(key,cur);
    }

    public void remove(ListNode cur){
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
    }

    public void insert(ListNode cur){
        cur.prev = tail.prev;
        cur.next = tail;
        tail.prev.next = cur;
        tail.prev = cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */