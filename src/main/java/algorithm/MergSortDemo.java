package algorithm;

import java.util.Arrays;

/**
 * 归并排序
 * 时间：平均 o(nlogn) 最好 o(nlogn) 最差 o(nlogn)
 * 空间：o(n)
 *
 * @author Soarkey
 * @date 2021/3/24
 */
public class MergSortDemo {
    private static int[] temp;

    public static void main(String[] args) {
        int[] arr = {-5, 1, 123, 0, -9, 2, 31, -6, 1, 3, 23, 67, 34, -657};
        int n = arr.length;
        temp = new int[n];
        mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, k);
    }
}
