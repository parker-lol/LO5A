public class Burner {

    public enum Temperature {
        BLAZING("VERY HOT! DON'T TOUCH"),
        HOT("CAREFUL"),
        WARM("warm"),
        COLD("coool");

        private final String displayValue;

        private Temperature(String displayValue) {
            this.displayValue = displayValue;
        }

        @Override
        public String toString() {
            return this.displayValue;
        }
    }

    public static final int TIME_DURATION = 2;

    private Temperature myTemperature;
    private Setting mySetting;
    private int timer;

    public Burner() {
        this.myTemperature = Temperature.COLD;
        this.mySetting = Setting.OFF;
        this.timer = 0;
    }

    public Temperature getMyTemperature() {
        return this.myTemperature;
    }

    public Setting getMySetting() {
        return this.mySetting;
    }

    public void plusButton() {
        switch (this.mySetting) {
            case OFF:
                this.mySetting = Setting.LOW;
                this.timer = TIME_DURATION;
                break;
            case LOW:
                this.mySetting = Setting.MEDIUM;
                this.timer = TIME_DURATION;
                break;
            case MEDIUM:
                this.mySetting = Setting.HIGH;
                this.timer = TIME_DURATION;
                break;
            case HIGH:
                break;
        }
    }

    public void minusButton() {
        switch (this.mySetting) {
            case HIGH:
                this.mySetting = Setting.MEDIUM;
                this.timer = TIME_DURATION;
                break;
            case MEDIUM:
                this.mySetting = Setting.LOW;
                this.timer = TIME_DURATION;
                break;
            case LOW:
                this.mySetting = Setting.OFF;
                this.timer = TIME_DURATION;
                break;
            case OFF:
                break;
        }
    }

    public void updateTemperature() {
        if (this.timer > 0) {
            this.timer--;
            if (this.timer == 0) {
                switch (this.mySetting) {
                    case OFF:
                        if (this.myTemperature == Temperature.WARM) {
                            this.myTemperature = Temperature.COLD;
                        } else if (this.myTemperature == Temperature.HOT) {
                            this.myTemperature = Temperature.WARM;
                        } else if (this.myTemperature == Temperature.BLAZING) {
                            this.myTemperature = Temperature.HOT;
                        }
                        break;
                    case LOW:
                        if (this.myTemperature == Temperature.COLD) {
                            this.myTemperature = Temperature.WARM;
                        } else if (this.myTemperature == Temperature.HOT) {
                            this.myTemperature = Temperature.WARM;
                        } else if (this.myTemperature == Temperature.BLAZING) {
                            this.myTemperature = Temperature.HOT;
                        }
                        break;
                    case MEDIUM:
                        if (this.myTemperature == Temperature.COLD || this.myTemperature == Temperature.WARM) {
                            this.myTemperature = Temperature.HOT;
                        } else if (this.myTemperature == Temperature.BLAZING) {
                            this.myTemperature = Temperature.HOT;
                        }
                        break;
                    case HIGH:
                        if (this.myTemperature == Temperature.COLD || this.myTemperature == Temperature.WARM) {
                            this.myTemperature = Temperature.HOT;
                        } else if (this.myTemperature == Temperature.HOT) {
                            this.myTemperature = Temperature.BLAZING;
                        }
                        break;
                }
            }
        }
    }

    public void display() {
        System.out.println(this.mySetting.toString() + "....." + this.myTemperature.toString());
    }
}