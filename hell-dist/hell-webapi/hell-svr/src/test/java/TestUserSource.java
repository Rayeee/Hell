/**
 * Created by ZGY on 16/3/17.
 */
public class TestUserSource {
    private String one_two_three;

    private String type;

    public TestUserSource(String one_two_three, String type) {
        this.one_two_three = one_two_three;
        this.type = type;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOne_two_three() {
        return one_two_three;
    }

    public void setOne_two_three(String one_two_three) {
        this.one_two_three = one_two_three;
    }

    public TestUserSource(String one_two_three) {
        this.one_two_three = one_two_three;
    }

    public TestUserSource() {
    }
}
