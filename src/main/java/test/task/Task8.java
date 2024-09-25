package test.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.pow;

public class Task8 {
    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};
    static final List<List<Integer>> bins = new ArrayList<>() {{
        for (int i = 0; i < 10; i++) {
            this.add(new ArrayList<>());
        }
    }};

    public static void main(String[] args) {
        int md = Arrays.stream(arr).mapToObj(Integer::toString).map(String::length).max(Comparator.naturalOrder()).orElse(0);
        for (int i = 0; i < md; ++i) {
            for (int x : arr) {
                int dig = (x / (int) pow(10, i)) % 10;
                bins.get(dig).add(x);
            }
            int index = 0;
            for (var a : bins) {
                for (var b : a) {
                    arr[index++] = b;
                }
                a.clear();
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
