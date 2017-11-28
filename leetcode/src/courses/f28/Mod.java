package courses.f28;

public class Mod {

    public static int encrypt(double m, double e, int n){
        return (int)(Math.pow(m,e)) % n;
    }

    public static void main(String[] args){
        System.out.println(encrypt(5,7,33));
        System.out.println(encrypt(9,3,55));
    }
}
