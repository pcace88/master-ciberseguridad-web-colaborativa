package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    
    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
        if (User.loadUser(username) != null) {
            String error = "Username already exists";
            render("PublicContentBase/register.html", error);
        } else {
            User u = new User(username, HashUtils.getMd5(password), type, -1);
            u.save();
            registerComplete();
        }
    }

    public static void registerComplete(){
        render();
    }

}
