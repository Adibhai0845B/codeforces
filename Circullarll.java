import java.util.*;
public class Circullarll {
    public Node tail;
    public Node head;
    public Circullarll(){
        this.head = null;
        this.tail = null;
    }
    public class Node{
        Node next;
        Node prev;
        int value;
        public Node(int val){
            this.value = val;
        }
    }
    public void insert(int val){
    Node node = new Node(val);
    if(head==null){
        head = node;
        tail = node;
        return;
    }
    tail.next = node;
    node.next = head;
    tail = node;
    }
    public void print(){
        Node temp = head;
           System.out.println(temp.value);
           temp = temp.next;
           while(temp!=head){
            System.out.println(temp.value);
            temp = temp.next;
           }
    }
}
