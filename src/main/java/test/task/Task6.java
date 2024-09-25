package test.task;

import java.util.Arrays;

public class Task6 {
    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};

    public static void main(String[] args) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                var miv = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = miv;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
