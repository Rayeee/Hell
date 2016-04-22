/**
 * Created by ZGY on 16/3/17.
 */
public class TestUserTarget {

    private String oneTwoThree;

    public TestUserTarget() {
    }

    public String getOneTwoThree() {

        return oneTwoThree;
    }

    public void setOneTwoThree(String oneTwoThree) {
        this.oneTwoThree = oneTwoThree;
    }

    public TestUserTarget(String oneTwoThree) {

        this.oneTwoThree = oneTwoThree;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestUserTarget{");
        sb.append("oneTwoThree='").append(oneTwoThree).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
