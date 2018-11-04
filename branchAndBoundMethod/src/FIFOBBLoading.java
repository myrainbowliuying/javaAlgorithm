import java.util.ArrayDeque;

public class FIFOBBLoading {//队列式分支界限法的最优装载问题
    /**
    * 1.maxLoading求最优值的最优装载方法
    * 2.mmaxLoading求最优值和最优解以及优化搜索方法的最优装载方法
    * 3.算法enQueue用于将活节点加入到活节点队列中去。
    **/

    /**
     * 算法maxLoading的计算时间和空间复杂度均为omicron(2^n);
     **/

    static int n;
    static int bestw;//当前最优装载重量；
    static ArrayDeque queue;//活结点队列；

    public static int maxLoading(int [] w,int c)
    {//初始化
        bestw=0;
        n=w.length-1;
        queue=new ArrayDeque();
        queue.offer(new Integer(-1));//同层结点尾部标志；

        int i=1;//当前扩展结点所在的层
        int ew=0;//扩展结点所相应的载重量

        //搜索子树集空间树
        while(true)
        {
            //检查左儿子树
            if(ew+w[i]<=c)
            {
                enQueue(ew+w[i],i);

            }
            //右儿子结点总是可行的
            enQueue(ew,i);
            ew=((Integer)queue.poll()).intValue();//取下一扩展结点
            if(ew==-1)
            {
                //同层结点尾部
                if(queue.isEmpty())return bestw;
                queue.offer(new Integer(-1));//同层结点尾部标志
                ew=((Integer)queue.poll()).intValue();//取下一扩展结点
                i++;//进入下一层
            }

        }
    }

    private static void enQueue(int wt,int i)
    {//将活结点加入到活结点队列Q中
        if(i==n)
        {//可行叶结点
            if(wt>bestw) bestw=wt;
        }
        else  //非叶结点
            queue.offer(new Integer(wt));
    }

    //测试
    public static void main(String args[])
    {
        int[] ww={1,2,3,4,5,6,7,8,9,10};
        int cc=30;
        System.out.print(maxLoading(ww,cc));
    }
}
