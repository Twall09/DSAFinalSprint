package com.example.tree.Controller;

import com.example.tree.Model.TreeEntity;
import com.example.tree.Model.TreeNode;
import com.example.tree.Repository.TreeRepository;
import com.example.tree.Service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TreeController {
    @Autowired
    private TreeService treeService;

    @Autowired
    private TreeRepository treeRepository;

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "redirect:/enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) throws Exception {
        int[] nums = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        TreeNode tree = treeService.buildTree(nums);
        String json = treeService.toJson(tree);

        TreeEntity entity = new TreeEntity();
        entity.setInputNumbers(numbers);
        entity.setTreeStructure(json);
        treeRepository.save(entity);

        model.addAttribute("treeJson", json);
        return "redirect:/previous-trees";
    }

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        List<TreeEntity> trees = treeRepository.findAll();
        model.addAttribute("trees", trees);
        return "previous-trees";
    }
}
