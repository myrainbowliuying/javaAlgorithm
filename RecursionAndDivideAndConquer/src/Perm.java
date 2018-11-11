public class Perm
{//排列问题
    /**
     * 1.递归定义
     *  1.当n=1时，perm(R)=(r),其中r时集合R中唯一的元素。
     *  2.当n>1时，perm(R)=r1.perm(R1)+...+rn.perm(Rn).
     * **/
    public static void perm(Object[]list,int k,int m)
    {//产生list[k,m]的所有排列
        if(k==m)
        {
            for(int i=0;i<=m;i++)
            {
                System.out.print(list[i]);
            }
            System.out.println();
        }
        else
        {//还有很多元素
            for(int i=k;i<=m;i++)
            {
                Object temp=list[i];
                list[i]=list[k];
                list[k]=temp;
                perm(list,k+1,m);
                temp=list[i];
                list[i]=list[k];
                list[k]=temp;
            }
        }
    }
    //测试
    /**
    public static void main(String args[])
    {
        Object[] list={1,2,3,4,5,6,7,8,9};
        perm(list,0,8);
    }
    **/
}
