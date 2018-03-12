package datastructure;

public class LinkedStack {

	public static void main(String[] args) {
		LinkedStackG<String> lss = new LinkedStackG();
		for (String s : "Phasers on stum!".split(" ")) {
			lss.push(s);
		}

		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}

	}

}

class LinkedStackG<T> {

	private static class Node<U> {
		U item;
		Node<U> next;

		Node() {
			item = null;
			next = null;
		}

		Node(U item, Node<U> node) {
			this.item = item;
			this.next = node;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<T>();// End sentinel

	public void push(T item) {
		top = new Node<T>(item, top);
	}

	public T pop() {
		if (!top.end()) {
			T item = top.item;
			top = top.next;
			return item;
		}

		return null;
	}

}
