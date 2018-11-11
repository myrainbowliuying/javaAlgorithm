public class matrixChain {
    /**
     * 矩阵连乘积最右次序问题
     *1.考察该问题A[1,n]的最优结构特征。
     *  1.若计算次序在矩阵A[1,k],A[k+1,n]断开，则矩阵链A[1,k],A[k+1,n]的计算次序也是最优的。
     *  2.若矩阵链A[1,k],A[k+1,n]的一个计算次序需要的计算量更小，则用此次序替换原来的计算次序，可以容易得到计算A[1,n]计算量比最优次序的计算量少，这是一个矛盾。
     *  3.因此，矩阵连乘积计算次序的最优解包含这其子问题的最优解。所以该问题具有最优解结构性质。
     * 2.建立递归关系
     *  1.设计算A[i,j]所需要的最少计算次序为m[i,j]。所以原问题的最优值为m[1,n]。
     *  2.m[i,j]=0  i=j;
     *  3.m[i,j]=(i<=k<j)min{m[i,k]+m[k+1,j]+p,q,r} i<j;
     * 3.计算最优值
     *  1.如果用递归算法写，就重复计算了很多子问题。
     *  2.所以我们可以利用递归关系，以自底向上的方式进行计算，在计算过程中，保存已解决的子问题的答案。
     * 4.构造最优解
     *  矩阵s中已经记录了每一个最优断点，算法trackback可以计算出最优次序。
     * **/

    //动态规划算法matrixChain
    public static void matrixChain(int[] p,int[][]m,int[][]s)
    {
        int n=p.length-1;
        for(int i=0;i<n;i++) m[i][i]=0;
        for(int r=1;r<n;r++)
        {
            for(int i=0;i<n-r-1;i++)
            {
                int j=i+r;
                m[i][j]=m[i+1][j]+p[i]*p[i+1]*p[j+1];
                s[i][j]=i;
                for(int k=i+1;i<=j;i++)
                {
                    int t =m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if(t<m[i][j])
                    {
                        m[i][j]=t;
                        s[i][j]=k;
                    }
                }
            }
        }
    }

    //trackback求解最优解，计算出最优计算次序。
    public static void trackback(int [][] s,int i,int j){
        if(i==j)
            return;
        trackback(s,i,s[i][j]);
        trackback(s,s[i][j]+1,j);
        System.out.println("Multiply A"+i+","+(s[i][j]-1)+"and A"+(s[i][j])+","+j);
    }

    //两个矩阵乘积的标准算法为：
    public static void matrixMultiply(int [][] a,int [][] b,int [][] c,int ra,int ca,int rb,int cb)
    {//时间复杂度为omicron(ra*ca*cb)
        if(ca!=rb)
        {
            throw new IllegalArgumentException("矩阵不可乘");
        }
        for(int i=0;i<ra;i++)
        {
            for(int j=0;j<cb;j++)
            {
                c[i][j]=0;
                for(int k=0;k<ca;k++)
                {
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
    }

    //测试
    public static void main(String args[])
    {
        int [] p={30,35,15,5,10,20,25};
        int [][] m=new int[6][6];
        int [][] s=new int[6][6];
        matrixChain(p,m,s);
        for (int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        trackback(s,0,5);
    }
}
