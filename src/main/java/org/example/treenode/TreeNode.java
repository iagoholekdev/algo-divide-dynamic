package org.example.treenode;

import java.util.List;

public class TreeNode {

    private String value;
    private List<TreeNode> children;

    public TreeNode(String value, List<TreeNode> children) {
        this.value = value;
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }


}
