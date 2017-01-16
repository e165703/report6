package e165703;

/**
 * Created by e165703 on 2016/11/27.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }
    public int getAttack(){return attack;}
    public String getName(){
        return name;
    }
    public void setName(String name){this.name = name;}
    public int getHitPoint(){
        return hitPoint;
    }
    public void setHitPoint(int hitPoint){this.hitPoint = hitPoint;}
    public void setAttack(int attack){this.attack = attack;}
    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead){this.dead = dead;}
    public void attack(LivingThing opponent){
        if(dead == false) {
            int damage = (int) (Math.random() * attack);
            int k= (int) (Math.random() * 9);//kは会心のこと
            if (damage != 0){
                if(k < 2){
                    int kd = damage*2;//kdは会心ダメージのこと
                    if(name == "勇者"){
                        System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", name, opponent.getName(), kd);
                        opponent.wounded(kd);
                    }
                    if(name == "スライム" && k < 2){
                        System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", name, opponent.getName(), kd);
                        opponent.wounded(kd);
                    }
                }
                else{
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
            else{
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",name,opponent.getName());
                opponent.wounded(damage);
            }
        }
    }
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }
}
