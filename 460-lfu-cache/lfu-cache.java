class LFUCache {

    class Node{
        int key,val,cnt;
        Node prev,next;
        Node(int key,int value){
            this.key=key;
            val=value;
            cnt=1;
            prev=null;
            next=null;
        }
    }
    class Dll{
        Node head;
        Node tail;
        Dll(){
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
        }
    }

    HashMap<Integer,Node> dll=new HashMap<>();
    HashMap<Integer,Dll> pointer=new HashMap<>();
    HashMap<Integer,Node> map=new HashMap<>();
    int size;
    int minfreq;

    public LFUCache(int capacity) {
        size=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node temp=map.get(key);
        helper(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(size==map.size()&& !map.containsKey(key)){
            Node temp=pointer.get(minfreq).tail.prev;
            map.remove(temp.key);
            delete(temp);
            put(key,value);
            return ;
        }
        if(map.containsKey(key)){
            Node temp=map.get(key);
            temp.val=value;
            helper(temp);
            return;
        }
        Node root=new Node(key,value);
        map.put(key,root);
        if(!pointer.containsKey(1)){
            createpointer(1);
        }
        minfreq=1;
        add(root,pointer.get(1).head);

    }
    void createpointer(int key){
        Dll dummy=new Dll();
        pointer.put(key,dummy);
    }
    void helper(Node root){
        int cnt=root.cnt;
        delete(root);
        root.cnt=cnt+1;
        if(pointer.get(cnt).head.next==pointer.get(cnt).tail){
            if(cnt==minfreq)minfreq++;
        }
        if(!pointer.containsKey(root.cnt))createpointer(root.cnt);
        add(root,pointer.get(root.cnt).head);
    }
    void delete(Node root){
        root.prev.next=root.next;
        root.next.prev=root.prev;
    }
    void add(Node root,Node head){
        Node temp=head.next;
        temp.prev=root;
        root.next=temp;
        head.next=root;
        root.prev=head;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */