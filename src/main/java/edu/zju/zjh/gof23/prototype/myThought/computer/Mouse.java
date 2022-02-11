package main.java.edu.zju.zjh.gof23.prototype.myThought.computer;

/**
 * @author: zjh
 * @date : 2021/4/13 14:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Mouse implements Cloneable {

    public String id;

    public String name;

    public int span;

    public Class clazz;

    public Mouse(String id, String name, int span, Class clazz) {
        this.id = id;
        this.name = name;
        this.span = span;
        this.clazz = clazz;
    }

    @Override
    public Mouse clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        Mouse mouse = (Mouse) clone;
        return mouse;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", span=" + span +
                ", clazz=" + clazz +
                '}';
    }
}
