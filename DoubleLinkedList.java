public class DoubleLinkedList {
    Node head;
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        node.prev = null;
    }
    private class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    public Node find(int val){
        Node node = head;
        while(node!=null){
            if(node.value ==val){
            return node;
            }
            node = node.next;
        }
        return null;
    }
    public void insert(int val,int after){
        Node node = find(after);
        if(node==null){
           System.out.println("Does Not Exist");
           return;
        }
        Node p =new Node(val); 
        node.next = p.next;
        p.next = node;
        if(node.next!=null){
            node.next.prev =node;
        }
    }
    public void insertLast(int val){
      Node node = new Node(val);
      Node last = head;
      node.next = null;
      if(head==null){
        node.prev = null;
        head = node;
        return ;
      }
      while(last.next!=null){
        last = last.next;
      }
      last.next = node;
      node.prev = last;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertFirst(10);
        dll.insertFirst(20);
        dll.insertFirst(30);

        dll.printList();
    }
}
