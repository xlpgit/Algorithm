package common;

/**
 * 七大经典排序算法
 *  插入排序：直接插入排序、希尔排序
 *  选择排序：直接选择排序、堆排序
 *  交换排序：冒泡排序、快速排序
 *  归并排序
 *  其中：插入排序、冒泡排序、归并排序为稳定算法，其它为不稳定算法。
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] array=new int[]{2,8,5,9,1,3,2};
        bubbleSort(array);
        quickSort(array);

        insertionSort(array);
        shellSort(array);

        selectionSort(array);
        heapSort(array);

        mergeSort(array);
    }

    /**
     * 冒泡排序
     * @param array
     */
    private static void bubbleSort(int[] array) {

    }

    /**
     * 快速排序
     * @param array
     */
    private static void quickSort(int[] array) {

    }

    /**
     * 插入排序
     * @param array
     */
    private static void insertionSort(int[] array) {

    }

    /**
     * 希尔排序
     * @param array
     */
    private static void shellSort(int[] array) {

    }

    /**
     * 选择排序
     * @param array
     */
    private static void selectionSort(int[] array) {

    }

    /**
     * 堆排序
     * @param array
     */
    private static void heapSort(int[] array) {

    }

    /**
     * 归并排序
     * @param array
     */
    private static void mergeSort(int[] array) {

    }


}
