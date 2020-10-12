package les7;

public class ToTesting {
    static String name;
    static int a1;
    static int a2;

    @Test
    @BeforeSuite
    public static void init() {
        name = "my Lord";
        a1 = 0;
        a2 = 1;
    }

    @Test(priority = 7)
    public static void greeting() {
        System.out.println("Hello, " + name);
    }

    @Test(priority = 3)
    private static void printFibonacci() {
        int a1 = 0;
        int a2 = 1;
        System.out.printf("%d %d ", a1, a2);
        for(int i = 0; i<10; i++) {
            System.out.print(a1 + a2 + " ");
            a2 += a1;
            a1 = a2 - a1;
        }
        System.out.println();
    }

    @Test (priority = 3)
    public static void meth1() {
        System.out.println("method 1");
    }

    @Test (priority = 10)
    public static void meth2() {
        System.out.println("method 2");
    }

    @Test
    public static void meth3() {
        System.out.println("method 3");
    }

    @Test
    public static void meth4() {
        System.out.println("method 4");
    }

    @Test
    @AfterSuite
    public static void goodbye() {
        System.out.println("Goodbye, " + name);
    }
}
