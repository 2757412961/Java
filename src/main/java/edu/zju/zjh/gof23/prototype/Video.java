package main.java.edu.zju.zjh.gof23.prototype;

import java.util.Date;


public class Video implements Cloneable {

    private String name;

    private Date date;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();

        // 实现深克隆！ 也可以用序列化和反序列化实现，但是消耗IO
        Video video = (Video) obj;
        video.date = (Date) this.date.clone();

        return obj;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public Video() {
        Video video = new Video();
    }

    public Video(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
