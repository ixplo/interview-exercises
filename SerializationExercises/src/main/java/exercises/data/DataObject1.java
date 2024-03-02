package exercises.data;

/**
 *
 * @author Administrator
 */
public class DataObject1
{
    private String property1;
    private int property2;
    private DataObject2 complexTypeProperty;

    /**
     * @return the property1
     */
    public String getProperty1()
    {
        return property1;
    }

    /**
     * @param property1 the property1 to set
     */
    public void setProperty1(String property1)
    {
        this.property1 = property1;
    }

    /**
     * @return the property2
     */
    public int getProperty2()
    {
        return property2;
    }

    /**
     * @param property2 the property2 to set
     */
    public void setProperty2(int property2)
    {
        this.property2 = property2;
    }

    /**
     * @return the complexTypeProperty
     */
    public DataObject2 getComplexTypeProperty()
    {
        return complexTypeProperty;
    }

    /**
     * @param complexTypeProperty the complexTypeProperty to set
     */
    public void setComplexTypeProperty(DataObject2 complexTypeProperty)
    {
        this.complexTypeProperty = complexTypeProperty;
    }
}
