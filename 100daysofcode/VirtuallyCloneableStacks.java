/* https://binarysearch.com/problems/Virtually-Cloneable-Stacks */

import java.util.*;

class VirtuallyCloneableStacks {
    List<Integer> sizes;
    public VirtuallyCloneableStacks() {
        sizes = new ArrayList<>();
        sizes.add(0);
    }

    public void copyPush(int i) {
        sizes.add(sizes.get(i) + 1);
    }

    public void copyPop(int i) {
        sizes.add(sizes.get(i) - 1);
    }

    public int size(int i) {
        return sizes.get(i);
    }
}
