package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcodewilmington.animals.Animal;
import rocks.zipcodewilmington.animals.Dog;
import rocks.zipcodewilmington.animals.Mammal;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
public class DogTest {
    @Test
    public void setNameTest() {
        // Given (a name exists and a dog exists)
        Dog dog = new Dog(null, null, null);
        String givenName = "Milo";

        // When (a dog's name is set to the given name)
        dog.setName(givenName);

        // Then (we expect to get the given name from the dog)
        String dogName = dog.getName();
        Assert.assertEquals(dogName, givenName);
    }

    @Test
    public void constructorTest() {
        String givenName = "Max";
        Date givenBirthDate = new Date();
        Integer givenId = 0;

        Dog dog = new Dog(givenName, givenBirthDate, givenId);

        String retrievedName = dog.getName();
        Date retrievedBirthDate = dog.getBirthDate();
        Integer retrievedId = dog.getId();

        Assert.assertEquals(givenName, retrievedName);
        Assert.assertEquals(givenBirthDate, retrievedBirthDate);
        Assert.assertEquals(givenId, retrievedId);
    }

    @Test
    public void speakTest() {
        Dog dog = new Dog("Bella",new Date(),0);
        Assert.assertEquals("bark!",dog.speak());
    }

    @Test
    public void setBirthDateTest() {
        Date givenBirthDate = new Date();   // today's date

        Dog dog = new Dog(null, null, null);
        dog.setBirthDate(givenBirthDate);
        Date retrievedBirthday = dog.getBirthDate();

        Assert.assertEquals(givenBirthDate, retrievedBirthday);
    }


    @Test
    public void eatTest(){
        Dog dog = new Dog("Charlie",new Date(),0);

        dog.eat(new Food());
        Assert.assertEquals(1, (int) dog.getNumberOfMealsEaten());
    }

    @Test
    public void getIdTest() {
        Dog dog = new Dog(null ,null,1234);
        Assert.assertEquals(1234, (int) dog.getId());
    }

    @Test
    public void dogIsAnimalTest() {
        Dog dog = new Dog(null,null,null);
        Assert.assertTrue(dog instanceof Animal);
    }

    @Test
    public void dogIsMammalTest() {
        Dog dog = new Dog(null,null,null);
        Assert.assertTrue(dog instanceof Mammal);
    }
}
