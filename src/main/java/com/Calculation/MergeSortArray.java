package com.Calculation;

/**
 * @Description: 合并搜索算法
 * @author: zhuzz
 * @date: 2018-09-12 16:30
 */
public class MergeSortArray {
    private long[] theArray;
    private int nElems;
    public MergeSortArray(int max) {
        theArray = new long[max];
        nElems = 0;
    }
    public void insert(long value) {
        theArray[nElems] = value; // insert it
        nElems++; // increment size
    }
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println("");
    }
    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }
    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) // if range is 1,
            return; // no use sorting
        else { // find midpoint
            int mid = (lowerBound + upperBound) / 2;
            // sort low half
            recMergeSort(workSpace, lowerBound, mid);
            // sort high half
            recMergeSort(workSpace, mid + 1, upperBound);
            // merge them
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }
    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr]) {
                workSpace[j++] = theArray[lowPtr++];
            } else {
                workSpace[j++] = theArray[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = theArray[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = theArray[highPtr++];
        }
        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }
    }
    public static void main(String[] args) {
        int maxSize = 100; // array size
        MergeSortArray arr = new MergeSortArray(maxSize); // create the array
        arr.insert(14);
        arr.insert(21);
        arr.insert(43);
        arr.insert(50);
        arr.insert(62);
        arr.insert(75);
        arr.insert(14);
        arr.insert(2);
        arr.insert(39);
        arr.insert(5);
        arr.insert(608);
        arr.insert(36);
        arr.display();
        arr.mergeSort();
        arr.display();
    }
}
