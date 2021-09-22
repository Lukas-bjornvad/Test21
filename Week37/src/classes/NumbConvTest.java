package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbConvTest {

    @Test
    void NormalConvertion(){
        int numb = 1234;
        String result= new NumbConv().RomaConv(numb);
        assertEquals("MCCXXXIV", result);
    }
    @Test
    void SingleDigitConvertion(){
        int numb = 4;
        String result= new NumbConv().RomaConv(numb);
        assertEquals("IV", result);
    }
}