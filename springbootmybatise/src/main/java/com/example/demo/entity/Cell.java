package com.example.demo.entity;

public class Cell {
    // 内容
    public String content;

    // 行
    public int rowIndex;

    // 列
    public int columnIndex;

    // 是否被记录
    public boolean isRecord;

    // 存储路径
    public String path;

    public Cell(String content, int rowIndex, int columnIndex, boolean isRecord) {
        this.content = content;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.isRecord = isRecord;
    }

    @Override
    public String toString() {
        return content;
    }
}
