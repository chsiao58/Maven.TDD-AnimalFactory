package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcodewilmington.animals.Dog;
import rocks.zipcodewilmington.animals.animal_creation.AnimalFactory;
import rocks.zipcodewilmington.animals.animal_storage.DogHouse;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
public class DogHouseTest {

    @Test
    public void testGetNumberOfDogs() {
        // Given (some
        String name = "Milo";
        Date birthDate = new Date();
        Dog animal = AnimalFactory.createDog(name, birthDate);
        DogHouse.clear();

        // When
        DogHouse.add(animal);

        // Then
        Assert.assertEquals(1, (int)DogHouse.getNumberOfDogs());
    }

    @Test
    public void addTest(){
        Dog givenDog = new Dog("Fido", new Date(), 12);
        DogHouse.add(givenDog);
        Assert.assertEquals(givenDog,DogHouse.getDogById(12));
    }

    @Test
    public void removeByIdTest(){
        Dog givenDog = new Dog("Missile", new Date(), 32);
        DogHouse.add(givenDog);
        DogHouse.remove(32);
        Assert.assertNotEquals(givenDog,DogHouse.getDogById(32));
    }

    @Test
    public void removeByDogTest(){
        Dog givenDog = new Dog("Ammy", new Date(), 42);
        DogHouse.add(givenDog);
        DogHouse.remove(givenDog);
        Assert.assertNotEquals(givenDog,DogHouse.getDogById(42));
    }

    @Test
    public void getDogByIdTest(){
        Dog givenDog = new Dog("Tramp", new Date(), 56);
        DogHouse.add(givenDog);
        Assert.assertEquals(givenDog.getId(),DogHouse.getDogById(56).getId());
    }

}
