/* 705. Design HashSet - https://leetcode.com/problems/design-hashset */
/* Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the
HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

    All values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashSet library.

*/

class MyHashSet {
    private int size;
    private int capacity;
    private double loadFactor;
    private int[] buckets;

    /* Initialize your data structure here. */
    public MyHashSet() {
        this.size = 0;
        this.capacity = 4;
        this.loadFactor = 0.75;
        this.buckets = new int[capacity];
        for(int i = 0; i < this.capacity; i++) {
            this.buckets[i] = -1;
        }
    }
    
    public void add(int key) {
        /* If size*loadFactor >= capacity -> double capacity and rehash
         * elements */   
        System.out.println("Add: " + key);
        this.size = this.size + 1;
        System.out.println("Size: " + size);

        if(this.capacity * this.loadFactor < this.size) {
            this.capacity = this.capacity * 2;
            rehashBuckets(this.buckets, this.capacity);
        }
        System.out.printf("Capacity: %d\n", this.capacity);

        /* Calculate hash value of 'key'
         * if key already exists, do nothing
         * else put into respective bucket 
         *
         * Use Linear Probing for collisions */
        if(this.contains(key) == false) {
            int index = calculateHash(key);
            if(this.buckets[index] == -1) {
                this.buckets[index] = key;
            } else {
                int new_index = calculateHash(index + 1);
                while(this.buckets[new_index] != -1) {
                    new_index = calculateHash(++new_index);
                }
                this.buckets[new_index] = key;
            }
        }
    }
    
    public void remove(int key) {
        /* Calculate hash value of 'key'
         * If not present in the set, do nothing
         * else remove from the respective bucket */
        System.out.println("Remove: " + key);

        if(this.contains(key) == true) {
            /* The range of key is [0, 1000000]. So using as unused value */
            this.buckets[this.calculateHash(key)] = -1;
            this.size = this.size - 1;
        }

        /* If size*loadFactor < capacity/4 -> decrease capacity by half and
         * rearrange
         * */
        if(capacity * loadFactor < this.size / 4) {
            this.capacity = this.capacity / 2;
            rehashBuckets(this.buckets, this.capacity);
        } 
    }
    
    /* Returns true if this set contains the specified element */
    public boolean contains(int key) {
        /* Calculate hash value of 'key' 
         * return true if it's in the bucket */
        int index = this.calculateHash(key);
        if(this.buckets[index] == key) {
            return true;
        } else {
            int new_index = calculateHash(index + 1);
            while(this.buckets[new_index] != key && new_index != index) {
                new_index = calculateHash(++new_index);
            }
            if(this.buckets[new_index] == key) {
                return true;
            }
        }

        return false;
    }

    private int calculateHash(int key) {
        return key % this.capacity;
    }

    private void rehashBuckets(int[] buckets, int capacity) {
        int[] tempBuckets = new int[capacity];
        for(int i = 0; i < tempBuckets.length; i++) {
            tempBuckets[i] = -1;
        }
        for(int i = 0; i < this.buckets.length; i++) {
            if(buckets[i] != -1) {
                tempBuckets[calculateHash(this.buckets[i])] = this.buckets[i];
            }
        }
        this.buckets = tempBuckets;
        System.out.println("New Hashset:");
        printHashSet();
    }

