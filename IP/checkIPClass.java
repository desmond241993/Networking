// Java program to check the class of an IPv4 address.

import java.lang.*;
import java.util.*;

class IP{
    private String IPAddress;
    
    // Constructor
    public IP(String IPAddress){
        this.IPAddress = IPAddress;
    }
    
    // IP validation
    public boolean ipValidate(){
        String[] ipOctets = IPAddress.split("\\.");
        // if there are not exactly 4 octets (or three dot separators)
        if(ipOctets.length != 4){
            //System.out.println("The IP contains "+ipOctets.length+" octets.");
            return false;
        }
        for(String oct: ipOctets){
            // if length of each octet is not between 1 and 3 (inclusive)
            if(oct.length() == 0 || oct.length() >3){
                //System.out.println("The IP contains an octet of length "+oct.length()+".");
                return false;
            }
            // if there are extra leading zeroes
            if(oct.charAt(0) == '0' && oct.length() != 1){
                //System.out.println("The IP contains extra leading zeroes.");
                return false;
            }
            // if the value of an octet is more than 255
            if(Integer.parseInt(oct) > 255){
                //System.out.println("The IP contains an octet of value more than 255");
                return false;
            }
            // if all octets are not just digits
            for(char c: oct.toCharArray()){
                if(!Character.isDigit(c)){
                    //System.out.println("The IP contains non-digits.");
                    return false;
                }
            }
        }
        return true;
    }
    
    /* Function to identify IP class
        Class A: 0 - 127
        Class B: 128 - 191
        Class C: 192 - 223
        Class D: 224 - 239
        Class E: 240 - 255
    */
    public String getIPClass(){
        String ipClass = "";
        
        if(!ipValidate()){
            return IPAddress+" is an Invalid IP Address";
        }
        
        // Extract the first octet and convert into int to identify the class
        int firstOctet = Integer.parseInt(IPAddress.split("\\.")[0]);
        
        if(firstOctet >=0 && firstOctet <=127){
            ipClass = IPAddress+": Class A";
        }
        else if(firstOctet >=128 && firstOctet <=191){
            ipClass = IPAddress+": Class B";
        }
        else if(firstOctet >=192 && firstOctet <=223){
            ipClass = IPAddress+": Class C";
        }
        else if(firstOctet >=224 && firstOctet <=239){
            ipClass = IPAddress+": Class D";
        }
        else if(firstOctet >=240 && firstOctet <=255){
            ipClass = IPAddress+": Class E";
        }
        
        return ipClass;
    }
}


public class checkIPClass
{
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
	  System.out.print("Enter an IP (IPv4): ");
	  String ip = sc.nextLine();
	  IP ip1 = new IP(ip);
		System.out.println(ip1.getIPClass());
	}
}
