public class mergeSort {
    static int[]a;

    public static void mergeSort(int a[],int left,int right)
    {
            int middle=(left+right)/2;
            if(left<right) {
                mergeSort(a, left, middle);
                mergeSort(a, middle + 1, right);
                merge(a,left,middle,right);//合并到数组b并复制回数组a
            }
    }
    public static void merge(int a[],int left,int middle,int right)
    {
        int[] b=new int[a.length];
        int center=middle+1;
        int i=left;
        int temp=left;
        while(left<=middle && center<=right)
        {
            if(a[left]<a[center])
            {
                b[i++]=a[left++];
            }
            else
            {
                b[i++]=a[center++];
            }
        }
        while(left<=middle)
        {
            b[i++]=a[left++];
        }
        while(center<=right)
        {
            b[i++]=a[center++];
        }
        while(temp<=right)
        {
            a[temp]=b[temp++];
        }
    }
    //测试
    /**
    public static void main(String args[])
    {
        int[] a={3,5,2,4,1,7,9,5,8};
        int n=a.length;
        mergeSort(a,0,n-1);
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]);
        }
    }
     **/
}
