# 递归与分治策略

- 递归的概念
    1. 直接或者间接的调用自身的算法称为递归算法。
- 分治法的基本思想
    1. 将一个规模为n的问题分解为k个规模较小的子问题，这些子问题仙湖独立且与原问题相同。
    ```
    divide-and-conquer(P)
    {
        if(|P|<=n0) adhoc(P);//adhoc为基本子算法
        divide P into smaller subinstances P1,P2,P3,...,PK;
        for(int i=1;i<=k;i++)
        {
            yi=divide-and-conquer(Pi);
        }
        return merge(y1,y2,...,yk);
    }
    ```
    2. 平衡子问题思想，比子问题规模不等的做法更好。
    3. 分治法设计的算法一般是递归算法，所以计算效率可以用递归方程来分析。
        T(n)=omicron(1)  n==1;
            =kT(n/m)+f(n)  n>1;