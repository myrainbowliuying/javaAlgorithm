public class Loading {
    /**
    * 1. 问题描述
    *    略，以后有时间再写
    *  2. 由于子集和问题和划分问题都是NP难问题，经分析得，装在问题等价于子集和问题，所以也是一个NP难问题。
    *  3. 所以，如果一个装载问题有解，采用以下的策略可得到最优的装载方案。
    *    (1)首先将第一艘轮船尽可能的装满；
    *    (2)将剩余的集装箱装上第二艘轮船。
     **/

    /**
    * 计算时间为omicron(2^n)
    * 额外的递归栈空间为omicron(n)
    */

    /**
    * 优化函数：
    *  (1)如果剩下的重量和cw加起来还小于bestcw,就不用搜索右子树了。
    *  (2)为了构造最优解，就必须记录当前最优值相应的最优解。所以增加一个数组来记录当前的最优路径。
    * */

    static int n;//集装箱的数量
    static int[] w;//集装箱重量数组
    static int c;//第一艘轮船的载重量
    static int cw;//当前载重量
    static int bestcw;//当前最优载重量

    public static int maxLoading(int[] ww,int cc)
    {
        //初始化类数据成员
        n=ww.length-1;
        w=ww;
        c=cc;
        cw=0;
        bestcw=0;

        //计算最优装载重量
        backtrack(1);
        return bestcw;
    }

    public static void backtrack(int i)
    {
        //搜索第i层结点
        if(i>n)
        {
            if(cw>bestcw)
            {
                bestcw=cw;
            }
            return;
        }
        //搜索子树
        if(cw+w[i]<=c)//搜索左子树
        {
            cw+=w[i];
            backtrack(i+1);
            cw-=w[i];
        }
        backtrack(i+1);//搜索右子树
    }

    //测试
}
