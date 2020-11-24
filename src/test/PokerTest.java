package test;

import com.han.demo4.Poker;

public class PokerTest {
    public static void main(String[] args) {
        Poker p = new Poker();
        //洗牌
        p.shuffle();
        //发牌
        Poker.Card d = p.deal(0);
        //对于非静态内部类Card
        //只有通过其外部类poker对象才能创建Card对象
        Poker.Card d4 = p.new Card("方片", 1);//自己创建一张牌
        System.out.println(d);
        System.out.println(d4);
    }
}
