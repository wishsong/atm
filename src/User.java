public class User {
    private String name;
    private String password;
    private float moneyNum;

    public User(){}
    public User(String name,String password,Float moneyNum){
        this.name = name;
        this.password = password;
        this.moneyNum = moneyNum;
    }

    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public float getMoneyNum(){
        return this.moneyNum;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setMoneyNum(float moneyNum){
        this.moneyNum = moneyNum;
    }
}
