package BankingProject;

public class User{
 private String userId;
 private String name;
 private String email;
 private int phoneNumber;
 private  final Acount acount;
 public User(String userId,String name,int phoneNumber,String email){
     this.userId=userId;
     this.name=name;
     this.phoneNumber=phoneNumber;
     this.email=email;
     this.acount= new Acount();
 }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberPhone(int numberPhone) {
        this.phoneNumber = numberPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Acount getAcount(){
     return this.acount;
    }

    public String viewPersonalInfo(){
     return "User Id: "+ userId + " \n" + "name :"+ name + "\n" + "Number Phone :"+ phoneNumber + "\n"+ " email "+ email + " \n" + "Balance :" +acount.getBalance();
 }
    public void modifyPersonalInfo(String name,Integer phoneNumber,String email){
     if(name!=null){
         setName(name);
     }
     if(phoneNumber!=null){
         setNumberPhone(phoneNumber);
     }
     if(email!=null){
         setEmail(email);
     }


 }

    public String getUserId() {
     return userId;
    }
}
