import java.io.*;
import java.util.*;
public class PrintEncodeing
{
    public static void main(String []args)throws Exception{
        Scanner s=new Scanner(System.in);
        String str=s.next();
        pritnencodeing(str,"");
    }
    //input 123 = output[abc,aw,lc]
    //special case it should not start with 0 because int a,b,c,.. it begin with (1 to 26)
    // no value should be there more than 26 means the value which u will choose it should be less or equal to 26
    //eg 303 ,013 =not possible

    public static void pritnencodeing(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        else if(ques.length()==1){ //means there is only one char
            char ch=ques.charAt(0);  //choose that char first then
            if(ch=='0'){   //and that char is also 0 so no ans
                return;
            }
            else{  //if that one char is some value life '1','2'etc then first convert from ASSIC
                int chv=ch-'0';   //'6'-->6
                char code=(char)('a'+chv-1);
                System.out.println(ans+code);
            }
        }
        else{  //more than 1 char or value is there
            char ch= ques.charAt(0);
            String restofques=ques.substring(1);

            if(ch=='0'){
                return;
            }
            else{
                int chv=ch-'0';
                char code=(char)('a'+chv-1);
                pritnencodeing(restofques,ans+code);
            }
            String ch12=ques.substring(0,2);//1234=12
            String restofques12=ques.substring(2);//1234=34
            int chv1=Integer.parseInt(ch12);
            if(chv1<=26){
                char code=(char)('a'+chv1-1);
                pritnencodeing(restofques12,ans+code);
            }
        }
    }
}
