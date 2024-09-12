package game.entities;

import game.utils.GameOutput;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class Player {
    private int hp = 50;
    private int ad = 10;
    private int ap = 5;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void statusSet(int point) {
        GameOutput.statusPrompt(point);

        while (true) {
            try {
                String input = br.readLine();
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
            } catch (IOException e) {
                GameOutput.invalidInputMessage();
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                GameOutput.invalidInputMessage();
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
        while (true) {
            GameOutput.actionPrompt(playerIndex + 1);
            try {
                String input = br.readLine();
                if (input.equals("exit")) {
                    GameOutput.exitMessage();
                    System.exit(0);
                }
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
            } catch (IOException e) {
                GameOutput.invalidInputMessage();
            } catch (NumberFormatException e) {
                GameOutput.invalidInputMessage();
            }
        }
    }

    public int getHp() {
        return hp;
    }
}