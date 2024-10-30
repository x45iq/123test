package test.task;

import java.util.Arrays;

public class Task11 {
    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};
    public static void main(String[] args) {
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = getIndex(arr, low, high);


            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static int getIndex(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;


                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }
}
