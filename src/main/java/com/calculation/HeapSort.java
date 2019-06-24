package com.calculation;

/**
 * @description: (二叉堆)基于最大堆的堆排序
 * @author: zhuzz
 * @date: 2018-12-25 15:58
 */
public class HeapSort {

    /**
     * 构建最大堆：将array看成完全二叉树的顺序存储结构
     *
     * @param array
     * @return
     */
    private int[] buildMaxHeap(int[] array) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
        }
        return array;
    }

    /**
     * 将元素array[k]自下往上逐步调整树形结构
     *
     * @param array
     * @param k
     * @param length
     */
    private void adjustDownToUp(int[] array, int k, int length) {
        int temp = array[k];
        //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {
            //取节点较大的子节点的下标
            if (i < length && array[i] < array[i + 1]) {
                //如果节点的右孩子>左孩子，则取右孩子节点的下标
                i++;
            }
            //根节点 >=左右子女中关键字较大者，调整结束
            if (temp >= array[i]) {
                break;
            } else {
                //根节点 <左右子女中关键字较大者
                //将左右子结点中较大值array[i]调整到双亲节点上
                array[k] = array[i];
                //【关键】修改k值，以便继续向下调整
                k = i;
            }
        }
        //被调整的结点的值放人最终位置
        array[k] = temp;
    }

    /**
     * 堆排序
     *
     * @param array
     * @return
     */
    public int[] heapSort(int[] array) {
        //初始建堆，array[0]为第一趟值最大的元素
        array = buildMaxHeap(array);
        for (int i = array.length - 1; i > 1; i--) {
            //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //整理，将剩余的元素整理成堆
            adjustDownToUp(array, 0, i);
        }
        return array;
    }

    /**
     * 删除堆顶元素操作
     *
     * @param array
     * @return
     */
    public int[] deleteMax(int[] array) {
        //将堆的最后一个元素与堆顶元素交换，堆底元素值设为-99999
        array[0] = array[array.length - 1];
        array[array.length - 1] = -99999;
        //对此时的根节点进行向下调整
        adjustDownToUp(array, 0, array.length);
        return array;
    }

    /**
     * 插入操作:向最大堆array中插入数据data
     *
     * @param array
     * @param data
     * @return
     */
    public int[] insertData(int[] array, int data) {
        //将新节点放在堆的末端
        array[array.length - 1] = data;
        //需要调整的节点
        int k = array.length - 1;
        //双亲节点
        int parent = (k - 1) / 2;
        while (parent >= 0 && data > array[parent]) {
            //双亲节点下调
            array[k] = array[parent];
            k = parent;
            if (parent != 0) {
                //继续向上比较
                parent = (parent - 1) / 2;
            } else {
                //根节点已调整完毕，跳出循环
                break;
            }
        }
        //将插入的结点放到正确的位置
        array[k] = data;
        return array;
    }

    public void toString(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String args[]) {
        HeapSort hs = new HeapSort();
        int[] array = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        System.out.print("构建大根堆：");
        hs.toString(hs.buildMaxHeap(array));
        System.out.print("\n" + "删除堆顶元素：");
        hs.toString(hs.deleteMax(array));
        System.out.print("\n" + "插入元素63:");
        hs.toString(hs.insertData(array, 63));
        System.out.print("\n" + "大根堆排序：");
        hs.toString(hs.heapSort(array));
    }
}
