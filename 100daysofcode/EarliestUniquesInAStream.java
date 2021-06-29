/* https://binarysearch.com/problems/Earliest-Uniques-in-a-Stream */

import java.util.*;

class EarliestUnique {
    Set<Integer> set = null;
    public EarliestUnique(int[] nums) {
        set = new LinkedHashSet<>();
        for (int ele : nums) {
            if (set.contains(ele)) {
                set.remove(ele);
            } else {
                set.add(ele);
            }
        }
    }

    public void add(int num) {
        if (set.contains(num)) {
            set.remove(num);
        } else {
            set.add(num);
        }
    }

    public int earliestUnique() {
        if (set.isEmpty())
            return -1;
        return set.iterator().next();
    }
}
