package demo;

public class finalDemo {
    private final int a = 6;
    private final String str;
    private final static boolean b;
    private final double c;
    private final char ch;

    {
        str = "初始化";
        ch = '1';
    }
    static {
        b = true;
        //非静态不能在静态初始块赋值
        //str = "xxx";
    }

    public finalDemo() {
        //实例变量可以在初始化块中赋值
        c = 1.0;
        //a已经赋值
        //a = 10;
    }

    public void a() {
        //实例方法不能为final类型变量赋值
        //ch = 'a';
    }


}
