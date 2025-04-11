package com.example.tree.Model;

import jakarta.persistence.*;

public class TreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inputNumbers;

    @Lob
    private String treeStructure;

    // Getters and setters
    public Long getId() { return id; }
    public String getInputNumbers() { return inputNumbers; }
    public void setInputNumbers(String inputNumbers) { this.inputNumbers = inputNumbers; }
    public String getTreeStructure() { return treeStructure; }
    public void setTreeStructure(String treeStructure) { this.treeStructure = treeStructure; }
}
