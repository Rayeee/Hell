import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by ZGY on 16/2/23.
 */
public class TestMail {

    static String address1 = "120286605@qq.com";

    static String address2 = "985744492@qq.com";

    public static void main(String[] args) throws MessagingException {

        while(true){
            sendMail();
        }
    }

    public static void sendMail() throws MessagingException {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "false");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "email.ele.me");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 设置环境信息
        Session session = Session.getInstance(props);

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        msg.setSubject("(*^__^*) 嘻嘻……");
        // 设置邮件内容
        msg.setText("啦啦啦，哈哈哈！");
        // 设置发件人
        msg.setFrom(new InternetAddress("open.anubis.notify@ele.me"));

        Transport transport = session.getTransport();
        // 连接邮件服务器
        transport.connect("open.anubis.notify", "02231qaz@WSX");
        // 发送邮件
        transport.sendMessage(msg, new Address[] {new InternetAddress(address2)});
        // 关闭连接
        transport.close();
    }

}
