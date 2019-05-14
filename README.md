
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

```markdown

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
## chapter2

### synchronized方法

#### 方法内的变量为线程安全

#### 实例变量非线程安全

可以通过添加关键词synchronized来保证线程安全。

#### synchronized方法与锁对象

1. A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object对象中的非synchronized类型的方法
2. A线程先持有object对象的Lock锁，B线程如果在这段时间调用object对象中的synchronized类型的方法则需要等待，也就是同步。

#### synchronized 锁重入

关键词synchronized拥有锁重复的功能，也就是在是用synchronized时，当一个线程得到一个对象锁后，再次请求此对象锁时是可以再次得到该对象的锁的。这也证明在一个synchronized方法/块内部调用贝类的其他synchronized方法/块时，是永远可以得到锁的。

#### 当出现异常时，锁自动释放

当一个线程执行的代码出现异常时，起所持有的锁会自动释放。

#### 同步不具有继承性

### synchronized同步块

synchronized方法是对当前对象进行加锁，而synchronized代码块是对某一个对象进行加锁

当一个线程访问object的一个synchronized同步代码块时，另一个线程仍然可以访问该object对象中的非synchronized同步代码块。

在使用同步synchronized（this）代码块时需要注意的是，当一个线程访问object的一个synchronized（this）同步代码块时，其他线程对同一个object中所有其他synchronized（this）同步代码块的访问将被阻塞，这说明synchronized使用的"对象监视器"是一个

和synchronized方法一样，synchronized(this)代码块也是锁定当前对象的。



synchronized同步方法和synchronized(this)同步代码块分别有两种作用

- synchronized同步方法
  - 对其他synchronized同步方法或synchronized(this)同步代码块调用呈阻塞状态
  - 同一时间只有一个线程可以执行synchronized同步方法中的代码
- synchronized(this)同步代码块
  - 对其他synchronized同步方法或synchronized(this)同步代码块调用呈阻塞状态
  - 同一时间只有一个线程可以执行synchronized(this)同步代码块中的代码



#### 同步代码块使用非this对象做对象监视器

同步代码块可以使用其他的实例变量或方法的参数，来作为对象监视器使用格式synchroinzed(非this对象)

1. 在多个线程持有"对象监视器"为同一个对象的前提下，同一时间只有一个线程可以执行synchroinzed(非this对象 x)同步代码块中的代码
2. 当持有"对象监视器"为同一个对象的前提下，同一时间只有一个线程可以执行synchronized(非this对象 x)同步代码块中的代码

锁非this对象具有一定的优点：如果在一个类中有很多个synchronized方法，这是虽然能实现同步，但会收到阻塞，所以影响运行效率；但如果使用同步代码块锁非this对象，则synchronized(非this)代码块中的程序与同步方法是异步的，不与其他锁this同步方法争抢this锁，则可以提高运行效率。



当x对象本身作为“对象监视器”时：

1. 当多个线程同时执行synchronized(x){}同步代码块时呈同步效果
2. 当其他线程执行x对象中synchronized同步方法时呈同步效果
3. 当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果
4. 如果其他线程调用不加synchronized关键字的方法时，还是异步调用



#### 线程池常量做“对象监视器”

由于线程池常量是唯一，所以如果以此来作为锁的话，那么多个线程就会阻塞。



#### 同步synchronized方法无限等待和解决

使用同步方法容易死循环，原因是因为锁的是同一个对象，所以造成死锁，而使用同步代码块，就可以使用不同的锁对象，从而解决该问题。



### volatile

使用volatile关键字增加了实例变量在多个线程之间的可见性，但volatile关键词的缺点是不支持原子性。

#### synchronized和volatile比较

1. 关键字volatie是线程同步的轻量级实现，所以volatile性能肯定比synchronized要好，并且volatile智能修饰于变量，而synchronized可以修饰方法，以及代码块。但随着者JDK新版本的发布，synchronized关键字在执行效率上得到提升。
2. 多线程访问volatile不会发生阻塞，而synchronized会出现阻塞
3. volatile能保证数据的可见性，但不能保证原子性；而synchronized可以保证原子性，也可以间接保证可见性，因为它会将私有内存和公共内存中的数据做同步
4. volatile解决的事变量在多个线程之间的可见性；而synchronized解决的事多个线程之间访问资源的同步性。

#### volatile的非原子性

变量在内存中工作的过程

![](pic/volatile_in_mem.png)

1. read和load阶段：从主存复制到到当前线程工作内存；
2. use和assign阶段：执行代码，改变恭喜那个变量值；
3. store和write阶段：用工作内存数据刷新主存对应变量的值

对于volatile修饰的变量，JVM虚拟机只是保证从主内存加载到线程工作内存的值事最新的，例如线程1和线程2在进行read和load的操作，发现主内存中count的值都是5，那么都会加载这个最新的值。也就是说，volatile关键字解决的是读时的可见性问题，但无法保证原子性，对于多个线程访问同一个实例变量还是需要加锁同步。

关键字synchronized可以保证在同一时刻，只有一个线程可以执行某一方法或某一个代码块。它包含连个特征：互斥性和可见性。同步synchronized不经可以解决一个线程看到对象处于不一致的状态，还可以保证进入同步方法或者同步代码块的每个线程，都卡拿到由同一个锁保护之前所有的修改效果

