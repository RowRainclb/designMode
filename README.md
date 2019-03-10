# 单例模式写法优缺点
[toc]

## 饿汉模式

实现代码：

```java
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();
    
    private HungrySingleton() {}
    
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
```
```java
package com.example.demo.singleton.hungry;

public class HungryStaticSingleton {
    private HungryStaticSingleton() {}
    public static final HungryStaticSingleton hungrySingleton ;
    static {
        hungrySingleton = new HungryStaticSingleton();
    }
    public static HungryStaticSingleton getInstance (){
        return hungrySingleton;
    }

}
```

#### 优点

 线程安全（类加载时就完成实例初始化）

#### 缺点

1. 若该实例没有被使用，则浪费内存空间
2. 可被反射攻击



## 简单懒汉模式

实现代码：

```java
public class LazySingleton {
    private static LazySingleton instance;
    
    private LazySingleton() {}
    
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

#### 优点

避免了饿汉模式的类加载慢和资源浪费

#### 缺点

1. 线程不安全
3. 可被发射攻击



## 线程安全懒汉模式

实现代码：

```java
public class LazySingleton {
    private static LazySingleton instance;
    
    private LazySingleton() {}
    
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

#### 优点

在简单懒汉模式基础上实现了线程安全

#### 缺点

1. synchronized 方法对整个类加锁，影响了其他类方法的调用
2. 增加了同步开销
3. 可被发射攻击



## 双重检查懒汉模式

实现代码：

```java
public class LazySingleton {
    private volatile static LazySingleton instance;
    
    private LazySingleton() {}
    
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized(LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
```

#### 优点

1. 在线程安全懒汉模式的基础上，缩小了锁粒度，减少了不必要的同步
2. volatile 关键词提高了正确性

#### 缺点

1. volatile 关键字会影响性能
2. 可被反射攻击



## 静态内部类懒汉模式

实现代码：

```java
public class LazySingleton {
    private LazySingleton() {}
    
    public static LazySingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static class InstanceHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
}
```

#### 优点

 兼顾饿汉式的内存浪费，也兼顾synchronized性能问题

#### 缺点

1. 可被反射攻击



---

应对反射攻击的方法：

在私有构造方法中抛出异常

```java
private Singleton() {
    if (INSTANCE != null) {
        throw new Exception("Not allowed!");
     }
}
```



以上的饿汉模式和懒汉模式，若类实现了 `Serializable` 接口，则都可以被序列化攻击，创建出多个实例。

应对序列化攻击的方法：
可以在类中添加 `readResolve` 方法，用全局 instance 来覆盖反序列化时生成的对象实例，从而避免单例模式被破坏。

---



## 注册时单例模式

### 枚举单例模式

实现代码：

```java
public enum Singleton {
    INSTANCE;
    
    private Object data;
    public void setData(Object data) {
        this.data = data;
    }
    public Object getData() {
        return this.data;
    }
}
```

#### 优点

1. 线程安全
2. 在任何情况下都是单例
3. 在JDK层面避免了反射攻击和序列化攻击

#### 缺点

可读性不高



### 容器单例模式

实现代码：

```java
public class SingletonContext {
    private static Map<String, Object> instanceMap = new ConcurrentHashMap<String, Object>();
    
    private SingletonContext() {}
    
    public static Object getInstance(String className) {
        if (!instanceMap.containsKey(className)) {
            instanceMap.put(className, Class.forName(className).newInstance());
        }
        return instanceMap.get(className);
    }
}
```

### 优点

1. 统一管理单例类
2. 利用简单工厂模式创建单例对象
3. 提供统一接口获取单例对象，降低耦合度，Spring中的做法，就是用这种注册式单例

#### 缺点

1. 线程不安全，需要进行多线程同步优化
2. 利用反射机制创建实例



---



## ThreadLocal模式



```java
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
```



### 优点

1. 单线程内部可以保证单例

#### 缺点

1. 多线程情况下会创建多个实例
