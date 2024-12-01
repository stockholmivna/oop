class Quality {
    private int value;

    public Quality(int value) {
            this.value = Math.min(50, Math.max(0, value));
        }

    public int getValue() {
        return value;
    }

    public void increase() {
        if (value < 50) value += 1;
    }

    public void decrease() {
        if (value > 0) value -= 1;
    }

    public void reset() {
        value = 0;
    }
}
