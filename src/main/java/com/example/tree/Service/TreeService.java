package com.example.tree.Service;

import com.example.tree.Model.TreeNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class TreeService {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public TreeNode buildTree(int[] numbers) {
        TreeNode root = null;
        for (int num : numbers) root = insert(root, num);
        return root;
    }

    public String toJson(TreeNode root) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(root);
    }
}
