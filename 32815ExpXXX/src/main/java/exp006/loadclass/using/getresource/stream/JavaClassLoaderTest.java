package exp006.loadclass.using.getresource.stream;

import java.io.InputStream;




public class JavaClassLoaderTest extends ClassLoader {

    public static void main(String args[]) throws Exception {
        JavaClassLoaderTest javaClassLoader = new JavaClassLoaderTest();
        javaClassLoader.load();

    }

    public void load() throws Exception {

        // create FileInputStream object
//        InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream("C:\\Billydev080107\\MyBLIBBPOTCode\\32815\\32815ExpXXX\\target\\classes\\exp006\\loadclass\\using\\getresource\\stream\\ClassLoaderInput.class");
//        InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream("ClassLoaderInput.class");
        InputStream fileInputStream = this.getClass().getResourceAsStream("ClassLoaderInput.class");
        /*
         * Create byte array large enough to hold the content of the file. Use
         * fileInputStream.available() to determine size of the file in bytes.
         */
        byte rawBytes[] = new byte[fileInputStream.available()];

        /*
         * To read content of the file in byte array, use int read(byte[]
         * byteArray) method of java FileInputStream class.
         */
        fileInputStream.read(rawBytes);

        // Load the target class
        Class<?> regeneratedClass = this.defineClass(null, rawBytes, 0, rawBytes.length);

        // Getting a method from the loaded class and invoke it
        regeneratedClass.getMethod("printString", null).invoke(regeneratedClass.getConstructor().newInstance(), null);
    }

}