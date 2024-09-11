package test.task;

import java.util.Arrays;

public class Task5 {
    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};

    public static void main(String[] args) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int swap = arr[i];
            for (j = i; j > 0 && swap < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = swap;
        }
        System.out.println(Arrays.toString(arr));
    }
}
