package classes;

public class Tempconv {

    public float Ftoc(float f){
        float c;
        c = (f-32)*5/9;
        return c;
    }

    public float Ctof(float c){
        float f;
        f = c*9/5+32;
        return f;
    }

}
