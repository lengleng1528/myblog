package com.hogwarts.blog.vo;


public class ParentComment {
    private Long pid;
    private String pname;

    public ParentComment() {
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
