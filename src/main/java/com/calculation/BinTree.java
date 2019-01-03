package com.calculation;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-09-12 16:27
 */
//*****本程序包括简单的二叉树类的实现和前序,中序,后序,层次遍历二叉树算法,*******//
//******以及确定二叉树的高度,制定对象在树中的所处层次以及将树中的左右***********//
//******孩子节点对换位置,返回叶子节点个数删除叶子节点,并输出所删除的叶子节点**//
public class BinTree {
    public final static int MAX = 40;
    BinTree[] elements = new BinTree[MAX]; // 层次遍历时保存各个节点
    int front; // 层次遍历时队首
    int rear; // 层次遍历时队尾
    private Object data; // 数据元数
    private BinTree left, right; // 指向左,右孩子结点的链
    public BinTree() {}
    public BinTree(Object data) { // 构造有值结点
        this.data = data;
        left = right = null;
    }
    public BinTree(Object data, BinTree left, BinTree right) { // 构造有值结点
        this.data = data;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return data.toString();
    }
    // 前序遍历二叉树
    public static void preOrder(BinTree parent) {
        if (parent == null) {
            return;
        }
        System.out.print(parent.data + " ");
        preOrder(parent.left);
        preOrder(parent.right);
    }
    // 中序遍历二叉树
    public void inOrder(BinTree parent) {
        if (parent == null) {
            return;
        }
        inOrder(parent.left);
        System.out.print(parent.data + " ");
        inOrder(parent.right);
    }
    // 后序遍历二叉树
    public void postOrder(BinTree parent) {
        if (parent == null) {
            return;
        }
        postOrder(parent.left);
        postOrder(parent.right);
        System.out.print(parent.data + " ");
    }
    // 层次遍历二叉树
    public void LayerOrder(BinTree parent) {
        elements[0] = parent;
        front = 0;
        rear = 1;
        while (front < rear) {
            try {
                if (elements[front].data != null) {
                    System.out.print(elements[front].data + " ");
                    if (elements[front].left != null) {
                        elements[rear++] = elements[front].left;
                    }
                    if (elements[front].right != null) {
                        elements[rear++] = elements[front].right;
                    }
                    front++;
                }
            } catch (Exception e) {
                break;
            }
        }
    }
    // 返回树的叶节点个数
    public int leaves() {
        if (this == null) {
            return 0;
        }
        if (left == null && right == null) {
            return 1;
        }
        return (left == null ? 0 : left.leaves()) + (right == null ? 0 : right.leaves());
    }
    // 结果返回树的高度
    public int height() {
        int heightOfTree;
        if (this == null) {
            return -1;
        }
        int leftHeight = (left == null ? 0 : left.height());
        int rightHeight = (right == null ? 0 : right.height());
        heightOfTree = leftHeight < rightHeight ? rightHeight : leftHeight;
        return 1 + heightOfTree;
    }
    // 如果对象不在树中,结果返回-1;否则结果返回该对象在树中所处的层次,规定根节点为第一层
    public int level(Object object) {
        int levelInTree;
        if (this == null) {
            return -1;
        }
        if (object == data) {
            return 1; // 规定根节点为第一层
        }
        int leftLevel = (left == null ? -1 : left.level(object));
        int rightLevel = (right == null ? -1 : right.level(object));
        if (leftLevel < 0 && rightLevel < 0) {
            return -1;
        }
        levelInTree = leftLevel < rightLevel ? rightLevel : leftLevel;
        return 1 + levelInTree;
    }
    // 将树中的每个节点的孩子对换位置
    public void reflect() {
        if (this == null) {
            return;
        }
        if (left != null) {
            left.reflect();
        }
        if (right != null) {
            right.reflect();
        }
        BinTree temp = left;
        left = right;
        right = temp;
    }
    // 将树中的所有节点移走,并输出移走的节点
    public void defoliate() {
        if (this == null) {
            return;
        }
        // 若本节点是叶节点，则将其移走
        if (left == null && right == null) {
            System.out.print(this + " ");
            data = null;
            return;
        }
        // 移走左子树若其存在
        if (left != null) {
            left.defoliate();
            left = null;
        }
        // 移走本节点，放在中间表示中跟移走...
        // innerNode += this + " ";
        data = null;
        // 移走右子树若其存在
        if (right != null) {
            right.defoliate();
            right = null;
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinTree e = new BinTree("E");
        BinTree g = new BinTree("G");
        BinTree h = new BinTree("H");
        BinTree i = new BinTree("I");
        BinTree d = new BinTree("D", null, g);
        BinTree f = new BinTree("F", h, i);
        BinTree b = new BinTree("B", d, e);
        BinTree c = new BinTree("C", f, null);
        BinTree tree = new BinTree("A", b, c);
        System.out.println("前序遍历二叉树结果: ");
        tree.preOrder(tree);
        System.out.println();
        System.out.println("中序遍历二叉树结果: ");
        tree.inOrder(tree);
        System.out.println();
        System.out.println("后序遍历二叉树结果: ");
        tree.postOrder(tree);
        System.out.println();
        System.out.println("层次遍历二叉树结果: ");
        tree.LayerOrder(tree);
        System.out.println();
        System.out.println("F所在的层次: " + tree.level("F"));
        System.out.println("这棵二叉树的高度: " + tree.height());
        System.out.println("--------------------------------------");
        tree.reflect();
        System.out.println("交换每个节点的孩子节点后......");
        System.out.println("前序遍历二叉树结果: ");
        tree.preOrder(tree);
        System.out.println();
        System.out.println("中序遍历二叉树结果: ");
        tree.inOrder(tree);
        System.out.println();
        System.out.println("后序遍历二叉树结果: ");
        tree.postOrder(tree);
        System.out.println();
        System.out.println("层次遍历二叉树结果: ");
        tree.LayerOrder(tree);
        System.out.println();
        System.out.println("F所在的层次: " + tree.level("F"));
        System.out.println("这棵二叉树的高度: " + tree.height());
    }
}
