package competitorapp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtil {

    public static void writeObjectToFile(Object object) {
        try {
            FileOutputStream fos = new FileOutputStream("convert.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("io exception");
        }
    }

    public static Object readObjectFromFile() {
        FileInputStream fis;
        ObjectInputStream ois;
        Object obj;
        try {
            fis = new FileInputStream("convert.ser");
            ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            return obj;
        } catch (FileNotFoundException ex) {
            System.out.println("file not found!");
        } catch (IOException ex) {
            System.out.println("io error");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found");
        }
        return null;
        
    }

}
