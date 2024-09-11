package test.task;

import java.util.Arrays;

public class Task4 {
    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};

    public static void main(String[] args) {
        int l = arr.length;
        float factor = 1.247f;
        float gapFactor = l / factor;
        while (gapFactor > 1) {
            int gap = Math.round(gapFactor);
            for (int i = 0, j = gap; j < l; i++, j++) {
                if (arr[i] > arr[j]) {
                    int s = arr[i];
                    arr[i] = arr[j];
                    arr[j] = s;
                }
            }
            gapFactor = gapFactor / factor;
        }
        System.out.println(Arrays.toString(arr));
    }
}
