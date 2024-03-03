package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author Administrator
 */
public class SerializationManagement {
    private static final String FILE_FORMAT = "C:\\Serialized\\%1$s.dat";

    public void serialize(String dataIdentifier, Object dataObject) {
        System.out.printf("Started serialization to file: %s%n", dataIdentifier);
        try (FileOutputStream file = new FileOutputStream(String.format(FILE_FORMAT, dataIdentifier));
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

    public <T> List<T> deserialize(String dataIdentifier, Class<T> objectClass) {
        System.out.printf("Started deserialization from file: %s%n", dataIdentifier);
        Object result = null;
        try (FileInputStream file = new FileInputStream(String.format(FILE_FORMAT, dataIdentifier));
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
        return castObject(objectClass, result);
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> castObject(Class<T> clazz, Object object) {
        return (List<T>) object;
    }
}
