package Login;

import Login.Model.Account;
import Topic.TopicView.TopicView;

import java.util.HashMap;
import java.util.Scanner;

public class LoginController {
    TopicView view;
    HashMap<String,String> accounts;
    static Account account;
    Scanner sc = new Scanner(System.in);
    public LoginController(){
    }
    public void login() {
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        if (username.equals("admin") && password.equals("admin")){
            System.out.println("login");
        }
    }
}
