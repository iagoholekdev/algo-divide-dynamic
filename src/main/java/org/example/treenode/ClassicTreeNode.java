package org.example.treenode;

import java.util.ArrayList;
import java.util.List;

public class ClassicTreeNode {

    public static void main(String[] args) {
        // Criando uma árvore simples
        TreeNode root = new TreeNode("A",
                List.of(
                        new TreeNode("B", List.of(new TreeNode("C", List.of()))),
                        new TreeNode("D", List.of(new TreeNode("E", List.of()), new TreeNode("F", List.of())))
                ));

        List<String> allNodeValues = getAllNodeValuesClassic(root);
        System.out.println("Todos os valores dos nós: " + allNodeValues);

        List<TreeNode> leafNodes = getLeafNodesClassic(root);
        System.out.println("Nós folha: " + leafNodes);
    }

    private static List<String> getAllNodeValuesClassic(TreeNode root) {
        List<String> result = new ArrayList<>();
        getAllNodeValuesRecursive(root, result);
        return result;
    }

    private static List<TreeNode> getLeafNodesClassic(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        getLeafNodesRecursive(root, result);
        return result;
    }

    private static void getAllNodeValuesRecursive(TreeNode node, List<String> result) {
        result.add(node.getValue());
        for (TreeNode child : node.getChildren()) {
            getAllNodeValuesRecursive(child, result);
        }
    }

    private static void getLeafNodesRecursive(TreeNode node, List<TreeNode> result) {
        if (node.getChildren().isEmpty()) {
            result.add(node);
        } else {
            for (TreeNode child : node.getChildren()) {
                getLeafNodesRecursive(child, result);
            }
        }
    }

}
