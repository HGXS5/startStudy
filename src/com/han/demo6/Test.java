package com.han.demo6;

public class Test {
    public static void main(String[] args) throws Exception {
//        try {
//           throw new TestB("b");
//        } catch (TestA  e) {
//            System.out.println("ExampleA");
//        }catch (Exception e){
//            System.out.println("Exception");
//        }
        try {
            try {
                    throw new TestB();
                } catch ( TestA a ) {
                    System.out.println("Caught TestA");
                    throw a;
                }
            } catch ( TestB s ) {
                System.out.println("Caught TestB");
                return ;
            } finally {
                System.out.println("Hello World!");
            }
    }
}
