package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcodewilmington.animals.Animal;
import rocks.zipcodewilmington.animals.Cat;
import rocks.zipcodewilmington.animals.Mammal;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
public class CatTest {

    @Test
    public void constructorTest() {
        // Given (cat data)
        String givenName = "Zula";
        Date givenBirthDate = new Date();
        Integer givenId = 0;

        // When (a cat is constructed)
        Cat cat = new Cat(givenName, givenBirthDate, givenId);

        // When (we retrieve data from the cat)
        String retrievedName = cat.getName();
        Date retrievedBirthDate = cat.getBirthDate();
        Integer retrievedId = cat.getId();

        // Then (we expect the given data, to match the retrieved data)
        Assert.assertEquals(givenName, retrievedName);
        Assert.assertEquals(givenBirthDate, retrievedBirthDate);
        Assert.assertEquals(givenId, retrievedId);
    }

    @Test
    public void setNameTest() {
        String givenName = "Luna";

        Cat cat = new Cat(null, null, null);
        cat.setName(givenName);
        String retrievedName = cat.getName();
                                                                       
        Assert.assertEquals(givenName, retrievedName);
    }

    @Test
    public void setBirthDateTest() {
        Date givenBirthDate = new Date();   // today's date

        Cat cat = new Cat(null, null, null);
        cat.setBirthDate(givenBirthDate);
        Date retrievedBirthday = cat.getBirthDate();

        Assert.assertEquals(givenBirthDate, retrievedBirthday);
    }

    @Test
    public void speakTest() {
        Cat cat = new Cat("Oliver",new Date(),0);
        Assert.assertEquals("meow!",cat.speak());
    }

    @Test
    public void eatTest(){
        Cat cat = new Cat("Chloe",new Date(),0);

        cat.eat(new Food());
        Assert.assertEquals(1, (int) cat.getNumberOfMealsEaten());
    }

    @Test
    public void getIdTest() {
        Cat cat = new Cat(null ,null,1234);
        Assert.assertEquals(1234, (int) cat.getId());
    }

    @Test
    public void catIsAnimalTest() {
        Cat cat = new Cat(null,null,null);
        Assert.assertTrue(cat instanceof Animal);
    }

    @Test
    public void catIsMammalTest() {
        Cat cat = new Cat(null,null,null);
        Assert.assertTrue(cat instanceof Mammal);
    }
}

