
import java.util.Scanner;


/*
 * 基于单链表LRU算法（java）
 *
 * @author Toby Huang
 * @create 2019-03-13
*/




public class LRUSingleLinkList<T> {

    /* default cache capacity */
    private final static int DEFAULT_CAPACITY = 10;

    private int         capacity;
    private int         length;  // the length of link
    private SNode<T>    head;   // link head node

   public LRUSingleLinkList () {
       this.head = new SNode<>();
       this.capacity = DEFAULT_CAPACITY;
       this.length = 0;
   }

   public LRUSingleLinkList(int capacity) {
       this.head = new SNode<>();
       this.capacity = capacity;
       this.length = 0;
   }

    public int getCapacity() {
        return capacity;
    }

    public void add (T data) {
       SNode preNode = findPreNode(data);

       if (preNode != null) {
            deleteNextNode(preNode);
            insertDataAtBegin(data);

       } else {
           if (this.length >= this.capacity) {
               deleteTailNode();
           }
           insertDataAtBegin(data);
       }

    }

    private void deleteNextNode(SNode node) {
        SNode next = node.getNext();
        node.setNext(next.getNext());
        next = null;
        this.length--;
    }

    private void insertDataAtBegin(T data) {
        SNode next = this.head.getNext();
        SNode newNode = new SNode(data);
        newNode.setNext(next);
        this.head.setNext(newNode);
        this.length++;
    }

    private void deleteTailNode() {
       SNode node = head;

       if (node.getNext() == null)
           return;

       // find the last second node
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }

        SNode temp = node.getNext();
        node.setNext(null);
        temp = null;
        this.length--;

    }

    private SNode findPreNode(T data) {
        SNode node = head;

        while (node.getNext() != null) {
            if (data.equals(node.getNext().getData())) {
                return node;
            }
            node = node.getNext();
        }

       return null;
    }



    public void printAll() {
       SNode node = this.head;
       while(node.getNext() != null) {
           System.out.print(node.getNext().getData() + ", ");
           node = node.getNext();
       }
       System.out.println();
    }

    public static void main(String[] args) {
        LRUSingleLinkList list = new LRUSingleLinkList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}



