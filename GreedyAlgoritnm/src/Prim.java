public class Prim {
    //最小生成树,邻接矩阵
    /**
     * 计算时间omicron(n^2);
     * {
     *     T=[];
     *     S={1};
     *     while(S!=V){
     *         (i,j)=i belong to S ,j belong to V-S 的最小权边;
     *         T=T+(i,j);
     *         S=S+j;
     *     }
     * }
     * **/

    private static final int INF=Integer.MAX_VALUE;

    public static void prim(int n,int [][]c )
    {
        int[] lowcost =new int[n];
        int[] closest =new int[n];
        boolean[] s=new boolean[n];

        s[0]=true;
        for(int i=1;i<n;i++)
        {
            s[i]=false;
        }

    }

    //测试
    public static void main(String args[])
    {
        int [][] c=
                {       {0,6,1,5,INF,INF},
                        {6,0,5,INF,3,INF},
                        {1,5,0,5,6,4},
                        {5,INF,5,0,INF,2},
                        {INF,3,6,INF,0,6},
                        {INF,INF,4,2,6,0},
                };
        int n=c[0].length;
        prim(n,c);
    }
}
