package backend;

import backend.pages.User;
import backend.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class HttpHelper {

    public static String getUser(String email, String password) throws URISyntaxException, IOException, InterruptedException {
        HashMap<String,String> userDet = Utils.getUserNameMap(email,password);
        String url = "/site/auth/login";
        return HttpFacade.post(url,userDet, User.class);
    }
}
