package BUS;

import DTO.*;
import GUI.*;
import java.util.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class CheckText {
  
    public static boolean haveNumber(String number){ // kt có số hay không
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
     
    public static boolean isLength(String ten){ // ký tự không quá 20 và không ít hơn 1
        if(ten.length() > 20 || ten.length() < 1)
        {
            return false;
        }
        return true;
    }
     
     public static boolean isName(String name){ // kt có chứa ký tự đặc biệt hay không
        String A = "[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]";
        Pattern pattern = Pattern.compile(A);
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()){
            return false;
        }
        return true;
        
    }
    
    public static boolean isDate(String date){
        Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find()) {
            return true;
        }
        return false;
        
    }
    
    
    public static boolean isGmail(String gmail){
        String A ="^[a-z0-9]{0,10}[@][a-z]{0,10}[.][a-z]{0,5}$";
        Pattern pattern = Pattern.compile(A,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(gmail);
        return matcher.matches();
    }
    
    public static boolean isPhoneNumber(String number){ // kt số điện thoại
        String A = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        Pattern pattern = Pattern.compile(A);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    
    public static boolean isUpper(String t){// Kt ký tự hoa
        String A ="[A-Z]";
        Pattern pattern = Pattern.compile(A);
        Matcher matcher = pattern.matcher(t);
        if(matcher.find())
            return false;
        return true;
    }
    
    public static boolean Date(String date){// Kt ngày tháng
        int count = 0;
        for(int i = 0; i < date.length(); i++){
            int space = 32;
            if(date.charAt(i) == space)
                count++;
        }
        if(count == 0){
           DateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY");
           dateformat.setLenient(false);
           try{
               Date d = dateformat.parse(date.trim());
               return true;
           }catch(ParseException ex){
               return false;
           }
        }else{
            return false;
        }
    }
    
    public static void Upper(String Arr){
        boolean flag = true;
        for(int i =0; i<= Arr.length(); i++){
            if(Character.isLetter(i)){
                if(flag){
                    i = Character.toUpperCase(i);
                    flag = false;
                }
            }
            else flag = true;
        }
    }
    
}
