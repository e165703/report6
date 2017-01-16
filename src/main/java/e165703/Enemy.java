package e165703;


public class Enemy extends LivingThing {
    public Enemy(String name, int hitPoint, int attack) {
        super(name, hitPoint, attack);
    }
    @Override
    public void attack(LivingThing opponent){
        if(isDead() == false){
            int damage = (int) (Math.random() * getAttack());
            int t= (int) (Math.random() * 9);//tは痛恨のこと
            if(damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",getName(),opponent.getName());
                opponent.wounded(damage);
            }
            if(t < 2 && damage != 0){
                int td = damage*2;//tdは痛恨ダメージのこと
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), td);
                opponent.wounded(td);
            }
            if(t >= 2 && damage != 0){
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                opponent.wounded(damage);
            }
        }
    }
}