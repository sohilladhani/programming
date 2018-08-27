/* Inspired by: https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/ */

package com.sohilladhani.hashtableimpl;

import java.util.ArrayList;

import com.sohilladhani.hashtableimpl.HashNode;

class HashTable <K, V> {
	private int size; // no. of keys inserted
	private int capacity; // no. of buckets
	private double LOAD_FACTOR_THRESHOLD = 0.7;

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
		return ((hash & 0x7fffffff ) % this.capacity); 
		/* Hash function. Calculates hashCode % the total buckets  */
		/* For why I used "hash & 0x7fffffff", look at https://stackoverflow.com/questions/9249983/hashcode-giving-negative-values*/
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

		HashNode<K,V> newNode = new HashNode<K,V>(key,value);
		newNode.next = head;	
		this.buckets.set(bucketIndex, newNode);

		if((1.0 * this.size) / this.capacity >=	LOAD_FACTOR_THRESHOLD) {
			ArrayList<HashNode<K,V>> bucketsTemp = buckets;
			this.capacity = this.capacity * 2;
			this.size = 0;
			buckets = new ArrayList<HashNode<K,V>>();

			for(int i=0; i<this.capacity; i++) {
				buckets.add(null);
			}

			for(HashNode<K,V> node : bucketsTemp) {
				while(node != null) {
					add(node.key, node.value);
					node = node.next;
				}	
			}
		}
	}

	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K,V> head = this.buckets.get(bucketIndex);
		HashNode<K,V> prev = null;
		HashNode<K,V> curr = head;

		while(curr != null) {
			if(curr.key.equals(key)) {
				if(prev == null) {
					//remove head node
					head = curr.next;
					this.buckets.set(bucketIndex, head);
				} else {
					prev.next = curr.next;
				}
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		
		this.size--;
		
		return curr.value;
	}
}

