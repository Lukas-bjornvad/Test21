package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempconvTest {

    @Test
    void FarenheitToCelciusTest(){
        float far = 68;
       float cel =  new Tempconv().Ftoc(far);
        assertEquals(20, cel);
    }

    @Test
    void CelciusToTest(){
        float cel = 20;
        float far = new Tempconv().Ctof(cel);
        assertEquals(68, far);
    }
}