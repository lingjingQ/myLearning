package 华为;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=0,b=0,c=0,d=0,e=0;
        int err=0;
        int pri=0;
        String str;
        String[] ip_mask;
        String[] ip;
        String[] mask;
        int i;
        while((str=br.readLine())!=null){
            ip_mask=str.split("~");
            ip=ip_mask[0].split("\\.");
            mask=ip_mask[1].split("\\.");
            //count error mask
            if(checkMask(ip_mask[1])){//mask correct
                //count ip
                if(checkIp(ip)){
                    i=Integer.parseInt(ip[0]);
                    if(i>=1&&i<=126){//a
                        a++;
                        if(i==10){
                            pri++;
                        }
                    }else if(i>=128&&i<=191){//b
                        b++;
                        if(i==172&&Integer.parseInt(ip[1])>=16&&Integer.parseInt(ip[1])<=31){
                            pri++;
                        }
                    }else if(i>=192&&i<=223){//c
                        c++;
                        if(i==192&&Integer.parseInt(ip[1])==168){
                            pri++;
                        }
                    }else if(i>=224&&i<=239){//d
                        d++;
                    }else if(i>=240&&i<=255){//e
                        e++;
                    }
                }else{
                    err++;
                }
            }else{
                err++;
            }
        }
        //output
        System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+err+" "+pri);
    }
    public static boolean checkMask(String mask)
    {

        //check mask
        String[] mask_arr=mask.split("\\.");
        if(mask_arr[0].equals("255"))
        {
            if(mask_arr[1].equals("255"))
            {
                if(mask_arr[2].equals("255"))
                {
                    if(
                            mask_arr[3].equals("254")||mask_arr[3].equals("252")||mask_arr[3].equals("248")||
                                    mask_arr[3].equals("240")||mask_arr[3].equals("224")||mask_arr[3].equals("192")||
                                    mask_arr[3].equals("128")||mask_arr[3].equals("0"))
                        return true;
                    else
                        return false;
                }
                else if(mask_arr[2].equals("254")||mask_arr[2].equals("252")||mask_arr[2].equals("248")||
                        mask_arr[2].equals("240")||mask_arr[2].equals("224")||mask_arr[2].equals("192")||
                        mask_arr[2].equals("128")||mask_arr[2].equals("0"))
                {
                    if(mask_arr[3].equals("0"))
                        return true;
                    else
                        return false;
                }
                else
                    return false;

            }
            else if(mask_arr[1].equals("254")||mask_arr[1].equals("252")||mask_arr[1].equals("248")||
                    mask_arr[1].equals("240")||mask_arr[1].equals("224")||mask_arr[1].equals("192")||
                    mask_arr[1].equals("128")||mask_arr[1].equals("0"))
            {
                if(mask_arr[2].equals("0")&&mask_arr[3].equals("0"))
                    return true;
                else
                    return false;
            }
            else
            {
                return false;
            }

        }
        else if(mask_arr[0].equals("254")||mask_arr[0].equals("252")||mask_arr[0].equals("248")||
                mask_arr[0].equals("240")||mask_arr[0].equals("224")||mask_arr[0].equals("192")||
                mask_arr[0].equals("128")||mask_arr[0].equals("0"))
        {
            if(mask_arr[1].equals("0")&&mask_arr[2].equals("0")&&mask_arr[3].equals("0"))
                return true;
            else
                return false;
        }
        else
        {
            return false;
        }

    }
    static boolean checkIp(String[] ip){
        if(ip.length==4&&!ip[0].equals("")&&!ip[1].equals("")&&!ip[2].equals("")&&!ip[3].equals("")){
            return true;
        }
        return false;
    }
}