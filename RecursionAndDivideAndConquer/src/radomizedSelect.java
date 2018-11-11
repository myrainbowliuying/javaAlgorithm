import java.util.Random;

public class radomizedSelect {
    /**
     * 最坏时间复杂度为omicron(n^2);
     * 平均时间复杂度为omicron(n);
     * **/
    public static int randomizedSelect(int[] a,int low,int high,int k)
    {
        if(low==high) return a[low];
        int q=randomizedPartition(a,low,high);
        int j=q-low+1;
        if(k<=j)
        {
            return randomizedSelect(a,low,q,k);
        }
        else
        {
            return randomizedSelect(a,q+1,high,k-j);
        }
    }

    public static int randomizedPartition(int[]a,int low,int high)
    {
        Random random=new Random();
        int r=random.nextInt(high-low+1)+low;
        int pivotKey;
        pivotKey = a[r];
        swap(a, r, low);
        // 将大于基准点的值得数放到后面
        while (low < high) {
            while (low < high && a[high] >= pivotKey) {//
                high--;
            }
            swap(a, low, high);
            // 将小于基准点的值得数放到前面
            while (low < high && a[low] <= pivotKey) {
                low++;
            }
            swap(a, low, high);
        }
        // 返回基准点的索引
        return low;
    }

    public static void swap(int[] a,int low,int high)
    {
        int temp=a[low];
        a[low]=a[high];
        a[high]=temp;
    }
    //测试
    /**
    public static void main(String args[])
    {
        int[] a={3,5,2,4,1,7,9,5,8};
        int n=a.length;
        int result=randomizedSelect(a,0,n-1,5);
        System.out.print(result);
    }
     **/
}
