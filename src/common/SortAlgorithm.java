package common;

import java.util.Arrays;


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
        //array=bubbleSort(array);
        //int low=0,high=array.length-1;
       // array=quickSort(array,low,high);

        //array=insertionSort(array);
        array=shellSort(array);

       // array=selectionSort(array);
        //array=heapSort(array);

        //array=mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    /**
     * 冒泡排序
     * @param array
     * 比较两个相邻元素，大的在下面，小的在上面
     */
    private static int[] bubbleSort(int[] array) {
        //第几轮，每一轮可以找到一个最大元素放在合适地方。
        for(int i=0;i<array.length-1;i++){
            //最大元素已经在合适位置排好序了，只考虑前边的即可。
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    /**
     * 快速排序
     * @param array
     * 思路：选第一个元素为基准值，左边元素比基准小，右边元素比基准大。
     * 使用指针交换法:从high指针开始，把指针所指向元素与基准元素pivot做比较，
     * 若大于等于pivot，指针左移；若小于pivot，high指针停止移动，切换到
     * left指针。
     */
    private static int[] quickSort(int[] array,int low,int high) {
       if(low>=high){
           return null;
       }
        if(low<high){
            int index=partition(array,low,high);
            quickSort(array,low,index-1);
            quickSort(array,index+1,high);
        }
        return array;

    }


    /**
     *指针交换法
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] array, int low, int high) {
        //暂存基准元素下标
        int startIndex=low;
        int pivot=array[low];
        while(low<high){
            while (low<high && array[high]>=pivot){
                high--;
            }
            while(low<high && array[low]<=pivot){
                low++;
            }
            if(low<high){
                int temp=array[low];
                array[low]=array[high];
                array[high]=temp;
            }
        }
        //pivot和指针重合点交换
        int temp=array[startIndex];
        array[startIndex]=array[low];
        array[low]=temp;
        return low;
    }

    /**
     * 插入排序
     * @param array
     * 思路：从第一个元素开始已经排好序，继续取元素与排好序的元素比较，
     * 插入到已有元素中。
     * 按从小大排序
     */
    private static int[] insertionSort(int[] array) {
        for(int i=1;i<array.length;i++){
            int j=i;
            while (j>0 && array[j]<array[j-1]){
                int temp=array[j-1];
                array[j-1]=array[j];
                array[j]=temp;
                j--;
            }
        }
        return array;
    }

    /**
     * 希尔排序
     * @param array
     * 思路：先分组，再对每一组进行插入排序
     */
    private static int[] shellSort(int[] array) {
        /*int d= array.length;
        while(d>1){
            //希尔增量，每次折半,第一次增量为 长度/2
            d=d/2;
            //
            for(int x=0;x<d;x++){
                for(int i=x+d;i<array.length;i=i+d){
                    int temp=array[i];
                    int j;

                    for(j=i-d;j>=0 && array[j]>temp;j=j-d){
                        array[j+d]=array[j];
                    }
                    array[j+d]=temp;
                }
            }
        }
        return array;*/
        //步长在折半缩小
        for(int gap=array.length/2;gap>0;gap/=2){
            //同一步长内的元素，同一步长有好几组元素，使用插入排序
            for(int i=gap;i<array.length;i++){
                int temp=array[i],j;
                ////待排序的元素j（后一元素）,j-gap（前一元素）
                //待插入元素比有序数组最大元素大，有序元素后移
                for(j=i;j>=gap && temp<array[j-gap];j-=gap){
                    array[j]=array[j-gap];
                }
                //找到合适位置插入
                array[j]=temp;

            }
        }
        return array;

    }

    /**
     * 选择排序
     * @param array
     * 思路：每次从待排序区间中取出最小元素，把该元素与待排序区间第一个元素交换
     * eg: 36 25 48 12 65 43 20 58
     * [36 25 48 12 65 43 20 58]->12 [25 48 36 65 43 20 58]->12 20[48 36 65 43 25 58]->...
     */
    private static int[] selectionSort(int[] array) {
        for(int i=1;i<array.length;i++){
            int minIndex=i-1;
            for(int j=i;j<array.length;j++){
                if(array[minIndex]>array[j]){
                    minIndex=j;
                }
            }
            if(minIndex!=i-1){
                int temp=array[i-1];
                array[i-1]=array[minIndex];
                array[minIndex]=temp;
            }
        }
        return array;
    }

    /**
     * 堆排序
     * @param array 待调整的堆
     * 思路；大顶锥，每个结点的值都大于等于左右孩子结点的值。
     * 可以找第k小元素，构建k个元素的大顶锥，锥顶元素是第k小元素。
     * 1）把无序数组构建成二叉堆
     * 2）循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶。
     */
    private static int[] heapSort(int[] array) {
        int length=array.length;
        //构建堆
        for(int i=(length-2)/2;i>=0;i--){
            downAdjust(array,i,length);
        }
        //循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶。
        for(int i=length-1;i>0;i--){
            //最后一个元素和第一个元素交换
            int temp=array[i];
            array[i]=array[0];
            array[0]=temp;
            //下沉调整最大堆
            downAdjust(array,0,i);
        }
        return array;

    }

    /**
     * 下沉调整
     * @param array
     * @param i       要下沉的父节点
     * @param length  堆的有效大小
     */
    private static void downAdjust(int[] array, int i, int length) {
        int temp=array[i];
        int childindex=2*i+1;
        while (childindex<length){
            if(childindex+1<length && array[childindex+1]>array[childindex]){
                childindex++;
            }
            if(temp>=array[childindex]){
                break;
            }
            array[i]=array[childindex];
            i=childindex;
            childindex=2*childindex+1;
        }
        array[i]=temp;
    }


    /**
     * 归并排序
     * @param array
     * 把待排序的元素分为两个长度相等的子序列，对每个子序列进行
     * 排序，然后将他们合并成一个序列。
     */
    private static int[] mergeSort(int[] array,int start,int end) {
        if (start<end){
            int mid=(start+end)/2;
            //折半成两个小集合，分别递归
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            //将两个有序小集合进行归并
            merge(array,start,mid,end);
        }
        return array;
    }

    /**
     * 归并：比较与合并的过程
     * @param array
     * @param start
     * @param mid
     * @param end
     * 思路：
     * 1）创建一个额外大集合用于存储归并结果，长度为两小集合之和。
     * p1，p2分别代表小集合指针，p为大集合所对应指针
     * 2）从左到右逐一比较两个小集合中的元素，把较小元素放到大集合中。
     * 3）从另一个还有剩余元素的集合中，把剩余元素按顺序复制到大集合尾部。
     */
    private static void merge(int[] array, int start, int mid, int end) {
        int[] temp=new int[end-start+1];
        //两个集合为[start,mid],[mid+1,end]
        int p1=start,p2=mid+1,p=0;
        while(p1<=mid && p2<=end){
            if(array[p1]<array[p2]){
                temp[p]=array[p1];
                p1++;
                p++;
                //或者直接写成这种形式
                //temp[p++]=array[p1++];
            }
            else{
                temp[p++]=array[p2++];
            }
        }
        while (p1<=mid){
            temp[p++]=array[p1++];
        }
        while (p2<=end){
            temp[p]=array[p2++];
        }
        //把大集合中的元素复制回原数组  注意是i+start
        for(int i=0;i<temp.length;i++){
            array[i+start]=temp[i];
        }

    }


}
