package Di;

public class TestMain {
    public static void main(String[] args) {
        Test test = new Test(new DitestImpl2());

        test.show();
    }
}
