package org.lld;

public class Snake {
    private Integer head;
    private Integer tail;
    public Snake(int head, int tail){
        this.head = Integer.valueOf(head);
        this.tail = Integer.valueOf(tail);
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getTail() {
        return tail;
    }

    public void setTail(Integer tail) {
        this.tail = tail;
    }
}
