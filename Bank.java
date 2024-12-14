package BankingProject;

import java.util.ArrayList;

public class Bank{
    private int bankId;
    private String name;
    private String location;
    public ArrayList<User> users;
    private ArrayList<Admin> admins;
    public Bank(String name,String location,int bankId){
        this.bankId=bankId;
        this.name=name;
        this.location=location;
        this.admins=new ArrayList<>();
        this.users=new ArrayList<>();
        Admin admin1 = new Admin("1", "testadmin");
        this.addAdmin(admin1);
    }
    public void addAdmin(Admin admin){
        admins.add(admin);
        System.out.println("New admin with id " + admin.getAdminId() + " added");
    }
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully with ID  "+ user.getUserId());
    }
    public User findUser(String userId){
        for(User user : users){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }


    public Admin findAdmin(String adminId){
        for (Admin admin:admins){
            if(admin.getAdminId().equals(adminId)){
                return admin;
            }
        }
        return null;
    }

    public void depositMoy(User user,double amount){
        User userData = this.findUser(user.getUserId());
        userData.getAcount().deposit(amount);
    }
    public void withdrawMoy(User user,double amount){
        User userData = this.findUser(user.getUserId());
        userData.getAcount().withdraw(amount);
    }
    public  void getBalanceInfo(User user){
        User userData = this.findUser(user.getUserId());
        System.out.println("User ID: "+ userData.getUserId());
        System.out.println("Balance: "+ userData.getAcount().getBalance());


    }

    public void deleteAcct(User user){
        users.remove(user);

    }
    public void deleteOperation(User user, Operation operationToDelete) {
        Acount acount=user.getAcount();
        acount.getOperations().removeIf(operation -> operation.getType().equals(operationToDelete.getType())&&
                operation.getAmount()==operationToDelete.getAmount()&&
                operation.getDate().equals(operationToDelete.getDate())
        );
    }

    public String getName() {
        return name;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}
