import com.feng.dao.Userdao;
import com.feng.domain.UserInfo;
import com.feng.utils.BCryptPasswordEncoderUtils;
import com.feng.utils.Dateutil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        System.out.println(BCryptPasswordEncoderUtils.encodePassword("0517"));

    }
}
