package backend.utils;

import java.util.HashMap;

public class Utils {
    public static  HashMap<String,String> getUserNameMap(String email,String password){
        HashMap<String,String> userDet = new HashMap<>();
        userDet.put("username",email);
        userDet.put("password",password);
        return  userDet;
    }
}
