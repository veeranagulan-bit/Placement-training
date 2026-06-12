import java.util.*;

public class SegmentTreeFinal {

    static int[] arr = {4, 5, 6, 8, 9};

    static Map<Integer, List<String>> levelMap = new HashMap<>();

    public static void main(String[] args) {

        int total = build(0, 0, arr.length - 1, 0);

        System.out.println("\n🌳 SEGMENT TREE OUTPUT\n");

        for (int i = 0; i < levelMap.size(); i++) {
            System.out.println("Level " + i + " → " + levelMap.get(i));
        }

        System.out.println("\nFINAL TOTAL = " + total);
    }

    static int build(int index, int start, int end, int level) {

        if (!levelMap.containsKey(level)) {
            levelMap.put(level, new ArrayList<>());
        }

        // Leaf node
        if (start == end) {
            int val = arr[start];
            levelMap.get(level).add("[" + start + "-" + end + "] = " + val);
            return val;
        }

        int mid = (start + end) / 2;

        // LEFT CHILD
        int leftSum = build(2 * index + 1, start, mid, level + 1);

        // RIGHT CHILD
        int rightSum = build(2 * index + 2, mid + 1, end, level + 1);

        int total = leftSum + rightSum;

        // Store formatted output
        levelMap.get(level).add(
                "[" + start + "-" + end + "] = " + total +
                " (left=" + leftSum + ", right=" + rightSum + ")"
        );

        return total;
    }
}