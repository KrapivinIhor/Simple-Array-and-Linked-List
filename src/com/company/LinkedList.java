package com.company;

public class LinkedList<T> implements List<T> {

    private int size = 0;
    private Node<T> FirstNode;
    private Node<T> lastNode;

    @Override
    public T get(int i) {
        checkIndexException(i);
        return getNode(i).t;
    }


    private Node<T> getNode(int i) {
        Node<T> element = FirstNode;
        for (int j = 0; j < i; j++) {
            element = element.nextNode;
        }
        return element;
    }

    private void checkIndexException(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index is: " + i + ", but Size is: " + size);
        }
    }

    @Override
    public boolean add(T t) {
        Node<T> currentNode;
        if (isEmpty()){
            currentNode = new Node<>(null, t, null);
            FirstNode = currentNode;
            lastNode = currentNode;
        } else {
            currentNode = new Node<>(lastNode, t, null);
            lastNode.nextNode = currentNode;
            lastNode = currentNode;
        }
        size++;
        return true;
    }

    private boolean isEmpty() { return size == 0; }

    @Override
    public T remove(int i) {
        checkIndexException(i);
        return deleteConnections(getNode(i));
    }

    private T deleteConnections(Node<T> node) {
        final T elementValue = node.t;
        final Node<T> nextNode = node.nextNode;
        final Node<T> previousNode = node.previousNode;

        if (previousNode == null) {
            FirstNode = nextNode;
        } else {
            previousNode.nextNode = nextNode;
            node.previousNode = null;
        }

        if (nextNode == null) {
            lastNode = previousNode;
        } else {
            nextNode.previousNode = previousNode;
            node.nextNode = null;
        }

        node.t = null;
        size--;
        return elementValue;
    }

    @Override
    public int size() { return size; }

    private static class Node<T> {
        T t;
        Node<T> nextNode;
        Node<T> previousNode;

        Node(Node<T> previousNode, T element, Node<T> nextNode) {
            this.t = element;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }
    }
}
