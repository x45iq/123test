package test.task;

import java.util.Arrays;

public class Task7 {
    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};

    public static void main(String[] args) {
        for (int s = arr.length / 2; s > 0; s /= 2) {
            for (int i = s; i < arr.length; ++i) {
                for (int j = i - s; j >= 0 && arr[j] > arr[j + s]; j -= s) {
                    var jv = arr[j];
                    arr[j] = arr[j+s];
                    arr[j+s] = jv;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
