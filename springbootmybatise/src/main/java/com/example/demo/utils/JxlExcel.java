package com.example.demo.utils;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/*
数据写入Excel类
 */
public final class JxlExcel {
    // 可写得工作薄
    private WritableWorkbook workbook;

    // 只读工作薄
    private Workbook book;

    /*
    若excel文件不存在，则对应磁盘位置创建一个文件
     */
    public JxlExcel(File excel) {
        try {
            // Excel文件不存在时，初始化一个可写入的工作薄
            if(!excel.exists()) {
                File parentFile = excel.getParentFile();
                parentFile.mkdirs();

                workbook = Workbook.createWorkbook(excel);
            }else {
                /**
                 * Excel文件存在时，表明Excel中至少有一个工作表，
                 * 初始化一个可向工作表追加数据且能写入新数据的工作薄
                 *
                 * 此静态方法通过传入两个参数，Excel文件对象excel、只读工作工作薄对象book
                 * 来创建初始化一个可追加数据的工作薄对象
                 */
                book = Workbook.getWorkbook(excel);
                workbook = Workbook.createWorkbook(excel, book);
            }
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }

    }

    public WritableSheet getSheet(int sheetIndex) {

        WritableSheet sheet = null;

        if(sheetIndex < workbook.getNumberOfSheets()) {
            sheet = workbook.getSheet(sheetIndex);
        }else {
            sheet = workbook.createSheet("", sheetIndex);
        }
        return sheet;
    }

    public void writeRow(List<String> rowContent, int sheetIndex, int rowIndex) {
        try {

            // 得到工作表
            WritableSheet sheet = getSheet(sheetIndex);

            for (int i = 0; i < rowContent.size(); i++) {
                if(rowContent.get(i) == null) {
                    jxl.write.Blank blank = new jxl.write.Blank(i, rowIndex);
                    sheet.addCell(blank);
                }else {
                    jxl.write.Label label = new jxl.write.Label(i, rowIndex, rowContent.get(i));
                    sheet.addCell(label);
                }
            }
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    public void addBound(int rows, int columns, int sheetIndex) {
        // 得到工作表
        WritableSheet sheet = getSheet(sheetIndex);
        try {
            for (int i = 0; i < rows; i++) {
                jxl.write.Blank label = new jxl.write.Blank(columns, i);
                sheet.addCell(label);
            }
            for (int i = 0; i < columns; i++) {
                jxl.write.Blank label = new jxl.write.Blank(i, rows);
                sheet.addCell(label);
            }
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将Excel缓冲区的数据刷新写入到Excel文件中, <br/>
     * 在最后此方法必须被调用，否则数据不能真正写入Excel文件中
     */
    public void flush() {
        try {
            if (workbook != null) {
                workbook.write();
                workbook.close();
            }
            if (book != null) {
                book.close();
            }
        }
        catch (WriteException | IOException e) {
            e.printStackTrace();
        }
    }

    // 返回行、列
    public int[] getRowsAndColumns() {
        int rows = getSheet(0).getRows();
        int columns = getSheet(0).getColumns();

        return new int[]{rows, columns};
    }
}
