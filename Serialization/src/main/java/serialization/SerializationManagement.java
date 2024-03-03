package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Administrator
 */
public class SerializationManagement {
    static String fileFormat = "C:\\Serialized\\%1$s.dat";

    public void Serialize(String dataIdentifier, Object dataObject) {
        System.out.printf("Started serialization to file: %s%n", dataIdentifier);
        try (FileOutputStream file = new FileOutputStream(String.format(fileFormat, dataIdentifier));
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(dataObject);
            System.out.println("Serialization finished successfully.");
        } catch (FileNotFoundException e) {
            System.out.printf("Serialization failed with FileNotFoundException: %s", e);
        } catch (IOException e) {
            System.out.printf("Serialization failed with IOException: %s", e);
        } catch (Exception e) {
            System.out.printf("Serialization failed with unexpected exception: %s", e);
        }
    }

    public Object Deserialize(String dataIdentifier) {
        System.out.printf("Started deserialization from file: %s%n", dataIdentifier);
        Object result = null;
        try (FileInputStream file = new FileInputStream(String.format(fileFormat, dataIdentifier));
             ObjectInputStream in = new ObjectInputStream(file)) {
            result = in.readObject();
            System.out.println("Deserialization finished successfully.");
        } catch (FileNotFoundException e) {
            System.out.printf("Deserialization failed with FileNotFoundException: %s", e);
        } catch (IOException e) {
            System.out.printf("Deserialization failed with IOException: %s", e);
        } catch (ClassNotFoundException e) {
            System.out.printf("Deserialization failed with ClassNotFoundException: %s", e);
        } catch (Exception e) {
            System.out.printf("Deserialization failed with unexpected exception: %s", e);
        }
        return result;
    }
}
