package test.task;

import java.util.Arrays;

public class Task9 {

    static void heapify(int[] sortArr, int i, int size) {
        int left = (2 * i + 1);
        int right = (2 * i + 2);
        int largest = i;

        if (left < size && sortArr[left] > sortArr[i]) largest = left;
        if (right < size && sortArr[right] > sortArr[largest]) largest = right;

        if (largest != i) {
            int vi = sortArr[i];
            sortArr[i] = sortArr[largest];
            sortArr[largest] = vi;
            heapify(sortArr, largest, size);
        }
    }

    static int pop(int size) {
        if (size <= 0) {
            return -1;
        }
        int top = arr[0];

        arr[0] = arr[size-1];
        heapify(arr, 0, size - 1);
        return top;
    }

    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};

    public static void main(String[] args) {
        int n = arr.length;

        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(arr, i--, n);
        }

        while (n > 0) {
            arr[n - 1] = pop(n);
            n--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
