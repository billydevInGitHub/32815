package exp005.load.and.run.methods;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class MyClass {

    public MyClass(){

    }

    public void sayHello() {
        System.out.println("Hello world from the loaded class !!!");
    }

}


class JavaClassLoader extends ClassLoader {

    public void invokeClassMethod(String classBinName, String methodName){

        try {

            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // Load the target class using its binary name
            Class loadedMyClass = classLoader.loadClass(classBinName);

            System.out.println("Loaded class name: " + loadedMyClass.getName());

            // Create a new instance from the loaded class
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();

            // Getting the target method from the loaded class and invoke it using its name
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


public class ClassLoaderTest {
    public static void main(String[] args) {
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        javaClassLoader.invokeClassMethod("exp005.load.and.run.methods.MyClass", "sayHello");

    }
}
