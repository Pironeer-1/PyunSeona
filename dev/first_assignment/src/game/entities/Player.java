package game.entities;

import game.utils.GameOutput;
import java.util.Scanner;
import java.util.Random;

public class Player {
    private int hp = 50;
    private int ad = 10;
    private int ap = 5;

    public void statusSet(int point) {
        Scanner scanner = new Scanner(System.in);
        GameOutput.statusPrompt(point);

        while (true) {
            try {
                String input = scanner.nextLine();
                String[] inputs = input.split(" ");

                int hpIncrease = Integer.parseInt(inputs[0]);
                int adIncrease = Integer.parseInt(inputs[1]);
                int apIncrease = Integer.parseInt(inputs[2]);

                if (hpIncrease + adIncrease + apIncrease == point) {
                    this.hp += hpIncrease * 3;
                    this.ad += adIncrease;
                    this.ap += apIncrease;
                    GameOutput.statusUpdate(hp, ad, ap);
                    break;
                } else {
                    GameOutput.invalidPointsMessage(point);
                }
            } catch (Exception e) {
                GameOutput.invalidInputMessage();
                scanner.next();
            }
        }
    }

    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    public void checkStatus(Enemy enemy) {
        GameOutput.statusMessage(this.hp, this.ad, this.ap, enemy.getHp(), enemy.getAd(), enemy.getAdDefence(), enemy.getApDefence());
    }

    public void basicAttack(Enemy enemy) {
        Random random = new Random();
        int criticalPoint = random.nextInt(10) + 1;
        int damage = this.ad - enemy.getAdDefence();
        if (criticalPoint > 2) {
            enemy.decreaseHp(damage);
            GameOutput.attackMessage(damage);
        } else {
            damage *= 2;
            enemy.decreaseHp(damage);
            GameOutput.criticalAttackMessage(damage);
        }
    }

    public void magicAttack(Enemy enemy) {
        int damage = (this.ap * 2) - enemy.getApDefence();
        damage = Math.max(damage, 0);
        enemy.decreaseHp(damage);
        GameOutput.magicAttackMessage(damage);
    }

    public void healSelf() {
        Random random = new Random();
        int healAmount = random.nextInt(6) + 5;
        this.hp += healAmount;
        GameOutput.healMessage(this.hp);
    }

    public void attack(Enemy enemy, int playerIndex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            GameOutput.actionPrompt(playerIndex + 1);
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                GameOutput.exitMessage();
                System.exit(0);
            }
            try {
                int action = Integer.parseInt(input);
                if (action == 1) {
                    checkStatus(enemy);
                    basicAttack(enemy);
                } else if (action == 2) {
                    basicAttack(enemy);
                } else if (action == 3) {
                    magicAttack(enemy);
                } else if (action == 4) {
                    healSelf();
                } else {
                    GameOutput.invalidActionMessage();
                }
                break;
            } catch (NumberFormatException e) {
                GameOutput.invalidInputMessage();
            }
        }
    }

    public int getHp() {
        return hp;
    }
}

