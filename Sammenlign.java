class Sammenlign {
    public int a;
    public int b;

    public Sammenlign(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int se() {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}
