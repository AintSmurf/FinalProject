package context;


import backend.HttpHelper;
import utils.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class TestContext {
    private HashMap<String, Object> map;


    public TestContext() {
        this.map = new HashMap<>();
    }
    public <T> T get(String key){
        log.info("trying to retrieve the object.");
        Object item = map.get(key);
        if(item!=null){
            return (T)item;
        }else{
            throw new IllegalArgumentException("Item not found in context");
        }
    }

    public void put(String key, Object item){
        log.info("added new object to the map.");
        map.put(key,item);
    }

    public void loginUi(String email, String password){
            HttpHelper.loginUi(WebDriverManager.initializeDriver(),email,password);
            log.info("Logged in successfully.");

    }

    public String getEmail() throws Exception {
        String email = System.getenv("EMAIL");
        if( email == null){
            throw new Exception("You need to execute the Credentials file.");
        }

        return email;
    }

    public String getPassword() throws Exception {
        String password = System.getenv("PASSWORD");
        if( password == null){
            throw new Exception("You need to execute the Credentials file.");
        }
        return password;
    }

}

