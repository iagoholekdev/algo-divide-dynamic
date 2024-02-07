package org.example.treenode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModernTreeNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("A",
                List.of(
                        new TreeNode("B", List.of(new TreeNode("C", List.of()))),
                        new TreeNode("D", List.of(new TreeNode("E", List.of()), new TreeNode("F", List.of())))
                ));

        List<String> allNodeValues = getAllNodeValues(root);
        System.out.println("Todos os valores dos nós: " + allNodeValues);

        List<TreeNode> leafNodes = getLeafNodes(root);
        System.out.println("Nós folha: " + leafNodes.stream().map(TreeNode::getValue).toList());
    }


    private static List<String> getAllNodeValues(TreeNode root) {
        return Stream.concat(Stream.of(root.getValue()),
                        root.getChildren().stream().flatMap(child -> getAllNodeValues(child).stream()))
                .collect(Collectors.toList());
    }

    private static List<TreeNode> getLeafNodes(TreeNode root) {
        if (root.getChildren().isEmpty()) {
            return List.of(root);
        } else {
            return root.getChildren().stream().flatMap(child -> getLeafNodes(child).stream())
                    .collect(Collectors.toList());
        }
    }

}
