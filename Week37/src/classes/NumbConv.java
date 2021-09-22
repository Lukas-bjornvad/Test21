package classes;

public class NumbConv {

    String RomaConv(int numb){
        String result="";
        if (numb > 3999) {
            result = "number is too high";
        }

        if (numb / 1000 >= 1) {
            result = getThousands(numb);
            result = result+getHundreds(numb);
            result = result+getTens(numb);
            result = result+getOnes(numb);
        }
        else if (numb / 100 >= 1) {
            result = result + getHundreds(numb);
            result = result + getTens(numb);
            result = result + getOnes(numb);
        } else if (numb / 10 >= 1) {
            result = result+getTens(numb);
            result = result+getOnes(numb);
        }else{
            result = result+getOnes(numb);
        }
        return result;
    }

    private String getThousands(int numb) {
        numb = numb / 1000 % 10;
        String res = "";
        while (numb > 0) {
            res = res + "M";
            numb--;
        }
        return res;
    }

    private String getHundreds(int numb) {
        numb = numb / 100 % 10;
        String res = "";
        if (numb == 4) {
            res = "CD";
        } else if (numb == 9) {
            res = "CM";
        } else if (numb >= 5) {
            res = "D";
            for (int i = numb - 5; i > 0; i--) {
                res = res + "C";
            }
        } else {
            while (numb > 0) {
                res = res + "C";
                numb--;
            }
        }
        return res;
    }
    private String getTens(int numb) {
        numb = numb / 10 % 10;
        String res = "";
        if (numb == 4) {
            res = "XL";
        } else if (numb == 9) {
            res = "XC";
        } else if (numb >= 5) {
            res = "L";
            for (int i = numb - 5; i > 0; i--) {
                res = res + "X";
            }
        } else {
            while (numb > 0) {
                res = res + "X";
                numb--;
            }
        }
        return res;
    }
    private String getOnes(int numb) {
        numb = numb % 10;
        String res = "";
        if (numb == 4) {
            res = "IV";
        } else if (numb == 9) {
            res = "IX";
        } else if (numb >= 5) {
            res = "V";
            for (int i = numb - 5; i > 0; i--) {
                res = res + "I";
            }
        } else {
            while (numb > 0) {
                res = res + "I";
                numb--;
            }
        }
        return res;
    }
}

