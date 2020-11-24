package com.han.demo13;

import java.util.Comparator;

/**
 * 排序器接口（策略模式：将算法封装到具有共同接口的独立的类中使得它们可以相互替换）
 */
public interface Sorter {
    /**
     * 排序
     * @param list 待排序的数组
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     * 排序
     * @param list 待排序的数组
     * @param comparable 比较两个对象的比较器
     * @param <T>
     */
    public <T> void sort(T[] list, Comparator<T> comparable);
}
