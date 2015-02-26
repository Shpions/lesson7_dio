import com.dio.lesson7.ArrayHelper;
import com.dio.lesson7.Person;
import com.dio.lesson7.ServiceDelegate;
import com.dio.lesson7.Validate_Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class TestCollections {

    @Test
    public void testMerge_Positive() throws Exception {
        Validate_Person validP = mock(Validate_Person.class);
        ArrayHelper arrayH = mock(ArrayHelper.class);
        ServiceDelegate serviceDel = new ServiceDelegate(arrayH, validP);

        final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

        final Person[] p2 = {new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("Igor").setNumber(12345367).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
                new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

        ArrayList<Person> personList1 = new ArrayList<Person>(Arrays.asList(p1));
        ArrayList <Person> personList2 = new ArrayList<Person>(Arrays.asList(p2));

        when(arrayH.merge(personList1, personList2)).thenReturn(personList1);

        ArrayList <Person> result = serviceDel.merge(personList1, personList2);

        assertEquals(result, personList1);
        verify(arrayH, times(1)).merge(personList1, personList2);
    }

    @Test
    public void testMerge_Negative() throws Exception {

        Validate_Person validP = mock(Validate_Person.class);
        ArrayHelper arrayH = mock(ArrayHelper.class);
        ServiceDelegate serviceDel = new ServiceDelegate(arrayH, validP);

        final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

        final Person[] p2 = {new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("").setNumber(12345367).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
                new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

        ArrayList <Person> personList1 = new ArrayList<Person>(Arrays.asList(p1));
        ArrayList <Person> personList2 = new ArrayList<Person>(Arrays.asList(p2));

        doThrow(new ArrayIndexOutOfBoundsException("not valid name\n")).
                when(validP).validarePerson(personList2);

        when(arrayH.innerUnion(personList1,personList2)).thenReturn(personList2);

        try {
            ArrayList<Person>result = serviceDel.merge(personList1,personList2);
            fail();
        }
        catch (ArrayIndexOutOfBoundsException e){
            assertEquals(e.getMessage(), "not valid name\n");
        }
        verifyNoMoreInteractions(arrayH);
    }

    @Test
    public void testInnerUnion_Positive() throws Exception {
        Validate_Person validP = mock(Validate_Person.class);
        ArrayHelper arrayH = mock(ArrayHelper.class);
        ServiceDelegate serviceDel = new ServiceDelegate(arrayH, validP);

        final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

        final Person[] p2 = {new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("Igor").setNumber(12345367).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
                new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

        ArrayList <Person> personList1 = new ArrayList<Person>(Arrays.asList(p1));
        ArrayList <Person> personList2 = new ArrayList<Person>(Arrays.asList(p2));

        when(arrayH.innerUnion(personList1, personList2)).thenReturn(personList1);

        ArrayList <Person> result = serviceDel.innerUnion(personList1, personList2);

        assertEquals(result, personList1);
        verify(arrayH, times(1)).innerUnion(personList1, personList2);
    }

    @Test
    public void testInnerUnion_Negative() throws Exception {
        Validate_Person validP = mock(Validate_Person.class);
        ArrayHelper arrayH = mock(ArrayHelper.class);
        ServiceDelegate serviceDel = new ServiceDelegate(arrayH, validP);

        final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

        final Person[] p2 = {new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("").setNumber(12345367).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(0).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
                new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

        ArrayList <Person> personList1 = new ArrayList<Person>(Arrays.asList(p1));
        ArrayList <Person> personList2 = new ArrayList<Person>(Arrays.asList(p2));

        doThrow(new ArrayIndexOutOfBoundsException("not valid name\nnot valid age\n")).
                when(validP).validarePerson(personList2);

        when(arrayH.innerUnion(personList1, personList2)).thenReturn(personList2);

        try {
            ArrayList<Person>result = serviceDel.innerUnion(personList1, personList2);
            fail();
        }
        catch (ArrayIndexOutOfBoundsException e){
            assertEquals(e.getMessage(),"not valid name\n" +
                    "not valid age\n");
        }
        verifyNoMoreInteractions(arrayH);
    }

    @Test
    public void testOuterUnion_Positive() throws Exception {
        Validate_Person validP = mock(Validate_Person.class);
        ArrayHelper arrayH = mock(ArrayHelper.class);
        ServiceDelegate serviceDel = new ServiceDelegate(arrayH, validP);

        final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

        final Person[] p2 = {new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("Igor").setNumber(12345367).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
                new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

        ArrayList <Person> personList1 = new ArrayList<Person>(Arrays.asList(p1));
        ArrayList <Person> personList2 = new ArrayList<Person>(Arrays.asList(p2));

        when(arrayH.outerUnion(personList1, personList2)).thenReturn(personList1);

        ArrayList <Person> result = serviceDel.outerUnion(personList1, personList2);

        assertEquals(result, personList1);

        verify(arrayH, times(1)).outerUnion(personList1, personList2);
    }

    @Test
    public void testOuterUnion_Negative() throws Exception {
        Validate_Person validP = mock(Validate_Person.class);
        ArrayHelper arrayH = mock(ArrayHelper.class);
        ServiceDelegate serviceDel = new ServiceDelegate(arrayH, validP);

        final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

        final Person[] p2 = {new Person.Builder().setAge(13).setMail("").setName("").setNumber(12345367).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(0).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(0).build(),
                new Person.Builder().setAge(-6).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

        ArrayList <Person> personList1 = new ArrayList<Person>(Arrays.asList(p1));
        ArrayList <Person> personList2 = new ArrayList<Person>(Arrays.asList(p2));

        doThrow(new ArrayIndexOutOfBoundsException("not valid name\nnot valid Age\nnot valid Mail\nnot valid Number\n")).
                when(validP).validarePerson(personList2);

        when(arrayH.innerUnion(personList1, personList2)).thenReturn(personList2);

        try {
            ArrayList<Person>result = serviceDel.innerUnion(personList1, personList2);
            fail();
        }
        catch (ArrayIndexOutOfBoundsException e){
            assertEquals(e.getMessage(),"not valid name\n" +
                    "not valid Age\n" +
                    "not valid Mail\n" +
                    "not valid Number");
        }

        verifyNoMoreInteractions(arrayH);
    }
}
