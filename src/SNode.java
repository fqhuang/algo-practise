/*
 * 单链表 node（java）
 *
 * @author Toby Huang
 * @create 2019-03-13
 */

public class SNode <T> {
    private T data;
    private SNode next;

    public SNode () {
        this.next = null;
    }

    public SNode(T data) {
        this.data = data;
        this.next = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(SNode next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public SNode getNext() {
        return this.next;
    }
}