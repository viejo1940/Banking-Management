package BankingProject;

public class LoginSystem{
    private final Bank bank;
    private  Admin loggedAdmin;

    public LoginSystem(Bank bankID){
        bank=bankID;
    }
    public boolean loginAdmin(String adminId,String password){
        Admin admin =bank.findAdmin(adminId);

        if (admin!=null && admin.validateLogin(adminId, password)){
            this.loggedAdmin=admin;
            this.loggedAdmin.setBankInstance(bank);
            System.out.println("Admin logged in successfully");
            return true;
        }
        System.out.println("invalid admin credentials .");
        return false;
    }
    public void logoutAdmin(){
        if(this.loggedAdmin != null){
            this.loggedAdmin = null;
            System.out.println("Admin logged out successfully .");
        }else {
            System.out.println("Admin currently logged in .");
        }
    }

    public  Admin getLoggedAdmin() {
        return loggedAdmin;
    }
    public  void setLoggedAdmin(Admin loggedAdmin){
        this.loggedAdmin=loggedAdmin;
    }
}
