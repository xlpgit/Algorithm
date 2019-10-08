package offer;

/**
 * 利用小顶锥思想寻找第k大的元素
 */
public class findNumberK {
    public static void main(String[] args) {
        int[] array=new int[]{7,5,15,3,17,2,20,24,1,9,12,8};
        int k=5;
        System.out.println(findNumberKImpl(array,5));
    }

    private static int findNumberKImpl(int[] array,int k) {
        //利用前k个元素构建小顶锥
        bulidHeap(array,k);
        //继续遍历数组，和锥顶比较
        for(int i=k;i<array.length;i++){
            //此时array[0]对应锥顶元素，暂时第第k大元素
            if(array[i]>array[0]){
                array[0]=array[i];
                //调整堆结构，使其成为小顶锥
                downAdjust(array,0,k);
            }
        }
        //返回锥顶元素
        return array[0];

    }

    /**
     * 构建锥
     * @param array
     * @param k
     */
    private static void bulidHeap(int[] array, int k) {
        //从最后一个非叶子结点开始,对应(k-1-1)/2，依次下沉调整堆结构
        for(int i=(k-2)/2;i>=0;i--){
            downAdjust(array,i,k);
        }
    }

    /**
     * 调整堆结构
     * @param array 待调整的堆
     * @param i   要下沉的结点
     * @param k    堆的有效大小
     */
    private static void downAdjust(int[] array, int i, int k) {
        //保存父结点的值
       int temp=array[i];
       //孩子对应的下标
       int childrenIndex=2*i+1;
       while(childrenIndex<k){
           //定位到最小子结点
           if(childrenIndex+1<k && array[childrenIndex]>array[childrenIndex+1]){
               childrenIndex=childrenIndex+1;
           }
           //父节点小于最小的子节点，不用进行调整。
           if(temp<=array[childrenIndex]){
               break;
           }
           //父结点为最小值
           array[i]=array[childrenIndex];
           i=childrenIndex;
           childrenIndex=childrenIndex*2+1;
       }
        //下沉到最低。
       array[i]=temp;

    }


}
