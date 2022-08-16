package Unit10;

public class Node<T> {
    T value;

    Node<T> next;

    Node(T v) {
        value = v;
    }

    Node(T v, Node<T> n) {
        value = v;
        next = n;
    }

    T getter() {
        return value;
    }
}
