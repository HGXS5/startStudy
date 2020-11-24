package com.han.demo14;

import java.util.Comparator;

public class MyUtil {
    public static <T extends Comparable<T>> int binarySearch(T[] x,T key){
        return binarySearch(x, 0, x.length - 1, key);
    }

    /**
     *使用循环实现的二分法查找
     * @param x
     * @param key
     * @param comp
     * @param <T>
     * @return
     *      一位二进制称为一个比特（bit)
     *      八位二进制构成一个字节（Byte）
     *      字节是存储的基本单元，是计算机对数据操作的最小单位。
     *      地址相关概念
     *         地址总线的宽度决定了可以访问内存单元的个数。
     *         每一根地址线对应一位二进制。
     *         一位二进制可以区分两个状态。
     * 1. 位运算
     *      “>>”运算符做带符号的位移运算，它做位移处理时，会将值向右移，并在高位填0，
     *              然后将位移后所空出来的高位，全部改成原来的最高位的值（代表正负号的位）。
     *              也就是说负的值位移后，仍然是负的值
     *              （因为是负数，所以最高位是1，就变成1000 1010，在计算机中数都是使用补码存储的，
     *              负数的补码就是除了最高位外其他取反再加1，所以结果就是1111 0110）
     *           例如：-10>>2 = -3
     *              -10 = 1111 1111 1111 1111 1111 1111 1111 0110
     *              右移2位：0011 1111 1111 1111 1111 1111 1111 1101
     *              结果：1111 1111 1111 1111 1111 1111 1111 1101 （全部填上原本符号位的值：1）
     *      “>>>"运算符所做的是无符号的位移处理，它不会将所处理的值的最高位视为正负符号，所以做位移处理时，
     *              会直接在空出的高位填入0.当我们要做位移处理时原始值并非代表数值时（例如：表示颜色图素的值，最高位并非正负号），
     *              可能就会需要使用此种无符号的位移。
     *           例如：-10>>>2 = 1073741821
     *                -10=1111 1111 1111 1111 1111 1111 1111 0110 (不管原来的“符号”位的值（一长串1），空上的全部直接填0）
     *                 结果：0011 1111 1111 1111 1111 1111 1111 1101
     *       “<<"运算符的所做的也是无符号的位移处理，同样地，它不会将所处理的值的最高视为正负符号，它作为位移处理时，会直接左移并在
     *              低位填入0.所以第二高位以下的位若移到了最高位，该值的正负可能会与原来的不同。
     *              例如：-2147483647<<2=4
     *              -2147483647 = 1000 0000 0000 0000 0000 0000 0000 0001
     *              左移两位：0000 0000 0000 0000 0000 0000 0000 0100
     *              结果是 0000 0000 0000 0000 0000 0000 0000 0100=4
     *   说明：
     */
    public static <T> int binarySearch(T[] x, T key, Comparator<T> comp){
        int low = 0;
        int high = x.length - 1;
        while(low<= high){
            int mid = (low + high) >>> 1;
            int cmp = comp.compare(x[mid], key);
            if (cmp < 0){
                low = mid +1;
            }
            else if (cmp > 0){
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 使用递归实现的二分法查找
     * @param x
     * @param low
     * @param high
     * @param key
     * @param <T>
     * @return
     *
     * 说明：数组的初始索引设置为low,
     *      数组的最大索引为数组.length-1,
     *      开始
     *      传入参数：数组，初始索引，最大索引，要查找的值
     *      判断最低索引是否小于等于最大索引，等于则返回0，满足条件执行
     *          让其索引变化成中间位置的索引，然后判断其该索引位置的值与要查询的值是否相等，满足则直接返回结果
     *      判断查询的值是否小于该索引位置的值，小于则返回负数，满足条件执行
     *          进行递归操作，只不过数组总长度变为该位置索引大小减1操作，起始索引不变
     *      以上条件不满足则执行（也就是指查询的值大于该索引位置）
     *          进行递归操作，只不过起始索引大小变为该位置索引大小加1，最大索引不变
     *  该查询只针对从小到大的操作
     */
    private static <T extends Comparable<T>> int binarySearch(T[] x,int low, int high, T key){
        if (low <= high){
            System.out.println("此时的high是："+high);
            System.out.println("此时的low是："+low);
            final int i = (high - low) >> 1;
            System.out.println("位运算结果是："+i);
            int mid = low + ((high - low) >> 1);
            System.out.println("此时mid是："+mid);
//            if (mid == x.length-1 && key.compareTo(x[mid])<0){
//                return mid;
//            }自己添加的，没有被执行。
            if (key.compareTo(x[mid]) == 0){
                return mid;
            }
            else if (key.compareTo(x[mid])<0){
                return binarySearch(x, low, mid - 1, key);
            }
            else {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }

}
