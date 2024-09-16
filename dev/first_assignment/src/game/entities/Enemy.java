package game.entities;

import game.utils.GameOutput;
import java.util.Random;

public class Enemy {
    private int hp;
    private int ad = 25;
    private int adDefence = 7;
    private int apDefence = 7;
    private int maxHp;

    //생성자로 적의 체력 초기화
    public Enemy(int playerCount) {
        this.hp = 100 * playerCount;
        this.maxHp = this.hp;
    }

    //체력감소
    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    //적의 기본공격
    public void basicAttack(Player player, int playerIndex) {
        player.decreaseHp(this.ad);
        GameOutput.enemyAttackMessage(this.ad, player.getHp(), playerIndex + 1);
    }

    //적의 체력회복
    public void healSelf() {
        int healAmount = 7;
        if (this.hp + healAmount > this.maxHp) {
            GameOutput.enemyMaxHealMessage();
        } else {
            this.hp += healAmount;
            GameOutput.enemyHealMessage(this.hp);
        }
    }
    //적의 행동
    public void attack(Player player, int playerIndex) {
        System.out.println("적의 차례입니다");
        Random random = new Random();
        int action = random.nextInt(10) + 1;
        if (action == 1) {
            GameOutput.enemyIdleMessage();
        } else if (action <= 8) {
            basicAttack(player, playerIndex);
        } else {
            healSelf();
        }
    }

    //반환역할을 하는 Getter 메서드(속성값 읽어오는 역할)
    public int getHp() {
        return hp;
    }

    public int getAd() {
        return ad;
    }

    public int getAdDefence() {
        return adDefence;
    }

    public int getApDefence() {
        return apDefence;
    }
}

