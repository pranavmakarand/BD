package com.bytedance;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {

	private HashMap<Integer, Node> map;
	private int maxCap;
	private DoublyLinkedList list;

	class DoublyLinkedList {

		Node head;
		Node tail;

		public DoublyLinkedList() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
			head.prev = null;
			tail.next = null;
		}

		private void insertAtHead(Node node) {
			Node temp = head;
			if (head.next == this.tail) {
				temp.next = node;
				node.next = tail;
				tail.prev = node;
				node.prev = temp;
			} else {
				Node temp2 = head;
				Node temp3 = head.next;
				temp2.next = node;
				node.prev = temp2;
				node.next = temp3;
				temp3.prev = node;
			}
		}

		private Node deleteNode() {
			Node temp = tail;
			if (tail.prev != head) {
				temp = tail.prev;
				temp.prev.next = tail;
				tail.prev = temp.prev;
				return temp;
			}
			return null;
		}

		private void deleteRequestedNode(Node node) {
			Node temp = head;
			if (head.next != tail) {
				temp = head.next;
				while (temp != node && temp != tail) {
					temp = temp.next;
				}
				if (temp != tail) {
					Node prev = temp.prev;
					prev.next = temp.next;
					temp.next.prev = prev;
					temp = null;
				}
			}
		}

		private void printList() {
			Node temp = head;
			temp = temp.next;
			while (temp != null && temp != tail) {
				temp = temp.next;
			}
		}
	}

	class Node {
		private Map.Entry<Integer, Integer> keyValue;
		private Node next;
		private Node prev;

		public Node() {
			this.keyValue = null;
			this.next = null;
			this.prev = null;
		}

		public Node(Map.Entry<Integer, Integer> entry) {
			this.keyValue = entry;
			this.next = null;
			this.prev = null;
		}

		public int getV() {
			return this.keyValue.getValue();
		}

		public int getK() {
			return this.keyValue.getKey();
		}
	}

	public LRU_Cache(int capacity) {
		this.map = new HashMap<Integer, Node>();
		this.list = new DoublyLinkedList();
		this.maxCap = capacity;
	}

	public int get(int key) {
		Node ans = map.getOrDefault(key, null);
		if (ans == null) {
			return -1;
		}
		list.deleteRequestedNode(ans);
		list.insertAtHead(ans);
		return ans.getV();
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			// we need to delete the node from the dll
			// we need to add the node to the head of the dll
			// we need to update the map
			Node nodeToDelete = map.getOrDefault(key, null);
			list.deleteRequestedNode(nodeToDelete);
		} else {
			if (maxCap <= map.size()) {
				// System.out.print(list.tail.prev.getK());
				Node nodeToDelete = list.deleteNode();
				map.remove(nodeToDelete.getK());
				nodeToDelete = null;
			}
		}
		Node node = new Node(new AbstractMap.SimpleEntry<Integer, Integer>(key, value));
		map.put(key, node);
		list.insertAtHead(node);
	}

	public static void main(String args[]) {

		LRU_Cache obj = new LRU_Cache(2);
		obj.put(1, 1);
	}
}
