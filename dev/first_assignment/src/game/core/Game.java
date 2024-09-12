package game.core;

import game.entities.Player;
import game.entities.Enemy;
import game.utils.GameOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Game {
    private int statusPoint = 13; // 기본포인트 13
    private List<Player> playerList = new ArrayList<>(); //player를 list로 저장
    private Enemy enemy; // 적(Enemy) 객체

    //setPlayers : player 수에 맞게 초기값 세팅
    public void setPlayers() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("플레이어 인원을 정하세요: ");
                int list_num = Integer.parseInt(br.readLine());

                if (list_num <= 0) {
                    System.out.println("플레이어 인원은 1 이상이어야 합니다. 다시 입력해주세요.");
                    continue;
                }

                for (int i = 0; i < list_num; i++) {
                    Player player = new Player();
                    player.statusSet(statusPoint);
                    playerList.add(player);
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            } catch (IOException e) {
                System.out.println("입력 오류가 발생했습니다.");
            }
        }
    }

    //setEnemy : 플레이어 수에 따라 적의 체력을 결정
    public void setEnemy() {
        this.enemy = new Enemy(playerList.size());
    }

    //turnCheck : 게임이 종료되었는지 확인하여 bool 값 반환
    public boolean turnCheck() {
        playerList.removeIf(player -> player.getHp() <= 0);
        return !(playerList.isEmpty() || enemy.getHp() == 0);
    }

    //selectTargetPlayer : 무작위로 플레이어 공격(ramdom 사용)
    public Player selectTargetPlayer() {
        return playerList.get(new Random().nextInt(playerList.size()));
    }

    public void game() {
        setPlayers();
        setEnemy();
        //게임 종료가 될때까지 while문 반복
        while (turnCheck()) {
            //player 공격
            for (int i = 0; i < playerList.size(); i++) {
                playerList.get(i).attack(enemy, i);
                if (enemy.getHp() == 0) {
                    GameOutput.victoryMessage();
                    return;
                }
            }
            //적(enemy) 공격
            if (turnCheck()) {
                Player targetPlayer = selectTargetPlayer();
                int targetIndex = playerList.indexOf(targetPlayer);
                enemy.attack(targetPlayer, targetIndex);
            }
        }
        GameOutput.defeatMessage();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.game();
    }
}

