/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/12 21:26:21                           */
/*==============================================================*/


drop table if exists adult_children;

drop table if exists adult_news;

drop table if exists answerquestion;

drop table if exists assitant_news;

drop table if exists codequestion;

drop table if exists completion;

drop table if exists course;

drop table if exists enclosure;

drop table if exists homework;

drop table if exists morechoice;

drop table if exists news_bank;

drop table if exists onechoice;

drop table if exists permission;

drop table if exists source_questiontype;

drop table if exists questiontype;

drop table if exists role;

drop table if exists student_reply;

drop table if exists test;

drop table if exists test_questiontype;

drop table if exists user;

drop table if exists user_role_course;

drop table if exists user_test;

CREATE TABLE source
(
    source_id           nvarchar(255),

    source_name         nvarchar(255),

    source_type         nvarchar(255),

    source_upload_time  NVARCHAR(255),

    source_path         date,

    course_id           nvarchar(255),

    uid                  NVARCHAR(255),
    PRIMARY key(source_id)
);

/*==============================================================*/
/* Table: adult_children                                        */
/*==============================================================*/
create table adult_children
(
   adult_id             nvarchar(255) not null,
   student_id           nvarchar(255) not null,
   primary key (adult_id, student_id)
);

alter table adult_children comment '家长关联学生表：';

/*==============================================================*/
/* Table: adult_news                                            */
/*==============================================================*/
create table adult_news
(
   use_uid              nvarchar(255) not null,
   new_news_id          nvarchar(255) not null,
   adult_news_reply     date,
   primary key (use_uid, new_news_id)
);

alter table adult_news comment '家长消息管理表
家长回复时间：adult_news_reply';

/*==============================================================*/
/* Table: answerquestion                                        */
/*==============================================================*/
create table answerquestion
(
   aq_id                nvarchar(255) not null,
   que_qid              nvarchar(255),
   aq_text              nvarchar(255),
   aq_answer            nvarchar(255),
   aq_konw              nvarchar(255),
   aq_level             nvarchar(255),
   primary key (aq_id)
);

alter table answerquestion comment '简答题
id : aq_id
题目：aq_text
答案：aq_answer
                                   -&';

/*==============================================================*/
/* Table: assitant_news                                         */
/*==============================================================*/
create table assitant_news
(
   use_uid              nvarchar(255) not null,
   new_news_id          nvarchar(255) not null,
   assitant_news_begin  date,
   primary key (use_uid, new_news_id)
);

alter table assitant_news comment '教师/助教-消息管理表
发布问卷时间：assitant_news_begin
';

/*==============================================================*/
/* Table: codequestion                                          */
/*==============================================================*/
create table codequestion
(
   code_id              nvarchar(255) not null,
   que_qid              nvarchar(255),
   code_text            nvarchar(255),
   code_answer          nvarchar(255),
   code_know            nvarchar(255),
   code_level           nvarchar(255),
   primary key (code_id)
);

alter table codequestion comment '代码题
id: code_id
题目：code_text
答案：code_answe';

/*==============================================================*/
/* Table: completion                                            */
/*==============================================================*/
create table completion
(
   completion_id        nvarchar(255) not null,
   que_qid              nvarchar(255),
   completion_text      nvarchar(255),
   completion_A         nvarchar(255),
   completion_B         nvarchar(255),
   completion_C         nvarchar(255),
   completion_D         nvarchar(255),
   completion_E         nvarchar(255),
   completion_F         nvarchar(255),
   completion_answer    nvarchar(255),
   completion_kwon      nvarchar(255),
   completion_level     nvarchar(255),
   primary key (completion_id)
);

alter table completion comment '填空题
id: completion_id
题目：completion_text
问';

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   course_id            nvarchar(255) not null,
   use_uid              nvarchar(255),
   que_qsid             nvarchar(255),
   cname                nvarchar(30),
   cintroduce           nvarchar(255),
   code                 nvarchar(6),
   cstate               int,
   cyear                nvarchar(255),
   primary key (course_id)
);

alter table course comment '课程id:course_id
课程名称：course_name
课程介绍：course_intr';

/*==============================================================*/
/* Table: enclosure                                             */
/*==============================================================*/
create table enclosure
(
   enclosure_id         nvarchar(255) not null,
   hom_homework_id      nvarchar(255),
   enclosure_name       nvarchar(30),
   enclosure_type       nvarchar(10),
   enclosure_path       nvarchar(255),
   enclosure_time       nvarchar(255),
   primary key (enclosure_id)
);

