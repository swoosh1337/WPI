
package Main;

import Exceptions.*;
import static Main.Main.register;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        
        try{
            register("saxeli", "gvari", "1234567810", "abcd@email.com",2077, 1, 2, "888888888", "name", "Password1");
            
        }catch(MainException ex){
            Exception exceptions[] = ex.getExceptions();
            for (int i=0; i<ex.getIndex(); i++){
                System.out.println(exceptions[i].getMessage());
               
            }
        }
        
    
       
        
        
    }
    
     public static void register(String name,String surname,String ID,String Email,int year,int month,int date,
                String number, String username,String password)throws MainException{
         
         MainException mainException = new MainException();
         
         try{
             validName(name);
         }catch(IllegalNameException ex){
             mainException.add(ex);
         }
         
         try{
             validSurname(surname);
                     }catch(IllegalSurnameException ex){   
                     mainException.add(mainException);

         }
                 
         try{
             validID(ID);
                     }catch(IllegalIDException ex){
                         mainException.add(mainException);
                     }
                         
        try{
            validEmail(Email);
        }catch(IllegalEmailException ex){
            mainException.add(ex);
        }                         
        
        try{
            validDate(year,month,date);
        }catch(IllegalDateException ex){
            mainException.add(ex);
        }
         
        try{
            validNumber(number);
        }catch(IllegalNumberException ex){
            mainException.add(ex);
            
        }
        
        try{
            validUsername(username); 
        }catch(IllegalUserNameException ex){
            mainException.add(ex);
        }
        
        try{
            validPassword(password);
     }catch(IllegalPasswordException ex){
         mainException.add(ex);
     }
     }
        public static void validName(String name)throws IllegalNameException{
            if(name.length()<2){
                throw new IllegalNameException("სახელის სიგრძე ნაკლებია ორზე");
            }
        }
        public static void validSurname(String surname) throws IllegalSurnameException{
            if(surname.length() < 2)
                throw new IllegalSurnameException("გვარის სიგრძე ნაკლებია ორზე");
        }
        
        public static void validID(String ID) throws IllegalIDException{
            if(ID.length() != 11)
                throw new IllegalIDException("ID არასწორია");
            
          for (int i=0; i<ID.length(); i++)
              if(ID.charAt(i) < '1' || ID.charAt(i) > '9')
           throw new IllegalIDException("ID არასწორია");

        }
        
        public static void validEmail(String Email) throws IllegalEmailException{
            
            if(Email.length() < 8)
                throw new IllegalEmailException("არასწორი ელ-ფოსტა");
            
            String arr1[] = Email.split("@");
            
            if(arr1.length != 2){
                throw new IllegalEmailException("არასწორი ელ-ფოსტა");
                        }
            String s = arr1[1];
            String arr2[] = s.split("\\.");
        if (arr2.length < 2){
            throw new IllegalEmailException("არასწორი ელ-ფოსტა");
        }
        }

public static void validDate(int year, int month, int date) throws IllegalDateException{
         if (month > 11 ){
            throw new IllegalDateException("არასწორი თარიღი!");
        }
        if (date > 30){
            throw new IllegalDateException("არასწორი თარიღი!");
        }
        if (year > 2015 || year < 1900)
            throw new IllegalDateException("არასწორი თარიღი!");
} 


public static void validNumber(String number) throws IllegalNumberException{
        for (int i=0; i<number.length(); i++){
            if (number.charAt(i) < '0' || number.charAt(i) > '9'){
                throw new IllegalNumberException("არასწორი ნომერი!");
            }
        }
}

  public static void validUsername(String username) throws IllegalUserNameException{
        if (username.length() < 4 || username.length() > 10){
            throw new IllegalUserNameException("არასწორი მომხმარებლის სახელი!");
        }
        }
    
    
    public static void validPassword(String password) throws IllegalPasswordException{
        if (password.length() < 6 || password.length() > 15){
            throw new IllegalPasswordException("არასწორი პაროლი!");
        }
        int x = 0;
        for (int i=0; i<password.length(); i++){
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                x++;
                break;
            }
        }
        for (int i=0; i<password.length(); i++){
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                x++;
                break;
            }
        }
        for (int i=0; i<password.length(); i++){
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                x++;
                break;
            }
        }
        if (x<3){
            throw new IllegalPasswordException("არასწორი პაროლი!");
        }
    }
}