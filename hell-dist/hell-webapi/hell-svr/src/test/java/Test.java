import org.springframework.beans.BeanUtils;
import winter.hell.util.BeanAndDtoTransfer;

/**
 * Created by ZGY on 16/3/17.
 */
public class Test {
    public static void main(String[] args) {
        TestUserSource source = new TestUserSource("shit", "222");
        TestUserTarget target = BeanAndDtoTransfer.transOneToAnother(source, TestUserTarget.class, true);
        System.out.println(target.toString());
    }
}
