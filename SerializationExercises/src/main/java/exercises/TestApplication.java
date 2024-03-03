package exercises;

import exercises.data.DataObject1;
import exercises.data.DataObject2;
import serialization.SerializationManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class TestApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        simpleSerializationTest();
        console.nextLine();
    }

    private static void simpleSerializationTest() {
        SerializationManagement sm = new SerializationManagement();
        List<DataObject1> dataObjects = new ArrayList<>();

        for (int x = 0; x < 100; x++) {
            DataObject1 do1 = new DataObject1();
            dataObjects.add(do1);
            do1.setProperty1(String.valueOf(x));
            do1.setProperty2(x);
            do1.setComplexTypeProperty(new DataObject2());
            do1.getComplexTypeProperty().setSourceIdentifier("Serialized");
            do1.getComplexTypeProperty().setProperty1(String.valueOf(x));
            do1.getComplexTypeProperty().setProperty2(x);
        }

        sm.serialize("TestData", dataObjects);
        dataObjects = sm.deserialize("TestData", DataObject1.class);

        for (int x = 0; x < 100; x++) {
            DataObject1 do1 = dataObjects.get(x);
            assert (do1.getProperty1().equals(String.valueOf(x)));
            assert (do1.getProperty2() == x);
            assert (do1.getComplexTypeProperty().getSourceIdentifier() == null);
            assert (do1.getComplexTypeProperty().getProperty1().equals(String.valueOf(x)));
            assert (do1.getComplexTypeProperty().getProperty2() == x);
        }
        System.out.println("Assertions are passed");
    }

}
