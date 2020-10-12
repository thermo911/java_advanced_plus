package les7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class TestUnit {

    public static void startTest(Class c) throws InvocationTargetException, IllegalAccessException {
        if(!checkBeforeAfterAnnos(c.getDeclaredMethods())) {
            throw new RuntimeException("Incorrect @BeforeSuite or @AfterSuite methods annotations");
        }

        ArrayList<Method> methodList = new ArrayList<>();
        Method before = null;
        Method after = null;

        for (Method m : c.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Test.class)) {
                if(Modifier.isPrivate(m.getModifiers())) {
                    m.setAccessible(true);
                }
                if(m.isAnnotationPresent(AfterSuite.class)){
                    after = m;
                } else if(m.isAnnotationPresent(BeforeSuite.class)) {
                    before = m;
                } else {
                    methodList.add(m);
                }
            }
        }

        if(before != null) {
            System.out.println("Invoked @Before method: " + before.getName());
            before.invoke(null);
        }

        setInOrder(methodList);

        for(Method m: methodList) {
            System.out.println("Invoked method: " + m.getName());
            m.invoke(null);
        }

        if(after != null) {
            System.out.println("Invoked @After method: " + after.getName());
            after.invoke(null);
        }

    }

    public static void startTest(String className) throws ClassNotFoundException {
        try {
            startTest(Class.forName(className));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkBeforeAfterAnnos(Method[] methods) {
        int numBefores = 0;
        int numAfters = 0;

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                numBefores++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                numAfters++;
            }
        }

        return (numBefores<=1) && (numAfters<=1);
    }

    private static void setInOrder(ArrayList<Method> list) {
        for(int i = 1; i<list.size(); i++) {
            Method temp = list.get(i);
            int j = i-1;
            while(j>=0 && list.get(j+1).getAnnotation(Test.class).priority()
                    > list.get(j).getAnnotation(Test.class).priority()) {
                list.set(j+1, list.get(j));
                list.set(j, temp);
                j--;
            }
        }
    }
}
