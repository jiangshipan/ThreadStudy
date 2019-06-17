package demo;

import java.lang.ref.WeakReference;

/**
 * 弱引用: 被弱引用关联的对象只能存活到下一次垃圾回收前,当gc发生时,无论内存是否可用,都会被回收
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        WeakReference<String> str = new WeakReference<>(new String("i am here"));
        System.out.println(str.get());
        //手动gc
        System.gc();
        System.out.println(str.get());
    }
}
