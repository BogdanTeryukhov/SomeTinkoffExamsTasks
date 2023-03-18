package BackendJavaCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Stable Power Grid
 */

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                list.add(new Node(i + 1, 0, 0, null, null, null, 0));
            } else {
                list.add(new Node(i + 1, 0, 0, null, null, null, 0));
            }
        }
        for (int i = 0; i < n; i++) {
            list.get(i).setAi(scanner.nextInt());
        }
        for (int i = 1; i < n; i++) {
            int temp = scanner.nextInt();
            list.get(i).setParent(list.get(temp - 1));

            if (list.get(temp - 1).getLeftChild() == null) {
                list.get(temp - 1).setLeftChild(list.get(i));
            } else {
                list.get(temp - 1).setRightChild(list.get(i));
            }
        }
        for (int i = 1; i < n; i++) {
            list.get(i).setLength(scanner.nextInt());
        }

        int totalLength = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int j = i;
            while (list.get(j).getParent() != null) {
                if (j == i && (totalLength + list.get(j).getLength() <= list.get(i).getAi())) {
                    list.get(j).getParent().setPressuringFilters(list.get(j).getParent().getPressuringFilters() + 1);
                    totalLength += list.get(j).getLength();
                } else if (j == i) {
                    totalLength += list.get(j).getLength();
                } else if (totalLength + list.get(j).getLength() <= list.get(i).getAi()) {
                    int f = i;
                    boolean flag = false;
                    while (f > 0) {
                        if (list.get(f).getParent().getNumberOfNode() == list.get(j).getNumberOfNode()) {
                            flag = true;
                            break;
                        }
                        f--;
                    }
                    if (flag) {
                        list.get(j).getParent().setPressuringFilters(list.get(j).getParent().getPressuringFilters() + 1);
                        totalLength += list.get(j).getLength();
                    }
                }
                j--;
                if (j < 0) {
                    break;
                }
            }
            totalLength = 0;
        }
        for (Node node : list) {
            System.out.printf("%d ", node.getPressuringFilters());
        }
    }
}
class Node{
    private int numberOfNode;
    private int ai;
    private int length;
    private Node parent;
    private Node rightChild;
    private Node leftChild;
    private int pressuringFilters;


    public Node(int numberOfNode, int ai, int length, Node parent, Node rightChild, Node leftChild, int pressuringFilters) {
        this.numberOfNode = numberOfNode;
        this.ai = ai;
        this.length = length;
        this.parent = parent;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
        this.pressuringFilters = pressuringFilters;
    }

    public int getPressuringFilters() {
        return pressuringFilters;
    }

    public void setPressuringFilters(int pressuringFilters) {
        this.pressuringFilters = pressuringFilters;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public int getNumberOfNode() {
        return numberOfNode;
    }

    public void setNumberOfNode(int numberOfNode) {
        this.numberOfNode = numberOfNode;
    }

    public int getAi() {
        return ai;
    }

    public void setAi(int ai) {
        this.ai = ai;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "numberOfNode=" + numberOfNode +
                ", ai=" + ai +
                ", length=" + length +
                ", parent=" + parent.getNumberOfNode() +
                ", rightChild=" + rightChild.getNumberOfNode() +
                ", leftChild=" + leftChild.getNumberOfNode() +
                ", pressuringFilters=" + pressuringFilters +
                '}';
    }
}
