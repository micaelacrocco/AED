package ut3;

import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top;

    public void push(T value) {
        Node<T> newTop = new Node<>(value);
        newTop.next = top;
        top = newTop;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T topValue = top.value;
        top = top.next;
        return topValue;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}
