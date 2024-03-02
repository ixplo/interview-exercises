package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Administrator
 */
public class SerializationManagement
{
    static String fileFormat = "C:\\Serialized\\%1$s.dat";
    
    public void Serialize(String dataIdentifier, Object dataObject) throws FileNotFoundException, IOException
    {
        FileOutputStream file = new FileOutputStream(String.format(fileFormat, dataIdentifier));
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(dataObject);
    }
    
    public Object Deserialize(String dataIdentifier) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream file = new FileInputStream(String.format(fileFormat, dataIdentifier));
        ObjectInputStream in = new ObjectInputStream(file);
        return in.readObject();
    }
}