    private void printHashSet() {
        for(int i = 0; i < this.capacity; i++) {
            System.out.print(this.buckets[i] + " ");
        }
        System.out.println();
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        /*hashSet.add(1);
        hashSet.printHashSet();
        hashSet.add(2);         
        hashSet.printHashSet();
        System.out.println("Contains 1: " + hashSet.contains(1));    // returns true
        hashSet.printHashSet();
        System.out.println("Contains 3: " + hashSet.contains(3));    // returns false (not found)
        hashSet.printHashSet();
        hashSet.add(42);          
        hashSet.printHashSet();
        System.out.println("Contains 2: " + hashSet.contains(2));    // returns true
        hashSet.printHashSet();
        hashSet.remove(2);          
        hashSet.printHashSet();
        System.out.println("Contains 2: " + hashSet.contains(2));    // returns false (already removed)
        hashSet.printHashSet();
        hashSet.remove(1);          
        hashSet.printHashSet();
        System.out.println("Contains 1: " + hashSet.contains(1));    // returns false (already removed)
        hashSet.remove(42);          
        hashSet.printHashSet();
        System.out.println("Contains 42: " + hashSet.contains(42));    // returns false (already removed)
       
        hashSet.add(9);
        hashSet.printHashSet();
        hashSet.remove(19);
        hashSet.printHashSet();
        hashSet.add(14);
        hashSet.printHashSet();
        hashSet.remove(19);
        hashSet.printHashSet();
        hashSet.remove(9);
        hashSet.printHashSet();
        hashSet.add(0);
        hashSet.printHashSet();
        hashSet.add(3);
        hashSet.printHashSet();
        hashSet.add(4);
        hashSet.printHashSet();
        hashSet.add(0);
        hashSet.printHashSet();
        hashSet.remove(9);
        hashSet.printHashSet();*/

/*
 * ["MyHashSet","contains","remove","add","add","contains","remove","contains","contains","add","add","add","add","remove","add","add","add","add","add","add","add","add","add","add","contains","add","contains","add","add","contains","add","add","remove","add","add","add","add","add","contains","add","add","add","remove","contains","add","contains","add","add","add","add","add","contains","remove","remove","add","remove","contains","add","remove","add","add","add","add","contains","contains","add","remove","remove","remove","remove","add","add","contains","add","add","remove","add","add","add","add","add","add","add","add","remove","add","remove","remove","add","remove","add","remove","add","add","add","remove","remove","remove","add","contains","add"]
[[],[72],[91],[48],[41],[96],[87],[48],[49],[84],[82],[24],[7],[56],[87],[81],[55],[19],[40],[68],[23],[80],[53],[76],[93],[95],[95],[67],[31],[80],[62],[73],[97],[33],[28],[62],[81],[57],[40],[11],[89],[28],[97],[86],[20],[5],[77],[52],[57],[88],[20],[48],[42],[86],[49],[62],[53],[43],[98],[32],[15],[42],[50],[19],[32],[67],[84],[60],[8],[85],[43],[59],[65],[40],[81],[55],[56],[54],[59],[78],[53],[0],[24],[7],[53],[33],[69],[86],[7],[1],[16],[58],[61],[34],[53],[84],[21],[58],[25],[45],[3]]
 */
/*        String[] ops = {"contains", "remove", "add", "add", "contains", "remove", "contains",
            "contains", "add", "add", "add", "add", "remove", "add", "add",
            "add", "add", "add", "add", "add", "add", "add", "add", "contains",
            "add", "contains", "add", "add", "contains", "add", "add", "remove",
            "add", "add", "add", "add", "add", "contains", "add", "add", "add",
            "remove", "contains", "add", "contains", "add", "add", "add", "add",
            "add", "contains", "remove", "remove", "add", "remove", "contains",
            "add", "remove", "add", "add", "add", "add", "contains", "contains",
            "add", "remove", "remove", "remove", "remove", "add", "add",
            "contains", "add", "add", "remove", "add", "add", "add", "add",
            "add", "add", "add", "add", "remove", "add", "remove", "remove",
            "add", "remove", "add", "remove", "add", "add", "add", "remove",
            "remove", "remove", "add", "contains", "add"};
        int[] nums = {72, 91, 48, 41, 96, 87, 48, 49, 84, 82, 24, 7, 56, 87, 81, 55, 19, 40, 68, 23, 80, 53, 76, 93, 95, 95, 67, 31, 80, 62, 73, 97, 33, 28, 62, 81, 57, 40, 11, 89, 28, 97, 86, 20, 5, 77, 52, 57, 88, 20, 48, 42, 86, 49, 62, 53, 43, 98, 32, 15, 42, 50, 19, 32, 67, 84, 60, 8, 85, 43, 59, 65, 40, 81, 55, 56, 54, 59, 78, 53, 0, 24, 7, 53, 33, 69, 86, 7, 1, 16, 58, 61, 34, 53, 84, 21, 58, 25, 45, 3};
*/
        String[] ops = {"add","contains","add","contains","remove","add","contains","add","add","add","add","add","add","contains","add","add","add","contains","remove","contains","contains","add","remove","add","remove","add","remove","add","contains","add","add","contains","add","add","add","add","remove","contains","add","contains","add","add","add","remove","remove","add","contains","add","add","contains","remove","add","contains","add","remove","remove","add","contains","add","contains","contains","add","add","remove","remove","add","remove","add","add","add","add","add","add","remove","remove","add","remove","add","add","add","add","contains","add","remove","remove","remove","remove","add","add","add","add","contains","add","add","add","add","add","add","add","add"};

		int[] nums = {58,0,14,58,91,6,58,66,51,16,40,52,48,40,42,85,36,16,0,43,6,3,25,99,66,60,58,97,3,35,65,40,41,10,37,65,37,40,28,60,30,63,76,90,3,43,81,61,39,75,10,55,92,71,2,20,7,55,88,39,97,44,1,51,89,37,19,3,13,11,68,18,17,41,87,48,43,68,80,35,2,17,71,90,83,42,88,16,37,33,66,59,6,79,77,14,69,36,21,40};
        System.out.println(ops.length);
        System.out.println(nums.length);
        for(int i =0 ; i<ops.length; i++) {
            System.out.println("i: " + i);
            switch(ops[i]) {
                case "add":
                    System.out.println("Add: " + nums[i]);
                    hashSet.add(nums[i]);
                    break;
                case "remove":
                    System.out.println("Remove: " + nums[i]);
                    hashSet.remove(nums[i]);
                    break;
                case "contains":
                    System.out.println("Contains: " + nums[i]);
                    System.out.println(hashSet.contains(nums[i]));
                    break;
                default:
                    break;
            }
            hashSet.printHashSet();
        }
    }
}
