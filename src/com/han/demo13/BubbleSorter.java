package com.han.demo13;

import java.util.Comparator;

/**
 * 冒泡排序
 */
public class BubbleSorter implements Sorter {
    /**
     *
     * @param list 待排序的数组
     * @param <T>
     *   1. compareTo(T o)方法 将此对象与指定对象进行比较。
     *                  当此对象小于，等于或大于指定对象的时候，返回负数，零或正整数 。(在Comparable接口中）
     *              参数：o
     *                  要比较的对象
     *
     *              返回：
     *                  负整数，零或正整数，因为此对象小于，等于或大于指定的对象。
     * 说明：
     *      这个冒泡排序分为两部分：外循环，内循环
     *      内循环：
     *          首先比较的是前两位数值大小，由compareTo方法。当条件是前者大于后者时，两者互换位置。
     *          然后通过索引++的条件，判断下一组。当条件不满足前者大于后者时，位置不动，索引++。
     *          当快要读取最后一个数值时，此时就需要通过外循环的索引进行限制读取的进度，否则发生索引越界异常。
     *          表示形式为，原来的数组长度减去外循环的此时表示的索引。
     *      外循环：
     *          根据首要条件：比较的是相邻两个位置数值大小，且索引相差为1.
     *          则外循环需要设置初始索引为1的条件进行限制，其次内循环执行完一次完整比较之后，最后的一个索引就比较过的最大值。
     *          最后一位索引位置确定后，下次进行比较就不需要考虑。
     *          则此时外循环就可以通过++的方式，使得忽略到已确定好的位置索引。
     *      通过以上，重复直至完成全部。
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j){
                if (list[j].compareTo(list[j+1]) > 0){
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j+1] = temp;
                    swapped = true;
                }
            }

        }
    }

    /**
     *
     * @param list 待排序的数组
     * @param comparable 比较两个对象的比较器
     * @param <T>
     *     1.compare(T o1,T o2)方法 比较其两个参数的顺序。
     *                      当第一个参数小于，等于或大于第二个参数时，返回负整数，零或正整数。（在Comparator接口中）
     */
    @Override
    public <T> void sort(T[] list, Comparator<T> comparable) {
        boolean swapped = true;
        for (int i = 1,len = list.length; i < len && swapped; ++i){
            swapped = false;
            for (int j = 0; j < len - i; ++j){
                if (comparable.compare(list[j],list[j+1]) > 0){
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

}
