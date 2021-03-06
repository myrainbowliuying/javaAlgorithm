# 动态规划

- 基本思想
    1. 将带求解问题分解成若干个子问题，先求解子问题，然后从子问题的解得到原问题的解。
    2. 经分解的子问题往往不是相互独立的。不同的子问题的数目常常只有多项式量级。用一个表来记录所有已解决的子问题的答案。
    3. 动态规划算法适用于解最优化问题。通常可以按照以下步骤设计动态规划问题：
        1. 找到最优解的性质，并刻画其结构特征；
        2. 递归的定义最优值；
        3. 以自底向上的方法计算出最优值；
        4. 根据计算最优值时得到的信息，构造最优解。
- 动态规划算法的基本要素
    1. 最优子结构性质:一个问题的最优解包含了子问题的最优解的时候，称此问题具有最优子结构性质。
    2. 重叠子问题
    
# 备忘录方法

- 备忘录方法时动态规划算法的变形，与动态规划不同的时，备忘录方法的递归方式是自顶向下的。