package main.java.edu.zju.zjh.lcold;

public class O064 {
    public int sumNums(int n) {
        Boolean falg = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int n = 9;

        System.out.println(new O064().sumNums(n));
    }
}
