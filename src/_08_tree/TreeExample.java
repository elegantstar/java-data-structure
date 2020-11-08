package _08_tree;

public class TreeExample {
    /**
     * Tree : Cycle이 없는 그래프
     *  - 그래프의 일종.
     *  - 그래프의 탐색 기법인 DFS, BFS를 사용할 수 있다.
     *  - 인접행렬, 링크드리스트로 구현.
     *
     *  Binary Tree : 노드 v가 가지는 자식 노드가 최대 2개인 트리.
     *   - 이분탐색이 가능하다. (Binary Search Tree)
     *   - Binary Tree만의 탐색인 전위순회(preOrder), 중위순회(inOrder), 후위순회(postOrder)이 존재한다.
     *   - LinkedList로 구현.
     *   - 2차원 배열로 구현. arr[x][0] : 왼쪽 자식, arr[x][1] : 오른쪽 자식
     *
     *  Binary Search Tree (BST)
     *   1) 왼쪽 자식 노드의 값이 부모노드보다 작고, 오른쪽 자식노드의 값이 부모노드보다 큰 트리.
     *   2) 각 노드의 값이 유일해야 한다.
     *   3) 탐색 시간 복잡도 : O(h)
     *   4) 탐색 시간 평균 시간 복잡도 : O(logN) , 모든 노드가 2개의 자식 노드를 가지는 경우로 계산.
     *   5) 탐색 시간 최악 시간 복잡도 : O(N) , 편향 트리인 경우.
     *
     *   일반적으로 사용되는 BST는 Balancing 작업을 수행한다.
     *   ex) Red-Black Tree, AVL Tree
     *
     */

    /**
     * 1
     * 5    8
     * 7
     */

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode left = new TreeNode(5, null, null);
        TreeNode node = new TreeNode(7, null, null);
        TreeNode right = new TreeNode(8, node, null);
        TreeNode root = new TreeNode(1, left, right);

        binaryTree.root = root;
    }
}


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    TreeNode root;

    public void preOrder(TreeNode node) {
        //1. node 방문
        //2. preOrder(node.left)
        //3. preOrder(node.right)
    }

    public void inOrder(TreeNode node) {
        //1. inOrder(node.left)
        //2. node 방문
        //3. ineOrder(node.right)
    }

    public void postOder(TreeNode node) {
        //1. postOder(node.left)
        //2. postOder(ndde.right)
        //3. node 방문
    }
}

