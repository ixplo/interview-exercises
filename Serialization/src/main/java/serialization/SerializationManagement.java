package serialization;

import java.io.File;
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
    private static final String DEFAULT_FILE_FORMAT = "C:/Serialized/%1$s.dat".replace("/", File.separator);
    private final String fileFormat;

    public SerializationManagement() {
        this(DEFAULT_FILE_FORMAT);
    }

    public SerializationManagement(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void serialize(String dataIdentifier, Object dataObject) {
        System.out.printf("Started serialization to file: %s%n", dataIdentifier);
        try (FileOutputStream file = new FileOutputStream(String.format(fileFormat, dataIdentifier));
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(dataObject);
            System.out.println("Serialization finished successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("Serialization failed with FileNotFoundException: %s", e.fillInStackTrace());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Serialization failed with IOException: %s", e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Serialization failed with unexpected exception: %s", e);
        }
    }

    public <T> T deserialize(String dataIdentifier, Class<T> objectClass) {
        Object deserialized = deserialize(dataIdentifier);
        return castObject(deserialized, objectClass);
    }

    public <T> List<T> deserializeList(String dataIdentifier, Class<T> objectClass) {
        Object deserialized = deserialize(dataIdentifier);
        return castListOfObjects(deserialized, objectClass);
    }

    public Object deserialize(String dataIdentifier) {
        System.out.printf("Started deserialization from file: %s%n", dataIdentifier);
        Object result = null;
        try (FileInputStream file = new FileInputStream(String.format(fileFormat, dataIdentifier));
             ObjectInputStream in = new ObjectInputStream(file)) {
            result = in.readObject();
            System.out.println("Deserialization finished successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("Deserialization failed with FileNotFoundException: %s", e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Deserialization failed with IOException: %s", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.printf("Deserialization failed with ClassNotFoundException: %s", e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Deserialization failed with unexpected exception: %s", e);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private <T> T castObject(Object object, Class<T> clazz) {
        return (T) object;
    }
    @SuppressWarnings("unchecked")
    private <T> List<T> castListOfObjects(Object object, Class<T> clazz) {
        return (List<T>) object;
    }
}
