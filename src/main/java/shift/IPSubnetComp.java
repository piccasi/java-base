package shift;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: IPSubnetComp
 * @Since: 1.0
 * @Version: v1.0
 * @Date: 2022/5/6 7:58 下午
 * @Author: piccasi@163.com
 * @Description: 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
 **/

public class IPSubnetComp {

    public static int compare(String ip1, String ip2, String mask) {
        String[] ip1Arr = ip1.split("\\.");
        String[] maskArr = mask.split("\\.");
        String[] ip2Arr = ip2.split("\\.");

        int ret = 1;
        int i = 0;
        for( ; i < ip1Arr.length; ++i){
            int ip1Set = Integer.parseInt(ip1Arr[i]);
            int ip2Set = Integer.parseInt(ip2Arr[i]);
            int ipMask = Integer.parseInt(maskArr[i]);

            if(ip1Set > 255 || ip2Set > 255 || ipMask > 255){
                ret = 1;
                break;
            }

            if(i == 0 && (ip1Set <= 0 || ip2Set <= 0 || ipMask <= 0)){
                ret = 1;
                break;
            }

            if(ip1Set < 0 || ip2Set < 0 || ipMask < 0){
                ret = 1;
                break;
            }

            if((ip1Set & ipMask) != (ip2Set & ipMask)){
                ret = 2;
                break;
            }
        }

        if (i == ip1Arr.length){
            ret = 0;
        }

        return ret;
    }

    public static void main(String[] args) {
        String ip1 = "192.168.224.256";
        String ip2 = "192.168.10.4";
        String mask = "255.255.255.0";

        int ret = compare(ip1, ip2, mask);

        System.out.println(ret);
    }
}
