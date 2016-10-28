package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import security.IUser;

@Entity
public class User implements IUser, Serializable{
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String password;  //Pleeeeease dont store me in plain text
  private String userName;
  List<String> roles = new ArrayList();

    public User() {
    }

  public User( String userName, String password) {
      this.userName = userName;
    this.password = password;
  }
  
  public User( String userName, String password,List<String> roles) {
    this.userName = userName;
    this.password = password;
    this.roles = roles;
  }
  
  
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", password=" + password + ", userName=" + userName + ", roles=" + roles + '}';
    }
  
  
  
    public void addRole(String role) {
        roles.add(role);
    }

    public int getId() {
        return id;
    }

    @Override
    public List<String> getRolesAsStrings() {
        return roles;
    }

  @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
