package com.sohilladhani.hashtableimpl;

import com.sohilladhani.hashtableimpl.HashTable;

class HashTableTest {

	public static void main(String args[]) {
		HashTable<String, Integer> hashTable = new HashTable<>();
		System.out.println(hashTable.isEmpty());
		hashTable.add("I am", 26);
		hashTable.add("the best", 28);
		hashTable.add("coder", 30);
		hashTable.add("in the world", 32);
		hashTable.add("you shall", 34);
		hashTable.add("see", 36);
		hashTable.add("see", 88);

		System.out.println(hashTable.get("I am"));
		System.out.println(hashTable.get("the best"));
		System.out.println(hashTable.get("coder"));
		System.out.println(hashTable.get("in the world"));
		System.out.println(hashTable.get("you shall"));
		System.out.println(hashTable.get("see"));

		System.out.println("remove I am: " + hashTable.remove("I am"));
		System.out.println("remove in the world: " + hashTable.remove("in the world"));
		System.out.println("remove coder: " + hashTable.remove("coder"));
		System.out.println("remove the best: " + hashTable.remove("the best"));
		System.out.println(hashTable.get("I am"));
		System.out.println(hashTable.get("the best"));
		System.out.println(hashTable.get("coder"));
		System.out.println(hashTable.get("code"));
		System.out.println(hashTable.get("in the world"));
		System.out.println(hashTable.get("you shall"));
		System.out.println(hashTable.get("see"));

		System.out.println(hashTable.size());
	}

}


