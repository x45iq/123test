package test.task;

import java.util.Arrays;

public class Task10 {
    static final int[] arr = new int[]{123, 1, 5, 12, 3, 1992, 5123, 2333, 11, 0};

    static int[] mergeSort(int[] leftSlice, int[] rightSlice, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return leftSlice;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSort(leftSlice, rightSlice, startIndex, middle);
        int[] sorted2 = mergeSort(leftSlice, rightSlice, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == leftSlice ? rightSlice : leftSlice;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public static void main(String[] args) {
        System.arraycopy(mergeSort(Arrays.copyOf(arr, arr.length), new int[arr.length], 0, arr.length), 0, arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
