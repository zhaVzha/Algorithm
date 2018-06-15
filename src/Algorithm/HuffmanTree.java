package Algorithm;

import jdk.internal.dynalink.NoSuchDynamicMethodException;

import java.util.*;

public class HuffmanTree{
    public static class Node<E>{
        E data;
        double  weight;
        Node leftChild = null;
        Node rightChild = null;
        public Node(E data,double weight){
            super();
            this.data = data;
            this.weight = weight;
        }
    }

    public static void main(String args[]) {
        List<Node>  nodes = new ArrayList<Node>();

        nodes.add(new Node("A", 0.05));
        nodes.add(new Node("B", 0.28));
        nodes.add(new Node("C", 0.07));
        nodes.add(new Node("D", 0.08));
        nodes.add(new Node("E", 0.15));
        nodes.add(new Node("F", 0.23));
        nodes.add(new Node("G", 0.03));
        nodes.add(new Node("H", 0.11));

        creatHuffmanTree(nodes);
        System.out.print("CreatTreeIsSuccess");
        HuffmanTree.print(nodes);
    }

    /***
     * 创建HuffmanTree
     * @param nodes
     */
    public static void creatHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            quickSort(nodes);   //从小到大排序
            //取出最小的两个节点
            Node leftTree = nodes.get(0);
            Node rightTree = nodes.get(1);
            //创建新节点
            Node parent = new Node(null,leftTree.weight+rightTree.weight);
            parent.leftChild = leftTree;
            parent.rightChild = rightTree;
            //删除节点
            nodes.remove(0);
            nodes.remove(0);
            //将新节点加入
            nodes.add(parent);
        }

    }

    /**
     * 快排预处理
     * @param nodes
     */
    public static void quickSort(List<Node> nodes){
        realQuickSort(nodes,0, nodes.size()-1);
    }

    /**
     * 快排程序
     * @param nodes
     * @param low 下届
     * @param high 上界
     */
    public static void realQuickSort(List<Node> nodes,int low,int high){
        if(low < high){
            int l = low;
            int h = high;
            double flag = nodes.get(low).weight;
            while(l < h){
                while (nodes.get(high).weight > flag && l<h) {
                    h--;
                }
                if(l<h){
                    swap(nodes, l, h);
                    l++;
                }
                while (nodes.get(l).weight < flag && l < h) {
                    l++;
                }
                if(l<h){
                    swap(nodes, l, h);
                    h--;
                }
            }
            if(low<l-1)
                realQuickSort(nodes, low, l - 1);
            if(high>h+1)
                realQuickSort(nodes, h + 1, high);
        }
    }

    private static void swap(List<Node> nodes, int i , int j){
        Node tmp = nodes.get(i) ;
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

    /**
     * 输出HuffmanTree
     * @param nodes
     */
    private static void print(List<Node> nodes){
        Queue<Node> queue = new ArrayDeque<Node>();
        List<Node> list = new ArrayList<Node>();    //保存
        Node root = nodes.get(0);
        queue.offer(root); //把父节点加入队列

        while(!queue.isEmpty()){
            list.add(queue.peek());
            Node p = queue.poll();
            //如果有左孩子 就加入队列
            if(p.leftChild != null){
                queue.offer(p.leftChild);
            }
            //如果有右孩子，也加入队列
            if(p.rightChild != null){
                queue.offer(p.rightChild);
            }
        }

        while(list.size()!=0){
            System.out.print(list.get(0).data+" ");
            list.remove(0);
        }
    }
}































