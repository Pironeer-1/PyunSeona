package game.utils;

public enum GameStatus {
    INITIAL_HP(50),
    INITIAL_AD(10),
    INITIAL_AP(5),
    HP_MULTIPLIER(3),
    STATUS_POINTS(13),
    ENEMY_AD(25),
    ENEMY_AD_DEF(7),
    ENEMY_AP_DEF(7),
    ENEMY_BASE_HP(100),
    ENEMY_HEAL_AMOUNT(7);

    private final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

