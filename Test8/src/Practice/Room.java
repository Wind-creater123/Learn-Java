package Practice;

import java.util.*;

public class Room {
    private List<Card> cards = new ArrayList<>();
    {
        //size
        String[] sizes={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //color
        String[] colors={"♥","♦","♣","♠"};

        int num=0;
        for(String size:sizes){
            num++;
            for(String color:colors){
                Card card = new Card(size,color,num);
                cards.add(card);
            }
        }
        cards.add(new Card("","小王",++num));
        cards.add(new Card("","大王",++num));
        System.out.println(cards);
    }

    public void start() {
        Collections.shuffle(cards);//打乱
        System.out.println(cards);

        Map<String,List<Card>> players=new HashMap<>();
        List<Card> lhc=new ArrayList<>();
        List<Card> lhb=new ArrayList<>();
        List<Card> lhz=new ArrayList<>();
        players.put("lhc",lhc);
        players.put("lhb",lhb);
        players.put("lhz",lhz);
        //
        for(int i=0;i<cards.size()-3;i++){
            Card card=cards.get(i);
            if(i%3==0){
                lhc.add(card);
            } else if (i%3==1) {
                lhb.add(card);
            }else {
                lhz.add(card);
            }
        }

        //
        List<Card> lastCards=cards.subList(cards.size()-3,cards.size());
        System.out.println(lastCards);

        //
        lhz.addAll(lastCards);

        // 排序
        sortCards(lhc);
        sortCards(lhb);
        sortCards(lhz);

        //
        for(Map.Entry<String,List<Card>> entry:players.entrySet()){
            String name=entry.getKey();
            List<Card> cards=entry.getValue();
            System.out.println(name+":"+cards);
        }
    }

    private void sortCards(List<Card> cards) {
        Collections.sort(cards, (o1, o2) -> o1.getNum()-o2.getNum());
    }
}
