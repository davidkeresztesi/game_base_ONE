package World;

public abstract class Entity {

    private int xPosition;
    private int yPosition;

    private int healthPlayer_01;
    private int powerPlayer_01;
    private int staminaPlayer_01;

    public Entity(int healthPlayer_01, int powerPlayer_01, int staminaPlayer_01) {
        this.healthPlayer_01 = healthPlayer_01;
        this.powerPlayer_01 = powerPlayer_01;
        this.staminaPlayer_01 = staminaPlayer_01;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getHealthPlayer_01() {
        return healthPlayer_01;
    }

    public int getPowerPlayer_01() {
        return powerPlayer_01;
    }

    public int getStaminaPlayer_01() {
        return staminaPlayer_01;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setHealthPlayer_01(int healthPlayer_01) {
        this.healthPlayer_01 = healthPlayer_01;
    }

    public void setPowerPlayer_01(int powerPlayer_01) {
        this.powerPlayer_01 = powerPlayer_01;
    }

    public void setStaminaPlayer_01(int staminaPlayer_01) {
        this.staminaPlayer_01 = staminaPlayer_01;
    }
}
