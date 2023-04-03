import java.io.*;


 /**
 * The class Serialize object
 */ 
public class SerializeObject {

/** 
 *
 * Serialize
 *
 * @param obj  the obj
 * @param filename  the filename
 */
    public static void serialize(Object obj, String filename) { 

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Object serialized into file " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
