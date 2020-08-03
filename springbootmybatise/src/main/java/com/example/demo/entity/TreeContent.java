package com.example.demo.entity;

import java.util.List;

public class TreeContent {

    public String content;

    public List<TreeContent> contents;

    public TreeContent(String content, List<TreeContent> contents) {
        this.content = content;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "TreeContent{" +
                "content='" + content + '\'' +
                ", contents=" + contents +
                '}';
    }
}
