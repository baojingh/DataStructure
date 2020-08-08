package mathDemo;

/**
 * @Author: hebj
 * @Date: 2020/8/8 17:05
 * @Description:
 */
public class MathDemo {


    /**
     * https://blog.csdn.net/itismelzp/article/details/49621741
     * @param args
     */
    public static void main(String[] args) {
        int add = add(14, 29);
        System.out.println(add);

    }


    private static int add(int num1, int num2) {
        while (num2 != 0) {
            int tmp1 = num1 ^ num2;
            int tmp2 = ((num2 & num1) << 1);
            num2 = tmp2;
            num1 = tmp1;
        }
        return num1;
    }

}
