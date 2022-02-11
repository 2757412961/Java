package main.java.edu.zju.zjh.gof23.prototype.myThought.computer;

/**
 * @author: zjh
 * @date : 2021/4/13 14:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Screen implements Cloneable {

    public String id;

    public String name;

    public int span;

    public Screen(String id, String name, int span) {
        this.id = id;
        this.name = name;
        this.span = span;
    }

    @Override
    public Screen clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Screen screen = (Screen) obj;
        screen.id = new String(id);
        screen.name = new String(name);

        return screen;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", span=" + span +
                '}';
    }
}
