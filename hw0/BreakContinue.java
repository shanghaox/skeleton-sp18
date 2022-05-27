import static java.lang.System.arraycopy;

//编写一个函数windowPosSum(int[] a, int n)，，但前提是 a[i] 为正值。  如果因为到达数组末尾而没有足够的值，我们只求和我们有的值。
//
//例如，假设我们windowPosSum使用数组a = {1, 2, -3, 4, 5, 4}和调用n = 3。在这种情况下，我们会：
//
//将 a[0] 替换为 a[0] + a[1] + a[2] + a[3]。
//将 a[1] 替换为 a[1] + a[2] + a[3] + a[4]。
//不要对 a[2] 做任何事情，因为它是负面的。
//将 a[3] 替换为 a[3] + a[4] + a[5]。
//将 a[4] 替换为 a[4] + a[5]。
//不要对 a[5] 做任何事情，因为在 a[5] 之后没有值。
//因此，调用后的结果windowPosSum将是{4, 8, -3, 13, 9, 4}。
//
//再举一个例子，如果我们windowPosSum用数组a = {1, -1, -1, 10, 5, -1}, 和调用n = 2，我们会得到{-1, -1, -1, 14, 4, -1}.
public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
//        int[] b = new int[10];
//        arraycopy(a, 0, b, 0, a.length);
        for (int i = 0; i < a.length; i++) {
                if(a[i] <= 0)   continue;
            for (int j = i; j < i+n; j++) {//将每个元素 a[i] 替换为 a[i] 到 a[i + n] 的总和
                if(j+1 >= a.length) break;//break跳出for，continue下一个索引//改代码,不要等号
                a[i]+=a[j+1];//加后面的三个
            }
        }


//        提示 1：使用两个 for 循环。
//
//提示 2：continue用于跳过负值。
//
//提示 3：break用于避免越过数组的末尾。

    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}
