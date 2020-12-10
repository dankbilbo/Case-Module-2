package Login.Model;

import Const.Const.*;
import Login.Model.Account;

public class Admin extends Account {
    private String nickname = "admin";
    private String password = "admin";
    Role role = Role.ADMIN;
}
