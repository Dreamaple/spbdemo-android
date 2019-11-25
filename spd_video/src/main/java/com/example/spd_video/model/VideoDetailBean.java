package com.example.spd_video.model;

/**
 * @author dreamaple
 */
public class VideoDetailBean {
    public VideoDetailBean() {
    }

    public VideoDetailBean(String type, String title, String author, String category, String recommend, String cover) {
        this.type = type;
        this.title = title;
        this.author = author;
        this.category = category;
        this.recommend = recommend;
        this.cover = cover;
    }

    /**
     * 分类
     */
    private String type;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 分类（文章，动态）
     */
    private String category;

    /**
     * 推荐原因(已关注，关注的人赞过，多少投币，多少收藏等）
     */
    private String recommend;
    /**
     * 封面url
     */
    private String cover;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
