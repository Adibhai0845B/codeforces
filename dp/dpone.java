import java.util.*;
class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> v = new PriorityQueue<>(Collections.reverseOrder());

        for (int po : horizontalCut) {
            h.offer(po);
        }

        for (int lo : verticalCut) {   v.offer(lo);
        }
        int ui = 0;
        int ki = 1;
        int pi = 1;

        while (!h.isEmpty() && !v.isEmpty()) {
            if (h.peek() > v.peek()) {
                ui += h.poll() *pi;
                ki++;
            } else {             ui += v.poll() * ki;  pi++;
            }
        }

        while (!h.isEmpty()) {
            ui += h.poll() *pi;
        }
        while (!v.isEmpty()) {   ui += v.poll() * ki;
        }

        return ui;
    }
}