package e165703;

public class Hero extends LivingThing {
    public Hero(String name, int hitPoint, int attack) {
       super(name,hitPoint,attack);
    }
    @Override
    public void attack(LivingThing opponent){
        if(isDead() == false){
            int damage = (int) (Math.random() * getAttack());
            int k= (int) (Math.random() * 9);//kは会心のこと
            if(damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",getName(),opponent.getName());
                opponent.wounded(damage);
            }
            if(k < 3 && damage != 0){
                int kd = damage*2;//kdは会心ダメージのこと
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), kd);
                opponent.wounded(kd);
            }
            if(k >= 3 && damage != 0){
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                opponent.wounded(damage);
            }
        }
    }
}