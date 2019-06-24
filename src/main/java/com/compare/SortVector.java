package com.compare;

import java.util.Vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 20:01
 */
public class SortVector extends Vector {
    // To hold the callback
    private Compare compare;
    public SortVector(Compare comp) {
        compare = comp;
    }
    public void sort() {
        quickSort(0, size() - 1);
    }
    private void quickSort(int left, int right) {
        if(right > left) {
            Object o1 = elementAt(right);
            int i = left - 1;
            int j = right;
            while(true) {
                while(compare.lessThan(
                        elementAt(++i), o1)) {
                }
                while(j > 0) {
                    if(compare.lessThanOrEqual(
                            elementAt(--j), o1)) {
                        break; // out of while
                    }
                }
                if(i >= j) {
                    break;
                }
                swap(i, j);
            }
            swap(i , right);
            quickSort(left, i-1);
            quickSort(i+1, right);
        }
    }
    private void swap(int loc1, int loc2) {
        Object tmp = elementAt(loc1);
        setElementAt(elementAt(loc2), loc1);
        setElementAt(tmp, loc2);
    }
}
