package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.OneChoiceService;
import com.example.demo.service.SourceService;
import com.example.demo.service.TestService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class SpringbootmybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    SourceService sourceService;

    @Autowired
    OneChoiceService oneChoiceService;

    @Value("${excel.rows.length}")
    Integer rows;
    @Test
    void contextLoads() {
//        System.out.println(userMapper.getUserLoginInformation("xxxx"));
//        System.out.println(new Date(System.currentTimeMillis()));
//        //验证和读取JWT的示例方法
//
//        String jwt = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJndWFuZ21pbmdkZXhpbiIsInN1YiI6Inh4eHgiLCJpYXQiOjE1OTQ2MjgzOTgsImV4cCI6MTU5NDYzMTk5OH0.nJ8yFsTYSQFEYmS4EWdC1bFYXwzR_BKpoprqk1QiWErEI_mJ8NFGUMaw38iBseE120OroZVy9kyYGzuwZGSgKw";
//            //如果它不是签名的JWS（如预期的那样），则该行将抛出异常
//            Claims claims = Jwts.parser()
//                    .setSigningKey("iCode")
//                    .parseClaimsJws(jwt).getBody();
//            System.out.println("ID: " + claims.getId());
//            System.out.println("Subject: " + claims.getSubject());
//            System.out.println("Issuer: " + claims.getIssuer());
//            System.out.println("Expiration: " + claims.getExpiration());
            //claims.get("name") //获取自定义的信息
        System.out.println(File.separator);

    }

    @Test
    public void test1() throws IOException, BiffException {
        String filePath = "src/main/resources/static/questionbank/49a9eccb-157b-43fa-81c0-00227d0de412";
        String fileName = "题库模板2.1.xls";
        Boolean isCover = true;
//        File file = sourceService.readExcel(filePath, fileName, isCover);
//        Workbook workbook = Workbook.getWorkbook(file);
//        Sheet sheet = workbook.getSheet(0);
//
//        System.out.println(sheet.getColumns());
//        int columns = sheet.getColumns();
//        for (int col = 1; col < columns; col++) {
//                // 获取题型
//                Cell cell = sheet.getCell(col, 0);
//                String type = cell.getContents().trim();
//                switch (type){
//                    case "单选题":
//                        System.out.println("我是单选题！");
//                        String oneText = sheet.getCell(col, 1).getContents();
//                        if(isCover && oneChoiceService.findOneChoiceByText(oneText) != null) {
//                            System.out.println("有一道题重复!");
//                            break;
//                        }
//                        String oneA = sheet.getCell(col, 2).getContents();
//                        String oneB = sheet.getCell(col, 3).getContents();
//                        String oneC = sheet.getCell(col, 4).getContents();
//                        String oneD = sheet.getCell(col, 5).getContents();
//                        String oneE = sheet.getCell(col, 6).getContents();
//                        String oneF = sheet.getCell(col, 7).getContents();
//                        String oneAnswer = sheet.getCell(col, 8).getContents();
//                        String oneParse = sheet.getCell(col, 9).getContents();
//                        String oneLevel = sheet.getCell(col, 10).getContents();
//
//                        break;
//                    case "多选题":
//                        System.out.println("我是多选题!");
//
//                        break;
//                }
//
//        }

//        Cell cell = sheet.getCell(0, 0);
//        System.out.println(cell.getContents());
//        Cell cell1 = sheet.getCell(0, 1);
//        System.out.println(cell1.getContents());
        //System.out.println(sheet.getRow(1));
    }

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.test("1", "hello");
    }
}
