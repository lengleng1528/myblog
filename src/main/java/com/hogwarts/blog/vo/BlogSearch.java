package com.hogwarts.blog.vo;


public class BlogSearch {
    private String title;
    private Long typeId;
    private boolean recommend;

    public BlogSearch() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "BlogSearch{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", recommend=" + recommend +
                '}';
    }
}