alter table enclosure comment '附件
附件id:enclosure_id
附件名称：enclosure_name
附';

/*==============================================================*/
/* Table: homework                                              */
/*==============================================================*/
create table homework
(
   homework_id          nvarchar(255) not null,
   cou_course_id        nvarchar(255),
   homework_name        nvarchar(30),
   homework_content     nvarchar(255),
   homework_begin       date,
   primary key (homework_id)
);

alter table homework comment '作业表
作业id:homework_id
作业名：homework_name
作业内';

/*==============================================================*/
/* Table: morechoice                                            */
/*==============================================================*/
create table morechoice
(
   more_id              nvarchar(255) not null,
   que_qid              nvarchar(255),
   more_text            nvarchar(255),
   more_A               nvarchar(255),
   more_B               nvarchar(255),
   more_C               nvarchar(255),
   more_D               nvarchar(255),
   more_E               nvarchar(255),
   more_F               nvarchar(255),
   more_answer          nvarchar(255),
   more_know            nvarchar(255),
   more_level           nvarchar(255),
   primary key (more_id)
);

alter table morechoice comment '多选题
多选题id：more_id
多选题题目：more_text
选项：more_';

/*==============================================================*/
/* Table: news_bank                                             */
/*==============================================================*/
create table news_bank
(
   news_id              nvarchar(255) not null,
   news_title           nvarchar(255),
   news_begin           date,
   primary key (news_id)
);

alter table news_bank comment '消息
消息id: news_id
问卷标题：news_title
';

/*==============================================================*/
/* Table: onechoice                                             */
/*==============================================================*/
create table onechoice
(
   one_id               nvarchar(255) not null,
   que_qid              nvarchar(255),
   one_text             nvarchar(255),
   one_A                nvarchar(255),
   one_B                nvarchar(255),
   one_C                nvarchar(255),
   one_D                nvarchar(255),
   one_E                nvarchar(255),
   one_F                nvarchar(255),
   one_answer           nvarchar(255),
   one_parse            nvarchar(255),
   one_level            nvarchar(255),
   primary key (one_id)
);

alter table onechoice comment '单选题
题号：one_id

题目：one_text
选项 ：one_A';

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   pid                  nvarchar(255) not null,
   role_name          nvarchar(255),
   permission           nvarchar(255),
   primary key (pid)
);



/*==============================================================*/
/* Table: source_questiontype                            */
/*==============================================================*/
create table source_questiontype
(
   que_qid              nvarchar(255) not null,
   que_qsid             nvarchar(255) not null,
   primary key (que_qid, que_qsid)
);

alter table source_questiontype comment '题库与题的关系';

/*==============================================================*/
/* Table: questiontype                                          */
/*==============================================================*/
create table questiontype
(
   qid                  nvarchar(255) not null,
   new_news_id          nvarchar(255),
   qtype                nvarchar(255),
   primary key (qid)
);

alter table questiontype comment '题
题号id:qid
题类型：qtype


';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              nvarchar(255) not null,
   role_name            nvarchar(255),
   primary key (role_id)
);

/*==============================================================*/
/* Table: student_reply                                         */
/*==============================================================*/
create table student_reply
(
   tes_test_id          nvarchar(255) not null,
   que_qid              nvarchar(255) not null,
   use_uid              nvarchar(255) not null,
   reply                nvarchar(255),
   primary key (tes_test_id, que_qid, use_uid)
);

alter table student_reply comment '学生答题情况
1. 回答：reply';

/*==============================================================*/
/* Table: test                                                  */
/*==============================================================*/
create table test
(
   test_id              nvarchar(255) not null,
   cou_course_id        nvarchar(255),
   test_name            nvarchar(255),
   test_time            date,
   test_begin           date,
   test_end             date,
   primary key (test_id)
);

alter table test comment '测试id：test_id
测试名：test_name
测试时间：test_time
';

