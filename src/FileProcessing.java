import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class FileProcessing {
    public HashMap<String,User> load(){
        HashMap<String,User> UserBankMap = new HashMap<String,User>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            File file = new File("src//userBankFile.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String bu = bufferedReader.readLine();
            while(bu!=null){
                String[] bus = bu.split("-");
                User user = new User(bus[0],bus[1],Float.parseFloat(bus[2]));
                UserBankMap.put(user.getName(),user);
                bu = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return UserBankMap;
    }

    public void commit(HashMap<String,User> map){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            File file = new File("src//userBankFile.txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(String key:map.keySet()){
                StringBuilder builder = new StringBuilder(key);
                builder.append("-");
                builder.append(map.get(key).getPassword());
                builder.append("-");
                builder.append(String.valueOf(map.get(key).getMoneyNum()));
                bufferedWriter.write(String.valueOf(builder));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedWriter !=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
