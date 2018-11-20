import com.wechat.shop.entity.AccessToken;
import com.wechat.shop.utils.WeiXinUtils;

import java.io.IOException;

public class WeiXinTest {
    public static void main(String[] args) throws IOException {
        AccessToken token = WeiXinUtils.getAccessToken();
        System.out.println("Access_token为："+token.getAccessToken());
        System.out.println("有效时间为："+token.getExpiresIn());
    }
}
