public class FlowShop {
    /*
    * 1. 此问题的解空间是一个排列树。
    * 2. 整个算法的时间复杂性为omicron(n!)
    */

    static int n;//作业树
    static int f1;//机器一完成处理时间
    static int f2;//机器二完成处理时间
    static int f;//完成时间和
    static int bestf;//当前最优值
    static int[][]m;//各作业所需要的处理时间
    static int[] x;//当前作业调度
    static int[] bestx;//当前最优作业调度

    private static int bestFlowShop(int[][]mm)
    {
        //初始化
        n=mm[0].length;
        f1=0;
        f2=0;
        f=0;

        return bestf;
    }
}
