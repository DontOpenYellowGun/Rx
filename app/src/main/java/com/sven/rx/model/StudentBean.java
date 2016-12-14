package com.sven.rx.model;

import java.util.List;

/**
 * Created by Sven on 2016/12/14.
 */

public class StudentBean {

    private String name;//学生姓名
    private List<Course> Courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> Courses) {
        this.Courses = Courses;
    }

    //学生修的科目
    public class Course {
        private String name;//科目名称
        private String mark;//科目分数

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }
    }
}
