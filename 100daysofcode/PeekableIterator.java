/* https://binarysearch.com/problems/Peekable-Iterator */

class PeekableIterator {
    int i;
    int[] internal;
    public PeekableIterator(int[] nums) {
        internal = nums;
        i = 0;
    }

    public int peek() {
        return internal[i];
    }

    public int next() {
        return internal[i++];
    }

    public boolean hasnext() {
        return i < internal.length;
    }
}
