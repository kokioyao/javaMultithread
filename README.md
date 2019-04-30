
## 《Java多线程编程核心技术》读书笔记

### interrupted和isInterrupted的区别

this.interrupted()：测试当前线程是否已经中断

this.isInterrupted()：测试线程是否已经中断


```java
/**
 * @author kokio
 * @create 2019-04-28 18:23
 */
public class Run8 {
    public static void main(String[] args) {
        try {
            MyThread7 t7 = new MyThread7();
            t7.start();
            Thread.sleep(1000);
            t7.interrupt();
            System.out.println("是否停止1? " + Thread.interrupted());
            System.out.println("是否停止2? " + t7.interrupted());

        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

```


测试结果

```markdown
。
。
。
i= 50000
是否停止1? false
是否停止2? false
end
```

由于停止的并非是当前main线程，所以interrupted()方法返回的都是false。

当当前线程被中断时

```java
/**
 * @author kokio
 * @create 2019-04-28 18:39
 */
public class Run8two {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止？ " + Thread.interrupted());
        System.out.println("是否停止？ " + Thread.interrupted());
        System.out.println("end");
    }
}

```

结果

```markdown
是否停止？ true
是否停止？ false
end
```

而至于为什么第二个返回是false，是因为interrupted方法具有清除的功能，当第一次使用之后，将中断状态清除了，那么紧接着第二次调用就无法判断了，所以返回false。

使用isInterrupted()方法

```java

/**
 * @author kokio
 * @create 2019-04-28 19:08
 */
public class Run8Three {
    public static void main(String[] args) {
        try {
            MyThread7 myThread = new MyThread7();
            myThread.start();
            Thread.sleep(100);
            myThread.interrupt();

            System.out.println("是否中断1 " + myThread.isInterrupted());
            System.out.println("是否中断2 " + myThread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();

        }
        System.out.println("main end");

    }
}
```

结果

```java

i= 17785
是否中断1 true
i= 17786
i= 17787
是否中断2 true
main end
i= 17788
```

可以看到两次返回都为true，isInterrupted方法不具备清除标记的能力，所以一直为true。

### 线程的优先级

#### 线程的优先级继承性

在Java中，线程的优先级具有继承性，比如A线程启动B线程，则B线程的优先级与A是一样的。

```java
/**
 * @author kokio
 * @create 2019-04-30 18:36
 */
public class MyThread13 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread13 run priority = " + this.getPriority());
        MyThread14 myThread14 = new MyThread14();
        myThread14.start();
    }
}


/**
 * @author kokio
 * @create 2019-04-30 18:39
 */
public class MyThread14 extends Thread {
    @Override
    public void run() {

        System.out.println("MyThread14 run priority = " + this.getPriority());

    }
}


/**
 * @author kokio
 * @create 2019-04-30 18:39
 */
public class Run1314 {
    public static void main(String[] args) {
        System.out.println("main thread begin priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(9);
        System.out.println("main thread end priority = " + Thread.currentThread().getPriority());
        MyThread13 myThread13 = new MyThread13();
        myThread13.start();
    }
}
```

结果

```markdo
main thread begin priority = 5
main thread end priority = 9
MyThread13 run priority = 9
MyThread14 run priority = 9
```

#### 优先级具有规则性

cpu尽量将执行资源让给优先级比较高的线程

#### 优先级具有随机性

优先级较高的线程并不一定每一次都先执行完run（）方法中的任务，线程优先级与打印顺序无关，他们的关系具有不确定性和随机性



### 守护线程

当线程中不存在非守护线程了，则守护线程自动销毁。典型的守护线程就是垃圾回收线程。

```java

/**
 * @author kokio
 * @create 2019-04-30 18:58
 */
public class MyThread15 extends  Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}



/**
 * @author kokio
 * @create 2019-04-30 19:00
 */
public class Run15 {
    public static void main(String[] args) {
        try {
            MyThread15 myThread15 = new MyThread15();
            myThread15.setDaemon(true);
            myThread15.start();
            Thread.sleep(5000);
            System.out.println("主线程没了，thread也不打印");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

```

结果

```markdown
i=1
i=2
i=3
i=4
i=5
主线程没了，thread也不打印
```


