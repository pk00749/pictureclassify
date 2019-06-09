public class Test_Class {
    public static void main(String[] args) {
        //在运行期间，如果我们要产生某个类的对象，java虚拟机会检测该类型的Class对象是否
        //已被加载。如果没有加载，java虚拟机会根据类的名称找到.class文件并加载它。
        //当new Point()的时候加载这个类，用forName构造实例的时候也加载该类。 只加载一次
        System.out.println("before new Point()");
        new Point();
        System.out.println("after new Point()");
        try {
            Class.forName("Line");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        // 利用对象调用getClass()方法获取该对象的Class实例
        Point pt = new Point();
        System.out.println(pt.getClass()); // 结果:class Point
        Class c1 = pt.getClass();
        System.out.println(c1.getClass()); // 结果:class java.lang.Class 返回引用运行时真正所指的对象所属的类的Class的对象
        System.out.println(c1.getName()); // 结果:Point 获得该类型的全称名称

        // 使用Class的静态方法forName()，用类的名字获取一个Class实例
        try {
            Class c2 = Class.forName("Point");
            System.out.println(c2.getName()); // 结果:Point
            Point pp = (Point) c2.newInstance(); //一旦某个类型的Class对象已经被加载到内存，就可以用它来产生该类型的所有对象。
            //newInstance()调用类中缺省的构造方法。
            pp.output(); // 结果: x=0,y=0
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        // 运用.class的方式获取Class实例(类)
        Class c3 = Point.class;
        System.out.println(c3.getClass()); // 结果:class java.lang.Class
        System.out.println(c3.getName()); // 结果:Point

        // 运用.class的方式获取Class实例(基本类型)
        Class c4 = int.class;
        System.out.println(c4.getClass()); // 结果:class java.lang.Class
        System.out.println(c4.getName()); // 结果:int

        // 运用.class的方式获取Class实例(基本数据类型的封装类)
        Class c5 = Integer.TYPE;
        System.out.println(c5.getName()); // 结果:int
        Class c6 = Integer.class;
        System.out.println(c6.getName()); // 结果:java.lang.Integer
    }
}

class Point {
    static {
        System.out.println("loading point");
    }

    void output() {
        System.out.println("x=" + x + ",y=" + y);
    }
    int x, y;
}

class Line {
    static {
        System.out.println("loading Line");
    }
}
