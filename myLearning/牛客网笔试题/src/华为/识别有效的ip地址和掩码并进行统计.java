package 华为;


import java.util.*;
public  class 识别有效的ip地址和掩码并进行统计 {
    public static void main(String[]args){
        int typeA=0;
        int typeB=0;
        int typeC=0;
        int typeD=0;
        int typeE=0;
        int error=0;
        int privateIp=0;
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String information=s.next();
            String [] info=information.split("~");
            if(info==null||info.length!=2)
                break;
            String ip=info[0];
            String mask=info[1];
            String []ips=ip.split("\\.");
            if(ips==null||ips.length<4)
            {
                error+=1;
                //  System.out.println("out..");
                continue;
            }
            int v=Integer.parseInt(ips[0]);

            int two=Integer.parseInt(ips[1]);
            //process mask
            boolean isMask=checkMask(mask);
            if(!isMask){
                error+=1;
                continue;//不进行下面处理
            }
            //处理ip地址
            if(v>=1&&v<=126)
                typeA++;
            else if(v>=128&&v<=191)
                typeB+=1;
            else if(v>=192&&v<=223)
                typeC+=1;
            else if(v>=224&&v<=239)
                typeD+=1;
            else if(v>=240&&v<=255)
                typeE+=1;
            if(v==10||(v==172&&two>=16&&two<=31)||(v==192&&two==168))
                privateIp+=1;
        } //end while
        System.out.println(typeA+" "+typeB+" "+typeC+" "+typeD+" "+typeE+" "+error+" "+privateIp);
    }
    public static boolean checkMask(String mask){
        String []masks=mask.split("\\.");
        int v=-1;
        int changeTime=0;//计算相邻数不同的次数
        for(int i=masks.length-1;i>=0;i--){
            int times=0;
            int value=Integer.parseInt(masks[i]);
            while(times<8){
                if((value&1)!=v)
                {
                    changeTime+=1;
                    v=value&1;
                }
                if(changeTime>=3)
                    return false;
                value>>=1;
                times++;
            } //end while
        } //end for
        return changeTime==2?true:false;
    }
}
