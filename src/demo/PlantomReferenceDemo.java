package demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * 无法通过虚引用获取一个对象的实例
 * 作用: 这个对象被收集器回收时候可以收到一个系统通知,实现追踪垃圾收集器的回收动作
 * 比如在对象被回收的时候,调用finalize方法
 */
public class PlantomReferenceDemo {

    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<String> phantomReference = new PhantomReference<>(new String("I am here"), referenceQueue);
        //一直返回null, PhantomReference的get必定为null
        System.out.println("phantomReference.get() = " + phantomReference.get());
        System.gc();
        Reference<?> reference;
        while((reference = referenceQueue.poll()) != null) {
            if (reference == phantomReference) {
                System.out.println("被回收了");
            }
        }
    }
}
