package com.zg;

import javax.xml.ws.Holder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final String[] ABC = new String[]{"a", "b", "c", "d", "e", "f"};

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Set<String> delNames = new HashSet<String>() {{
            add("b");
            add("c");
            add("f");
            add("e");
            add("d");
        }};

        Holder<Integer> result = new Holder<>(0);

        Node root = buildTree();

        delDirs(delNames, root, result);
        System.out.println(result.value);

        delSubs(root);
        System.out.println(root);
        System.out.println("end");
    }

    private static void delSubs(Node root) {
        if (root.subNum == 0) {
            root.subNodes.clear();
        }
        for (Node subNode : root.subNodes) {
            delSubs(subNode);
        }
    }

    private static void delDirs(Set<String> delNames, Node root, Holder<Integer> result) {
        for (Node node : root.subNodes) {
            delDirs(delNames, node, result);
            if (delNames.contains(node.name) && node.subNum == 0) {
                result.value++;
                node.parent.removeNode();
            }
        }
    }

    private static Node buildTree() {
        Node root = new Node("a");
        root.addSubNodes(getRandomNode());
        for (Node subNode : root.subNodes) {
            subNode.addSubNodes(getRandomNode());
            for (Node node : subNode.subNodes) {
                node.addSubNodes(getRandomNode());
            }
        }
        System.out.println(root);
        return root;
    }

    public static List<Node> getRandomNode() {
        return Stream.generate(() -> new Node(ABC[RANDOM.nextInt(6)])).limit(RANDOM.nextInt(10))
            .collect(Collectors.toList());
    }


    static class Node {
        String name;

        int subNum;

        List<Node> subNodes;

        Node parent;

        public Node(String name) {
            this.name = name;
            subNodes = new ArrayList<>();
        }

        public void removeNode() {
            subNum--;
        }

        public void addNode(Node node) {
            subNum++;
            subNodes.add(node);
            node.parent = this;
        }

        public void addSubNodes(List<Node> nodes) {
            for (Node node : nodes) {
                addNode(node);
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                "name='" + name + '\'' +
                ", subNum=" + subNum +
                ", subNodes=" + subNodes +
                '}';
        }
    }
}
