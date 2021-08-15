import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void BeforeClass() {
        System.out.println("TeenageTest test started");
        currentTime();
    }

    @AfterClass
    void AfterClass() {
        System.out.println("TeenageTest test done");
        currentTime();
    }

    @DataProvider(name = "ageTest")
    Object[][] ageDataProvider() {
        return new Object[][]{
                {10, false},
                {0, false},
                {16, true},
                {20, false},
                {19, true},
                {13, true},
                {-10, false},
        };
    }

    @Test(dataProvider = "ageTest")
    void TestIsTeenager(int age, boolean expectedResult) {

        boolean result = Person.isTeenager(age);
        System.out.println(result);
        assertEquals(result, expectedResult,age + "  - не тинейджер, тинейджер: 13-19");

    }

}
