package mathDemo;

/**
 * @Author: hebj
 * @Date: 2020/8/8 17:05
 * @Description:
 */
public class MathDemo {


    /**
     * https://blog.csdn.net/itismelzp/article/details/49621741
     *
     * @param args
     */
    public static void main(String[] args) {
        int add = multiply(12, 1);
        System.out.println(add);

    }


    /**
     * 两数相加
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int add(int num1, int num2) {
        while (num2 != 0) {
            int tmp1 = num1 ^ num2;
            int tmp2 = ((num2 & num1) << 1);
            num2 = tmp2;
            num1 = tmp1;
        }
        return num1;
    }

    /**
     * 两数相减
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int minus(int num1, int num2) {
        /**
         * 一个负数如何使用位运算得到两个数相加，例如-5=～(5)+1 =~(5-1)
         */
        int add = add(num1, add(~num2, 1));
        return add;
    }

    private static int multiply(int num1, int num2) {
        int res = 0;
        while (num2 != 0) {
            if ((num2 & 1) == 1) {
                res = add(res, num1);
            }
            num1 = num1 << 1;
            num2 = num2 >> 1;
        }
        return res;
    }

    /**
     * 除法运算，没看懂
     * 2020-08-10
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int divide(int num1, int num2) {
        if (num1 == 0) {
            return 0;
        }


        return 0;
    }


}
