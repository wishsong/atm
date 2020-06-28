import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        AtmService atmService = new AtmService();
        Scanner input = new Scanner(System.in);
        System.out.print("欢迎进入银行自助服务系统！\n---------------------\n请输入用户名：");
        String name  = input.nextLine();
        System.out.print("请输入密码：");
        String password = input.nextLine();
        if(atmService.login(name,password).equals("登陆成功！")){
            System.out.println("登陆成功！\n----------------------");
            while (true){
                System.out.println("请输入所需服务：\n[1]查询余额\t[2]存款\t[3]取款\t[4]转账\t[5]销户");
                String str = input.nextLine();
                switch(str) {
                    case "1": System.out.println("您的余额为："+atmService.checkMoney(name)+"元");break;
                    case "2":
                        System.out.print("请输入存款金额：");
                        atmService.saveMoney(name,input.nextLine());
                        break;
                    case "3":
                        System.out.print("请输入取款金额：");
                        atmService.getMoney(name,input.nextLine());
                        break;
                    case "4":
                        System.out.println("请输入转入账户：");
                        String str1 = input.nextLine();
                        System.out.println("请输入转入金额：");
                        String str2 = input.nextLine();
                        atmService.trans(name,str1,str2);
                        break;
                    case "5":
                        atmService.delete(name);
                    default:break;
                }
            }
        }else{
            System.out.println(atmService.login(name,password));
        }

    }
}
