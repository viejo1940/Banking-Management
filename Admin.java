package BankingProject;

public class Admin{
    private final String adminId;
    private final String  password;
    private Bank bankInstance;

    public Admin(String adminId,String password){
        this.adminId=adminId;
        this.password=password;
    }

    public Bank getBankInstance() {
        return bankInstance;
    }

    public void setBankInstance(Bank bankInstance) {
        this.bankInstance = bankInstance;
    }

    public String getAdminId() {
        return adminId;
    }
    public boolean validateLogin(String adminIdEnter,String passwordEnter){
        return    password.equals(passwordEnter)&& adminId.equals(adminIdEnter);
    }


}
