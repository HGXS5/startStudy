package test;

public class SwitchTest {
    public static void main(String[] args) {
        int day = 5;
        switch (day){
            case 1:
            case 2:
                System.out.println("今天吃饭");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("今天有想法");
                break;
            case 6:
            case 7:
                System.out.println("今天要搞事情");
                break;

        }
    }
}
