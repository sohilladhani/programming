/* Inspired by: https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/ */

package com.sohilladhani.hashtableimpl;

import java.util.ArrayList;

import com.sohilladhani.hashtableimpl.HashNode;

class HashTable <K, V> {
	private int size;
	private int capacity;

	private ArrayList<HashNode<K,V>> buckets;

	public HashTable() {
		this.buckets = new ArrayList<>();
		this.size = 0;
		this.capacity = 16;

		/* Create empty buckets */

		for(int i=0; i<capacity; i++) {
			this.buckets.add(null);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int getBucketIndex(K key) {
		int hash = key.hashCode();
		return (hash % this.capacity); /* Hash function. Calculates hashCode % the total buckets  */
	}

	public V get(K key) {
		//get (or search) the key. if not found return null

		// get the bucket index
		int bucketIndex = getBucketIndex(key);

		// iterate over the linked list of the nodes
		HashNode<K,V> node = this.buckets.get(bucketIndex);
		while(node != null) {
			if(node.key.equals(key)) return node.value;
			else node = node.next;			
		}

		return null;	
	}

	public void add(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K,V> head = this.buckets.get(bucketIndex);
		
		// check if key already exists. if so, replace the value. else add to the chain	
		// if the bucket is null, add the first entry
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		this.size++;
		head = this.buckets.get(bucketIndex);

		HashNode<K,V> node = this.buckets.get(bucketIndex);
		while(node.next!=null) {
			node = node.next;	
		}
		node.next = head;	
	}


}

