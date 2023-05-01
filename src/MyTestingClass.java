public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    /*
     * Knuth's Multiplicative Method
     * 
     * @see https://gist.github.com/badboy/6267743#knuths-multiplicative-method
     */
    @Override
    public int hashCode() {
        long hashedValue = (long) id * 2654435761L;
        return Math.abs((int) (hashedValue ^ (hashedValue >>> 32)));
    }

}