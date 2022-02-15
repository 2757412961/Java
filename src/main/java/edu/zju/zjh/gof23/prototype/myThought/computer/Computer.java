package edu.zju.zjh.gof23.prototype.myThought.computer;

/**
 * @author: zjh
 * @date : 2021/4/13 14:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Computer implements Cloneable {

    private String id;

    private Screen screen;

    private Mouse mouse;

    public Computer(String id, Screen screen, Mouse mouse) {
        this.id = id;
        this.screen = screen;
        this.mouse = mouse;
    }

    @Override
    public Computer clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Computer computer = (Computer) obj;

        computer.screen = screen.clone();
        computer.mouse = mouse.clone();

        return computer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id='" + id + '\'' +
                ", screen=" + screen +
                ", mouse=" + mouse +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
