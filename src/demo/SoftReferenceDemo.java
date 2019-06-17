package demo;

import java.lang.ref.SoftReference;

/**
 * 软引用, 内存不够的情况下会把软引用关联的对象列入垃圾回收范围,然后进行回收
 *
 * 日常使用: 软引用可以保存从数据库中取出的数据,放软引用集合中,可以避免内存溢出
 *
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        int count = 5;
        SoftReference[] softReference = new SoftReference[count];
        for (int i = 0; i < count; i++) {
            softReference[i] = new SoftReference<TestObject>(new TestObject("TestObject" + i));
        }
        //打印出softReference中所有对象
        for (int i = 0; i < count; i++) {
            Object o = softReference[i].get();
            if (o == null) {
                System.out.println("null");
            } else {
                System.out.println(((TestObject)o).name);
            }
        }
    }


}
//定义一个大对象,目的让内存满
class TestObject {
    public byte[] values;
    public String name;

    public TestObject(String name) {
        this.name = name;
        values = new byte[1024 * 1024 * 500];
    }
}
