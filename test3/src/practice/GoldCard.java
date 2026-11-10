package practice;

public class GoldCard extends Card{
    public GoldCard(String carId, String name, String phone, int money) {
        super(carId, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("金卡打折前:"+money);
        //打折
        money *= 0.8;
        System.out.println("打折后:"+money);
        //修改余额
        if(getMoney() >= money){
            setMoney(getMoney()-money);
            System.out.println("消费成功，当前余额："+getMoney());
        }
        else if(getMoney() < money){
            System.out.println("当前余额不足："+getMoney()+'\n'+"请存钱");
            return;
        }
        //打印洗车票
        if(money >= 200){
            printTiket();
        }
        else{
            System.out.println("消费不满200，无法免费洗车");
        }
    }

    private void printTiket() {
        System.out.println("您消费了,请打印洗车票");
    }

}
