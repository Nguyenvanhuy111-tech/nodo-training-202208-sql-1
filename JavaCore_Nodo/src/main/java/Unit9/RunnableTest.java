package Unit9;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable1();
        Runnable2();
        Runnable3();
    }

    public static void Runnable1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Say hello Java class");
            }
        };
        new Thread(runnable).start();
    }

    public static void Runnable2() {
        new Thread(() ->
                System.out.println(Thread.currentThread().getName() + " Say hello Java Class")
        ).start();
    }

    public static void Runnable3() {
        new Thread(() ->
        {
            System.out.println(Thread.currentThread().getName() + " Say hello Java Class");
            System.out.println("1 + 1 = " + (1 + 1));
        }
        ).start();
    }
}
