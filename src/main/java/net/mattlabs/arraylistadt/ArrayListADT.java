package net.mattlabs.arraylistadt;

public class ArrayListADT<E> {

    // Nested node class
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {return element;}
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public ArrayListADT() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // Returns the number of elements in the list
    public int size() {return size;}

    // Tests whether the list is empty
    public boolean isEmpty() {return size == 0;}

    // Returns (but does not remove) the first element of the list
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    // Returns (but does not remove) the last element of the list
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    // Adds element e to the front of the list
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    // Adds element e to the end of the list
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    // Removes and returns the first element of the list
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    // Removes and returns the last element of the list
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    // Adds element e to the list in between the given nodes
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    // Removes the given node from the list and returns its element
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}
