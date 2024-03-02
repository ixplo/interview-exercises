package exercises;

import exercises.data.DataObject1;
import exercises.data.DataObject2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import serialization.SerializationManagement;

/**
 *
 * @author Administrator
 */
public class TestApplication
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        Scanner console = new Scanner(System.in);
        simpleSerializationTest();
        console.nextLine();
    }

    private static void simpleSerializationTest() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        SerializationManagement sm = new SerializationManagement();
        ArrayList<DataObject1> dataObjects = new ArrayList<>();
        
        for (int x = 0; x < 100; x++)
        {
            DataObject1 do1 = new DataObject1();
            dataObjects.add(do1);
            do1.setProperty1(String.valueOf(x));
            do1.setProperty2(x);
            do1.setComplexTypeProperty(new DataObject2());
            do1.getComplexTypeProperty().setSourceIdentifier("Serialized");
            do1.getComplexTypeProperty().setProperty1(String.valueOf(x));
            do1.getComplexTypeProperty().setProperty2(x);
        }
        
        sm.Serialize("TestData", dataObjects);
        dataObjects = null;
        dataObjects = (ArrayList)sm.Deserialize("TestData");
        
        for (int x = 0; x < 100; x++)
        {
            DataObject1 do1 = dataObjects.get(x);
            assert(do1.getProperty1().equals(String.valueOf(x)));
            assert(do1.getProperty2() == x);
            assert(do1.getComplexTypeProperty().getSourceIdentifier().equals("Serialized"));
            assert(do1.getComplexTypeProperty().getProperty1().equals(String.valueOf(x)));
            assert(do1.getComplexTypeProperty().getProperty2() == x);
        }
    }
    
}
