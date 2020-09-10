package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionPoint;
import com.example.demo.entity.Test;
import com.example.demo.mapper.TestMapper;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {

    @Autowired
    private TestMapper mapper;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private KnowledgePointService service;

    @Autowired
   // private RedisTemplate redisTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private List<String> sortByTypes;
    // 创建测试
    public HashMap<String, Object> createTest(Test test) {
        Date start = new Date();
        test.setTestBegin(start);
        long time = test.getTestTime() * 60 * 1000;
        test.setTestEnd(new Date(start.getTime() + time));
        mapper.createTest(test);
        return ResultMap.setResult("200", null, "测试创建成功");
    }

    // 获取该课程的所有测试
    public HashMap<String, Object> findAllTest(String courseId) {
        return ResultMap.setResult("200", mapper.findAllTest(courseId), "课程的所有测试");
    }

    // 获取某一个测试的所有题
    public HashMap<String, Object> findTestAllQuestion(String testId) {
        return ResultMap.setResult("200", mapper.findTestAllQuestion(testId, sortByTypes),
                "测试的所有的题");
    }

    // 判断该测试是否有试题
    private boolean isExistQuestion(String testId) {
        return mapper.isExistQuestion(testId);
    }


    // 自动组卷
    // 1. 用户选择关于组卷的基本参数
    // （1） 题目类型 - 及其题目数量
    // （2） 每种类型 - 分数
    // （3） 所涉及到的知识点
    // （4） 知识树 Id
    // （5） 题库 Id
    // 2. 当选择的知识点有子结点时，子结点对应的相关题目同样需要考虑
    // 3. 用户可以选择是否需要知识点

    // 4.用redis 存题目状态 hashmap
    // test:id type xxx, test:id count xxx, test:id point xxx

    public HashMap<String, Object> groupVolume(List<QuestionPoint> questionPointList,
                                               String sourceId, String testId, String knowledgeId, boolean isNeedKnowledge)
            throws Exception {
        if(questionPointList == null) {
            throw new NullPointerException("组卷参数为空，无法自定组卷");
        }
        // 获取题型返回顺序
        // 获取该测试已存在的所有该种题型
//        List<Question> q = mapper.findTestAllQuestion(testId, sortByTypes);
//        if(q != null) {
//            return ResultMap.setResult("400", q, "该测试已有试题，如需自动组卷，请先删除试题");
//        }
        if(isExistQuestion(testId)) {
            return ResultMap.setResult("400", null, "该测试已有试题，如需自动组卷，请先删除试题");
        }

        List<Integer> exam = new ArrayList<>();

            // 分优先级，首先满足知识点的题先随机选择
            for (QuestionPoint question : questionPointList) {
                int requireCount = question.getCount();
                String type = question.getQuestionType();
                if(isNeedKnowledge) {
                    // 存放 每道题对应得知识点Id
                    List<Integer> ids = question.getIds();
                    // 存放相应的题Id
                    Set<Integer> setIds = new HashSet<>();
                    for (Integer id : ids) {
                        String regx = "/"+ id +"/|/"+id+"$";
                        List<Integer> questionIds = service.getChild(knowledgeId, regx);
                        setIds.addAll(questionIds);
                    }
                    List<Integer> selectQuestion = questionService.selectQuestionByKnowledge(type, setIds);
                    int size = selectQuestion.size();

                    Collections.shuffle(selectQuestion);

                    if(size >= requireCount) {
                        exam.addAll(selectQuestion.subList(0, requireCount));
                    }else if(size > 0){
                        System.out.println("题库中 " + type + "相关知识点的题最多只有" + size);
                        exam.addAll(selectQuestion);
                    }else {
                        throw new NullPointerException("没有相关知识点的该种题型");
                    }
                    mapper.insertBatchTestQuestion(exam, testId);
                }else {
                    // 返回该题型的结果
                    // 并打乱List
                    List<Question> temp = questionService.findAllQuestionByIdAndType(type, sourceId);
                    if(temp.size() == 0 ) {
                        throw new Exception("题库中" + type + "数量为0");
                    }
                    Collections.shuffle(temp);
                    // 获取前count个
                    if(temp.size() < requireCount) {
                        // 如果题库题少于输入的count，则用数据库中的数量代替count
                        requireCount = temp.size();
                    }

                    List<Question> oneTypeQuestions = temp.subList(0, requireCount);
                    System.out.println("数组的长度: " + oneTypeQuestions.size());

                    for (Question oneTypeQuestion : oneTypeQuestions) {
                        // 将结果存入数据库中
                        mapper.insertTestQuestion(testId, oneTypeQuestion.getQuestionId());
                    }
                }
            }
        return ResultMap.setResult("200", exam, "组卷成功");
    }


    public void correct(String testId, int count) {
        // 1. 自动批改
        // (1) 获取可以自动批改的所有题型 id

        // (2) 获取答案

        // (3) 比对答案

        // (4) 计算得分，返回结果

        // 2. 手动批改
    }

}
