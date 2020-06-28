public class AtmService {
    AtmDao atmDao = new AtmDao();
    public String login(String name,String password){
        for(String str:atmDao.userBankMap.keySet()){
            User user = atmDao.selectUser(str);
            if(name.equals(user.getName())&&password.equals(user.getPassword())){
                return "登陆成功！";
            }
        }
        return "用户名或密码错误！";
    }
    public void saveMoney(String name, String money) {
        User user = atmDao.selectUser(name);
        user.setMoneyNum(user.getMoneyNum() + Float.parseFloat(money));
        atmDao.update(user);
        atmDao.fileProcessing.commit(atmDao.userBankMap);
        System.out.println("存款成功！\n您的最新余额为：" + user.getMoneyNum() + "元");
    }

    public void getMoney(String name, String money){
        User user = atmDao.selectUser(name);
        if(user.getMoneyNum()>Float.parseFloat(money)&&Float.parseFloat(money)>0){
            user.setMoneyNum(user.getMoneyNum()-Float.parseFloat(money));
            atmDao.update(user);
            atmDao.fileProcessing.commit(atmDao.userBankMap);
            System.out.println("取款成功！\n您的最新余额为："+user.getMoneyNum()+"元");
        }else{
            System.out.println("余额不足或输入有误！");
        }
    }
    public Float checkMoney(String name){
        User user = atmDao.selectUser(name);
        return user.getMoneyNum();
    }
    public void delete(String name){
        User user = atmDao.selectUser(name);
        atmDao.deleteUser(user.getName());
        atmDao.fileProcessing.commit(atmDao.userBankMap);
        System.out.println("销户成功！");
    }
    public void trans(String name1,String name2,String str){
        User user1 = atmDao.selectUser(name1);
        User user2 = atmDao.selectUser(name2);
        if(user1.getMoneyNum()>Float.parseFloat(str)&&Float.parseFloat(str)>0){
            user1.setMoneyNum(user1.getMoneyNum()-Float.parseFloat(str));
            user2.setMoneyNum(user2.getMoneyNum()+Float.parseFloat(str));
            atmDao.update(user1);
            atmDao.update(user2);
            atmDao.fileProcessing.commit(atmDao.userBankMap);
            System.out.println("转账成功！\n您最新余额为"+user1.getMoneyNum());
        }else{
            System.out.println("余额不足或输入有误！");
        }
    }
}
