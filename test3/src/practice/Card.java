package practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String carId;//车牌号
    private String name;//车主
    private String phone;//电话号码
    private double money;//余额

    //存入金额
    public void deposit(double money){
        this.money += money;
    }

    //消费金额
    public void consume(double money){
        if(this.money >= money){
            this.money -= money;
            System.out.println("消费成功，当前余额："+getMoney());
        }
        else if(this.money < money){
            System.out.println("余额不足");
        }
    }
}
