package com.example.demo.service;

import com.example.demo.entity.Cell;
import com.example.demo.entity.KnowledgePoint;
import com.example.demo.entity.Point;
import com.example.demo.mapper.KnowledgePointMapper;
import com.example.demo.utils.JxlExcel;
import com.example.demo.utils.MyTree;
import com.example.demo.utils.Node;
import jxl.Sheet;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public final class KnowledgePointService {

    @Autowired
    private KnowledgePointMapper mapper;

    void uploadFileKnowledge(File file, String knowledgeId) {
        // MyFile myFile = ResultMap.uploadFile(file, path, courseId);

        // File destFile = new File(myFile.getFileAbsolutePath());
        // System.out.println("destFile: " + myFile.getFileAbsolutePath());
        JxlExcel jxlExcel = new JxlExcel(file);
        int rows = jxlExcel.getRowsAndColumns()[0];
        int columns = jxlExcel.getRowsAndColumns()[1];
        // 为了递归结束条件更加好写，为Excel增加一个边界，方便读取边界条件
        jxlExcel.addBound(rows, columns, 0);
        jxlExcel.flush();
        // 更新文件
        readExcelKnowledge(jxlExcel.getSheet(0), knowledgeId);

    }

    /**
     * @param sheet 工作表
     * 思路：将Excel表看作一个二维矩阵
     * 同一列可以看成同一层结点、前一列为父节点、后一列为子结点
     * 第一个子结点都为父节点行列加一
     * 算法思想：深度优先
     *              1.读取一个单元格，首先判断有无子结点
     *              2.如果有
     *              3.继续读取子结点
     *              4.直到最后一个子结点
     *              5.当没有子结点时，判断有无兄弟结点
     *              6.有，对兄弟结点重复上述操作1-4，即当前结点行索引加一
     *              7.没有，则返回到上一层，读取父结点得兄弟结点 重复 1 - 6
     *              8.同时，为了防止单元格得重复读取，创建一个索引地图，记录该单元格是否读取
     * */
    // 1. 读取 Excel 表结构
    private void readExcelKnowledge(Sheet sheet, String knowledgeId) {

        Node<Cell> root = new Node<>(new Cell("root", -1, -1, true), null);

        int rows = sheet.getRows();

        List<Integer> rowsList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            String content = sheet.getCell(0, i).getContents();
            if((!StringUtils.isEmpty(content)
                    && !StringUtils.isAllBlank(content)
                    && (StringUtils.length(content) > 0))) {
                rowsList.add(i);
            }
        }

        Cell[][] cells = createMaps(sheet);
        // 获取第一行不为空得单元格，记录行号
        for (Integer index : rowsList) {
            Node<Cell> node = root;
            read(sheet, node, index, 0, false, cells);
        }

   //     MyTree myTree = new MyTree();
//        System.out.println("打印多叉树---：");
//        System.out.println("根： " + root.childList.size());
//        System.out.println("子节点个数: " + myTree.countChildNode(root));
      //  myTree.printTree(root, 0);
        MyTree<Cell> myTree = new MyTree<>(root);
        writeDatabase(myTree, knowledgeId);
      //  System.out.println(sheet.getColumns() + "-" + sheet.getRows());
    }

    // 索引地图，避免重复读取
    private Cell[][] createMaps(Sheet sheet) {
        int rows = sheet.getRows();
        int columns = sheet.getColumns();
        Cell[][] map = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = new Cell("", i, j, false);
            }
        }
        return map;
    }

    private void read(Sheet sheet, Node<Cell> node, int row, int column, boolean isBrother, Cell[][] cells) {
        //1. 从第一列开始 到最后一行结束
        //2. 如果不未空，将内容加入树中, 如果未空同样返回上一层
        if(column < 0) {
            return;
        }

        if(column < sheet.getColumns() && row < sheet.getRows() &&
                (!StringUtils.isEmpty(sheet.getCell(column, row).getContents())
                        && !StringUtils.isAllBlank(sheet.getCell(column, row).getContents())
                        && (StringUtils.length(sheet.getCell(column, row).getContents()) > 0))) {
            String content = sheet.getCell(column, row).getContents();
            if(!cells[row][column].isRecord) {
                Node<Cell> child = new Node<>(new Cell(content, row, column, true), node);
                cells[row][column].isRecord = true;
               // System.out.println("(row, col): " + row + "-" + column);
                node.childList.add(child);
               //System.out.println("next_child_row, next_child_col " + (row + 1) + "-" + (column + 1));
                read(sheet, child, row + 1, column + 1, false, cells);
               // System.out.println("next_brother_row, next_brother_col " + (row + 1) + "-" + (column));
                read(sheet, child.parent, row + 1, column, true, cells);
            }
        }else {
            column -= 1;
            if(column == 0) {
                return;
            }
            // 没有兄弟结点，返回上一层
            if(isBrother) {
                MyTree<Cell> myTree = new MyTree<>();
               // int count = myTree.countChildNode(node);
                int newRow = node.data.rowIndex + myTree.countChildNode(node) + 1;
                //System.out.println("new_row, change_column " + newRow + "-" + column + "-> count: " + count);
                read(sheet, node.parent, newRow, column, false, cells);
            }
        }
    }

    // 将整棵树存入数据库中
    private void writeDatabase(MyTree<Cell> myTree, String knowledgeId) {
        if(myTree.getRoot() == null) {
            throw new NullPointerException("这是一棵空数，无法写入数据库中!");
        }

        myTree.printTree(myTree.getRoot(), 0);

        // 广度优先算法 存入树
        Queue<Node<Cell>> queue = new ArrayDeque<>();

        queue.add(myTree.getRoot());
        int count = 1;
        List<KnowledgePoint> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node<Cell> node = queue.poll();
            String nodePath;
            // 1. 判断是否为根节点
            if(node.parent == null) {
                // 2. 获取路径
                nodePath = "/" + count;
                node.data.path = nodePath;
                // 3. 存入数据库中
                list.add(new KnowledgePoint(-1, nodePath, node.data.content, true, knowledgeId));
                count++;
            }else {
                nodePath = node.parent.data.path + "/" + count;
                node.data.path = nodePath;
                list.add(new KnowledgePoint(count, nodePath, node.data.content, false, knowledgeId));
                count++;
            }

            if(node.childList != null) {
                queue.addAll(node.childList);
            }
        }
        // 更新根结点编号
        list.get(0).setId(count);
        mapper.insertBatchKnowledgePoint(list);
    }

    // 读取数据库数据，返回前台
    Point readDatabase(String knowledgeId) {
        // 获取所有知识点
        List<KnowledgePoint> list = mapper.findAll(knowledgeId);
        // 得到根结点
        KnowledgePoint root = null;
        for (KnowledgePoint knowledgePoint : list) {
            if (knowledgePoint.isRoot()) {
                root = knowledgePoint;
                break;
            }
        }
        assert root != null : "没有根结点";
        Point tree = new Point(root, new ArrayList<>());
        read(tree, list, root);
        return tree;
    }

    private void read(Point node, List<KnowledgePoint> list, KnowledgePoint knowledgePoint) {
        String rootPath = knowledgePoint.getPath();
        for (KnowledgePoint point : list) {
            if (point.getPath().equals(rootPath + "/" + point.getId())) {
                Point nextNode = new Point(point, new ArrayList<>());
                node.getNodes().add(nextNode);
                read(nextNode, list, point);
            }
        }
    }

    private boolean findTreePath(String path) {
        return mapper.findTreePath(path) == null;
    }
    
    private void updateTreeRoot(Integer id, String knowledgeId) {
        mapper.updateTreeRoot(id, knowledgeId);
    }

    void insertKnowledgeTreeNode(KnowledgePoint knowledgePoint, Integer rootId) {
        if(findTreePath(knowledgePoint.getPath())) {
            // 需要更新根节点 Id
            updateTreeRoot(rootId, knowledgePoint.getKnowledgeId());
            mapper.insertKnowledgeTreeNode(knowledgePoint);
        }
    }

    void deleteTreeNode(Integer nodeId, String knowledgeId, boolean isRoot) {
        // 删除该节点，及子结点

        // 1. 首先判断是否为根结点，如果为根结点，直接删除整棵树
        if(isRoot) {
            mapper.deleteTree(knowledgeId);
        }else {
            // 2. 不为根结点，删除  path中 nodeId一定不在开头
            // nodeId 为结尾 或者 nodeId为中间 比如 /1/2/3， /1/2， 1/2/3/4
            // 删除 2 结点，就必须删除 3， 4 结点
            List<KnowledgePoint> pointList = mapper.findAll(knowledgeId);
            List<Integer> nodeIds = new ArrayList<>();
            for (KnowledgePoint point : pointList) {
                if(point.getPath().endsWith("/" + nodeId) || point.getPath().contains("/+" + nodeId +"/")) {
                    nodeIds.add(point.getId());
                }
            }

            mapper.deleteTreeNode(nodeIds, knowledgeId);
        }

    }

    public List<Integer> getChild(String id, String regx) {
        return mapper.getChild(id, regx);
    }

    public static void main(String[] args) {
        List<KnowledgePoint> list = new ArrayList<>();
        list.add(new KnowledgePoint(1, "/1", null, true, "1"));
        list.add(new KnowledgePoint(2, "/1/2", "知识点一", false, "1"));
        list.add(new KnowledgePoint(3, "/1/3", "知识点二", false, "1"));
        list.add(new KnowledgePoint(4, "/1/4", "知识点三", false, "1"));
        list.add(new KnowledgePoint(5, "/1/2/5", "人为什么会死", false, "1"));
        list.add(new KnowledgePoint(6, "/1/2/6", "人来自哪里", false, "1"));
        list.add(new KnowledgePoint(7, "/1/3/7", "缺铁吃铁", false, "1"));
        list.add(new KnowledgePoint(8, "/1/4/8", "美丽新世界", false, "1"));
        list.add(new KnowledgePoint(9, "/1/4/9", "你好", false, "1"));
        list.add(new KnowledgePoint(10, "/1/4/10", "天气挺好", false, "1"));
        list.add(new KnowledgePoint(11, "/1/4/11", "这个好难", false, "1"));
        list.add(new KnowledgePoint(12, "/1/4/10/12", "明天会下雨", false, "1"));

        //TreeContent tree = new KnowledgePointService().readDatabase("1");
        //System.out.println(tree.toString());
        for (KnowledgePoint point : list) {
            if(point.getPath().endsWith("/2") || point.getPath().contains("/2/")) {
                System.out.println("这是2结点");
                System.out.println(point.getId() + "---" + point.getPath());
            }
        }
    }
}