//public class HuffmanTree {
//
//    public static class Node<E> {
//        E data;
//        double weight;
//        Node leftChild;
//        Node rightChild;
//
//        public Node(E data, double weight) {
//            super();
//            this.data = data;
//            this.weight = weight;
//        }
//
//        public String toString() {
//            return "Node[data=" + data + ", weight=" + weight + "]";
//        }
//    }
//
//    public static void main(String[] args) {
//        List<Node> nodes = new ArrayList<Node>();
//
//        nodes.add(new Node("A", 40.0));
//        nodes.add(new Node("B", 8.0));
//        nodes.add(new Node("C", 10.0));
//        nodes.add(new Node("D", 30.0));
//        nodes.add(new Node("E", 10.0));
//        nodes.add(new Node("F", 2.0));
//
//        Node root = HuffmanTree.createTree(nodes);
//
//        System.out.println(breadthFirst(root));
//
//    }
//
//    /**
//     * 构造哈夫曼树
//     *
//     * @param nodes
//     *            节点集合
//     * @return 构造出来的哈夫曼树的根节点
//     */
//    private static Node createTree(List<Node> nodes) {
//        // 只要nodes数组中还有2个以上的节点
//        while (nodes.size() > 1) {
//            quickSort(nodes);
//            //获取权值最小的两个节点
//            Node left = nodes.get(nodes.size()-1);
//            Node right = nodes.get(nodes.size()-2);
//
//            //生成新节点，新节点的权值为两个子节点的权值之和
//            Node parent = new Node(null, left.weight + right.weight);
//
//            //让新节点作为两个权值最小节点的父节点
//            parent.leftChild = left;
//            parent.rightChild = right;
//
//            //删除权值最小的两个节点
//            nodes.remove(nodes.size()-1);
//            nodes.remove(nodes.size()-1);
//
//            //将新节点加入到集合中
//            nodes.add(parent);
//        }
//
//        return nodes.get(0);
//    }
//
//    /**
//     * 将指定集合中的i和j索引处的元素交换
//     *
//     * @param nodes
//     * @param i
//     * @param j
//     */
//    private static void swap(List<Node> nodes, int i, int j) {
//        Node tmp;
//        tmp = nodes.get(i);
//        nodes.set(i, nodes.get(j));
//        nodes.set(j, tmp);
//    }
//
//    /**
//     * 实现快速排序算法，用于对节点进行排序
//     *
//     * @param nodes
//     * @param start
//     * @param end
//     */
//    private static void subSort(List<Node> nodes, int start, int end) {
//        if (start < end) {
//            // 以第一个元素作为分界值
//            Node base = nodes.get(start);
//            // i从左边搜索，搜索大于分界值的元素的索引
//            int i = start;
//            // j从右边开始搜索，搜索小于分界值的元素的索引
//            int j = end + 1;
//            while (true) {
//                // 找到大于分界值的元素的索引，或者i已经到了end处
//                while (i < end && nodes.get(++i).weight >= base.weight)
//                    ;
//                // 找到小于分界值的元素的索引，或者j已经到了start处
//                while (j > start && nodes.get(--j).weight <= base.weight)
//                    ;
//
//                if (i < j) {
//                    swap(nodes, i, j);
//                } else {
//                    break;
//                }
//            }
//
//            swap(nodes, start, j);
//
//            //递归左边子序列
//            subSort(nodes, start, j - 1);
//            //递归右边子序列
//            subSort(nodes, j + 1, end);
//        }
//    }
//
//    public static void quickSort(List<Node> nodes){
//        subSort(nodes, 0, nodes.size()-1);
//    }
//
//    //广度优先遍历
//    public static List<Node> breadthFirst(Node root){
//        Queue<Node> queue = new ArrayDeque<Node>();
//        List<Node> list = new ArrayList<Node>();
//
//        if(root!=null){
//            //将根元素加入“队列”
//            queue.offer(root);
//        }
//
//        while(!queue.isEmpty()){
//            //将该队列的“队尾”元素加入到list中
//            list.add(queue.peek());
//            Node p = queue.poll();
//
//            //如果左子节点不为null，将它加入到队列
//            if(p.leftChild != null){
//                queue.offer(p.leftChild);
//            }
//
//            //如果右子节点不为null，将它加入到队列
//            if(p.rightChild != null){
//                queue.offer(p.rightChild);
//            }
//        }
//
//        return list;
//    }
//}