package com.example.demo.entity;

import java.util.Date;

// 测试
public class Test {

    private String testId;

    private String CouCourseId;

    private String testName;

    private int testTime;

    private Date testBegin;

    private Date testEnd;

    public Test(String testId, String couCourseId, String testName, int testTime, Date testBegin, Date testEnd) {
        this.testId = testId;
        CouCourseId = couCourseId;
        this.testName = testName;
        this.testTime = testTime;
        this.testBegin = testBegin;
        this.testEnd = testEnd;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getCouCourseId() {
        return CouCourseId;
    }

    public void setCouCourseId(String couCourseId) {
        CouCourseId = couCourseId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestTime() {
        return testTime;
    }

    public void setTestTime(int testTime) {
        this.testTime = testTime;
    }

    public Date getTestBegin() {
        return testBegin;
    }

    public void setTestBegin(Date testBegin) {
        this.testBegin = testBegin;
    }

    public Date getTestEnd() {
        return testEnd;
    }

    public void setTestEnd(Date testEnd) {
        this.testEnd = testEnd;
    }
}
