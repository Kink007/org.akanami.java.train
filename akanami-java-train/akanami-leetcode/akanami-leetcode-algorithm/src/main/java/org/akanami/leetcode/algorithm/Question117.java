package org.akanami.leetcode.algorithm;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "[Val:" + val + "]" + " left:" + (left == null ? "null" : left.toString()) + " right:" + (right == null ? "null" : right.toString());
        }
    }

    public static void main(String[] args) {

        new Question117().test();
    }

    public void test() {
        Node node = this.getNode();
        System.out.println("Source:" + node);
        connect(node);
    }

    Node getNode() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;

        return n1;
    }

    public Node connect(Node root) {
        //根节点同级别右侧肯定为null
        root.next = null;

        connect(root, root.left);
        connect(root, root.right);

        return root;
    }

    public void connect(Node root, Node leaf) {
        if(root.right != null) {
            leaf.next = root.right;
        } else if (root.next != null) {
            Node flag = root.next;
            while(flag != null) {
                if(flag.left != null) {
                    leaf.next = flag.left;
                    break;
                } else if(flag.right != null) {
                    leaf.next = flag.right;
                    break;
                } else {
                    flag = flag.next;
                }
            }
        } else {
            leaf.next = null;
        }

        connect(leaf, leaf.left);
        connect(leaf, leaf.right);
    }
}
