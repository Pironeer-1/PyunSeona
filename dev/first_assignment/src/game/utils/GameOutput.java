package game.utils;

public class GameOutput {

    public static void playerCountPrompt() {
        System.out.println("플레이어 인원을 정하세요: ");
    }

    public static void statusPrompt(int point) {
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요");
        System.out.println("(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.");
    }

    public static void statusUpdate(int hp, int ad, int ap) {
        System.out.println("체력: " + hp + ", 공격력: " + ad + ", 마법력: " + ap);
    }

    public static void invalidPointsMessage(int point) {
        System.out.println("입력한 능력치의 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
    }

    public static void invalidInputMessage() {
        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
    }

    public static void actionPrompt(int playerIndex) {
        System.out.println(playerIndex + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
    }

    public static void attackMessage(int damage) {
        System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public static void criticalAttackMessage(int damage) {
        System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
    }

    public static void magicAttackMessage(int damage) {
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public static void healMessage(int hp) {
        System.out.println("체력을 회복합니다. 현재 hp는 " + hp + "입니다.");
    }

    public static void invalidActionMessage() {
        System.out.println("1~4 사이의 유효한 값을 입력해주세요.");
    }

    public static void exitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }

    public static void statusMessage(int playerHp, int playerAd, int playerAp, int enemyHp, int enemyAd, int enemyAdDef, int enemyApDef) {
        System.out.println("현재 유저: 체력 " + playerHp + ", 공격력 " + playerAd + ", 마법력 " + playerAp);
        System.out.println("적: 체력 " + enemyHp + ", 공격력 " + enemyAd + ", 방어력 " + enemyAdDef + ", 마법방어력 " + enemyApDef);
    }

    public static void enemyAttackMessage(int damage, int playerHp, int playerIndex) {
        System.out.println(playerIndex + "번 유저에게 " + damage + "의 데미지. 적의 공격으로 현재 남은 체력은 " + playerHp + "입니다.");
    }

    public static void enemyIdleMessage() {
        System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
    }

    public static void enemyHealMessage(int enemyHp) {
        System.out.println("적의 회복으로 현재 적의 체력은 " + enemyHp + "입니다.");
    }

    public static void enemyMaxHealMessage() {
        System.out.println("적이 회복했지만 적은 이미 최대체력입니다.");
    }

    public static void victoryMessage() {
        System.out.println("축하합니다! 승리하셨습니다!");
    }

    public static void defeatMessage() {
        System.out.println("아쉽지만 패배하셨습니다.");
    }
}
