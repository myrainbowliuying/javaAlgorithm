import com.sun.deploy.util.ArrayUtil;

import java.util.Random;

public class quickSort {
    //快速排序
    public static void quickSort(int[] a,int low,int high)
    {
        if(low<high)
        {
            int q= radomizedSelect.randomizedPartition(a,low,high);//基准元素所在数组位置；
            quickSort(a,low,q);//对左边进行快速排序；
            quickSort(a,q+1,high);//对右边进行快速排序；
        }
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
        quickSort(a,0,n-1);
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]);
        }
    }
     **/
}
