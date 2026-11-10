package practice;

public class SilverCard extends Card{
    public SilverCard(String carId, String name, String phone, int money) {
        super(carId, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("银卡打折前:"+money);
        //打折
        money *= 0.9;
        System.out.println("打折后:"+money);
        //修改余额
        if (getMoney() >= money) {
            setMoney(getMoney()-money);
            System.out.println("消费成功，当前余额："+getMoney());
        }
        else if(getMoney() < money){
            System.out.println("当前余额不足："+getMoney()+'\n'+"请存钱");
            return;
        }
    }
}
