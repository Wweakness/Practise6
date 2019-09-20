import java.util.ArrayList;
import java.util.Random;

public class Main {
   private static void swap(ArrayList<PokeCard> list,int i,int j){
        PokeCard tmpI=list.get(i);
        PokeCard tmpJ=list.get(j);
        //交换i.j坐标的值
        list.set(i,tmpJ);
       list.set(j,tmpI);
    }

    public static void main(String[] args){
        ArrayList<PokeCard> cards=new ArrayList<>(52);
        String[] colors={"♥","♦","♠","♣"};
        //按顺序打印正副牌
        //花色循环
        for(int i=0;i<4;i++){
            //数字循环
            for(int j=1;j<14;j++){
                PokeCard card=new PokeCard(j,colors[i]);
                //循环按顺序尾插每一张牌
                cards.add(card);
            }
        }
        System.out.println(cards);

        //洗牌
        Random random=new Random(20190820);
        for (int i=51;i>0;i--){
            //在0到i之前数字中随机抽取一个数字赋给j
            int j=random.nextInt(i);
            //调用swap方法交换i，J
            swap(cards,i,j);
        }
        System.out.println(cards);

        //有三个人每人抓5张牌
        ArrayList<PokeCard> A=new ArrayList<>();
        ArrayList<PokeCard> B=new ArrayList<>();
        ArrayList<PokeCard> C=new ArrayList<>();
        //打印15张牌
        System.out.println(cards.subList(52-15,52));
        for(int i=0;i<15;i++){
            //尾删
            PokeCard card=cards.remove(cards.size()-1);
            //发牌，余1发给A,余2发给B,余3发给C
            switch (i%3){
                case 0:
                    A.add(card);
                    break;
                case 1:
                    B.add(card);
                    break;
                case 2:
                    C.add(card);
                    break;
            }
        }
        System.out.println(cards.size());
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        //A抓到手里的牌中，有没有♠6
        PokeCard heartA=new PokeCard(6,"♠");
        //自写代码判断是否包含
        for(PokeCard card:A){
            //如何判断card是不是♠6
            //自定义类如何判断两个对象相等
            if(card.equals(heartA)){
                System.out.println("包含");
            }
        }
        //用系统自带的方法判断
        if(A.contains(heartA)){
            System.out.println("包含");
        }else {
            System.out.println("不包含");
        }





    }
}
