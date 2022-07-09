package edu.zju.zjh.core.extend;

/**
 * @author: zjh
 * @date : 2022/5/25 14:55
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Child extends Father {

    /**
     * java中只要调用子类的构造函数就要调用父类无参数的构造函数吗？若父类中不存在无参数构造函数会出错吗?
     * <p>
     * 答：Java中只要调用子类的构造函数就一定会调用父类的构造函数，这是毋庸置疑的！
     * 有时我们并没有在父类中写有参和无参的构造方法，但是这样我们在定义子类对象时调用子类构造函数时，其实也调用父类的构造函数，
     * 这是系统自动为我们添加的“public Father(){}”。但是如果我们在父类中已经自己定义了有参的构造方法，却没有定义无参的构造方法，
     * 那么此时系统是不会为我们自动添加无参的构造方法的，此时程序结果就会提醒你父类没有无参的构造方法，程序就会报错。
     */

    public int varC;
    public static int varS;
    // 其他类访问不了
    private static int pS;

    public Child() {
        /**
         * 如果我们在父类中已经自己定义了有参的构造方法，却没有定义无参的构造方法，
         * 那么此时系统是不会为我们自动添加无参的构造方法的，此时程序结果就会提醒你父类没有无参的构造方法，程序就会报错。
         */
    }

    public Child(int father) {
        super(father);
        int a = super.varF;
    }

    public static void zjuLoveLemon(int localC) {
        varS = localC;
    }

    public void zjhLoveLemon(int localC, int localF) {
        /**
         * 为什么静态成员、静态方法中不能用this和super关键字
         * 1.super的用法跟this类似，this代表对本类对象的引用，指向本类已经创建的对象；而super代表对父类对象的引用，指向父类对象；
         * 2.静态优先于对象存在；
         * 3.由上面的1.和2.知：因为静态优先于对象存在，所以方法被静态修饰之后方法先存在，而方法里面要用到super指向的父类对象，
         *   但是所需的父类引用对象晚于该方法出现，也就是super所指向的对象没有，当然就会出错。
         */
        this.varC = localC;
        super.varF = localF;
    }

}
