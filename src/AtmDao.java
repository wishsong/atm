import java.util.HashMap;

public class AtmDao {
    FileProcessing fileProcessing = new FileProcessing();
    HashMap<String,User> userBankMap = fileProcessing.load();

    public User selectUser(String name){
        return userBankMap.get(name);
    }
    public void update(User user){
        userBankMap.put(user.getName(),user);
    }
    public void deleteUser(String name){
        userBankMap.remove(name);
    }
}
