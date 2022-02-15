package edu.zju.zjh.gof23.prototype.myThought;


import edu.zju.zjh.gof23.prototype.myThought.computer.Computer;
import edu.zju.zjh.gof23.prototype.myThought.computer.Mouse;
import edu.zju.zjh.gof23.prototype.myThought.computer.Screen;

/**
 * @author: zjh
 * @date : 2021/4/13 15:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class TestExtendClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        /** ----------------------------------- **/
        System.out.println("------------------ Screen -----------------");
        Screen s1 = new Screen("1", "screen1", 3);
        System.out.println(s1);

        Screen s2 = s1.clone();
        s2.id = "2";
        s2.name = "screen2";
        s2.span = 5;

        System.out.println(s1);
        System.out.println(s2);

        /** ----------------------------------- **/
        System.out.println("------------------ Mouse -----------------");
        Mouse m1 = new Mouse("1", "mouse1", 1, Long.class);
        System.out.println(m1);

        Mouse m2 = ((Mouse) m1.clone());
        m2.id = "2";
        m2.name = "mouse2";
        m2.span = 2;
        m2.clazz = Double.class;
        System.out.println(m1);
        System.out.println(m2);

        /** ----------------------------------- **/
        System.out.println("------------------ Computer -----------------");
        Computer c1 = new Computer("1", s1, m1);
        System.out.println(c1);

        Computer c2 = c1.clone();
        c2.getMouse().name = "1sadasfasd";
        c2.getMouse().span = 21;
        c2.getScreen().name = "asda";
        c2.getScreen().span = 31;
        System.out.println(c1);
        System.out.println(c2);
    }

}
