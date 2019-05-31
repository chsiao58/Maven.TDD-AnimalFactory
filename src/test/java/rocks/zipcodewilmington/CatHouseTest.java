package rocks.zipcodewilmington;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rocks.zipcodewilmington.animals.Cat;
import rocks.zipcodewilmington.animals.animal_storage.CatHouse;

import java.util.Date;

/**
 * @author leon on 4/19/18.
 */
public class CatHouseTest {

    CatHouse catHouse;
    Cat givenCat;
    Integer givenCatId;

    @Before
    public void before(){
        catHouse = new CatHouse();
        givenCatId = 1;
        givenCat = new Cat("Lily",new Date(),givenCatId);
    }

    @Test
    public void addTest() {
        catHouse.add(givenCat);
        Assert.assertEquals(givenCat, catHouse.getCatById(givenCatId));
    }

    @Test
    public void removeByIdTest() {
        Cat catBen = new Cat("Ben",new Date(),4);
        catHouse.add(catBen);
        catHouse.remove(4);

        Assert.assertNotEquals(catBen,catHouse.getCatById(4));
    }

    @Test
    public void removeByCatTest() {
        Cat catMax = new Cat("Max",new Date(),2);
        catHouse.add(catMax);
        catHouse.remove(catMax);

        Assert.assertNotEquals(catMax,catHouse.getCatById(2));
    }

    @Test
    public void getCatByIdTest() {
        catHouse.add(givenCat);
        Assert.assertEquals(givenCat.getId(), catHouse.getCatById(givenCatId).getId());
    }

    @Test
    public void getNumberOfCatsTest(){

        CatHouse lucyHouse = new CatHouse();;
        Cat catLucy = new Cat("Lucy",new Date(),3);
        CatHouse.clear();
        lucyHouse.add(catLucy);
        Assert.assertEquals(1,(int) lucyHouse.getNumberOfCats());
    }
}