/*==============================================================*/
/* Table: test_questiontype                                     */
/*==============================================================*/
create table test_questiontype
(
   tes_test_id          nvarchar(255) not null,
   que_qid              nvarchar(255) not null,
   primary key (tes_test_id, que_qid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  nvarchar(255) not null,
   role_id          nvarchar(255),
   uname                nvarchar(20),
   utel                 nvarchar(11),
   ugender              nvarchar(2),
   upassword            nvarchar(255),
   uwenvarchart             nvarchar(255),
   primary key (uid)
);

alter table user comment '用户实体
1. ID:uid
2. 姓名：uname
3. 手机号：utel
                         -&';

/*==============================================================*/
/* Table: user_role_course                                      */
/*==============================================================*/
create table user_role_course
(
   role_name          nvarchar(255) not null,
   use_uid              nvarchar(255) not null,
   cou_course_id        nvarchar(255) not null,
   primary key (role_name, use_uid, cou_course_id)
);

alter table user_role_course comment '用户的课程角色';

/*==============================================================*/
/* Table: user_test                                             */
/*==============================================================*/
create table user_test
(
   use_uid              nvarchar(255) not null,
   tes_test_id          nvarchar(255) not null,
   ut_grade             int,
   ut_state             nvarchar(255),
   ut_begin             date,
   primary key (use_uid, tes_test_id)
);

alter table user_test comment '成绩：ut_grade
状态：ut_state
学生开始答题时间：ut_begin';

alter table adult_news add constraint FK_adult_news foreign key (use_uid)
      references user (uid) on delete cascade on update cascade;

alter table adult_news add constraint FK_adult_news2 foreign key (new_news_id)
      references news_bank (news_id) on delete cascade on update cascade;

alter table answerquestion add constraint FK_questiontype_answerquestion foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table assitant_news add constraint FK_assitant_news foreign key (use_uid)
      references user (uid) on delete cascade on update cascade;

alter table assitant_news add constraint FK_assitant_news2 foreign key (new_news_id)
      references news_bank (news_id) on delete cascade on update cascade;

alter table codequestion add constraint FK_questiontype_codequestion foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table completion add constraint FK_questiontype_completion foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table course add constraint FK_course_source foreign key (que_qsid)
      references source (source_id) on delete cascade on update cascade;

alter table course add constraint FK_course_user foreign key (use_uid)
      references user (uid) on delete cascade on update cascade;

alter table enclosure add constraint FK_homework_enclosure foreign key (hom_homework_id)
      references homework (homework_id) on delete cascade on update cascade;

alter table homework add constraint FK_course_homework foreign key (cou_course_id)
      references course (course_id) on delete cascade on update cascade;

alter table morechoice add constraint FK_question_morechoice foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table onechoice add constraint FK_questiontype_onechoice foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table permission add constraint FK_role_permission foreign key (role_name)
      references role (role_id) on delete cascade on update cascade;


alter table source_questiontype add constraint FK_source_questiontype foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table source_questiontype add constraint FK_source_questiontype2 foreign key (que_qsid)
      references source (source_id) on delete cascade on update cascade;

alter table questiontype add constraint FK_news_bank_questiontype foreign key (new_news_id)
      references news_bank (news_id) on delete cascade on update cascade;

alter table student_reply add constraint FK_student_reply foreign key (tes_test_id)
      references test (test_id) on delete cascade on update cascade;

alter table student_reply add constraint FK_student_reply2 foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table student_reply add constraint FK_student_reply3 foreign key (use_uid)
      references user (uid) on delete cascade on update cascade;

alter table test add constraint FK_course_test foreign key (cou_course_id)
      references course (course_id) on delete cascade on update cascade;

alter table test_questiontype add constraint FK_test_questiontype foreign key (tes_test_id)
      references test (test_id) on delete cascade on update cascade;

alter table test_questiontype add constraint FK_test_questiontype2 foreign key (que_qid)
      references questiontype (qid) on delete cascade on update cascade;

alter table user add constraint FK_user_role foreign key (role_id)
      references role (role_id) on delete cascade on update cascade;

alter table user_role_course add constraint FK_user_role_course foreign key (role_name)
      references role (role_id) on delete cascade on update cascade;

alter table user_role_course add constraint FK_user_role_course2 foreign key (use_uid)
      references user (uid) on delete cascade on update cascade;

alter table user_role_course add constraint FK_user_role_course3 foreign key (cou_course_id)
      references course (course_id) on delete cascade on update cascade;

alter table user_test add constraint FK_user_test foreign key (use_uid)
      references user (uid) on delete cascade on update cascade;

alter table user_test add constraint FK_user_test2 foreign key (tes_test_id)
      references test (test_id) on delete cascade on update cascade;

alter table source add constraint FK_source_course foreign key (course_id)
      references course (course_id) on delete cascade on update cascade;

   alter table source add constraint FK_source_user foreign key (uid)
      references user (uid) on delete cascade on update cascade;
