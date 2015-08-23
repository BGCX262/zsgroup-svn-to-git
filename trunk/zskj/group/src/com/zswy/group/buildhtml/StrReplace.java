package com.zswy.group.buildhtml;


/**
 * Created by zywang
 * Date: 2006-8-28
 * Time: 20:01:42
 */
public class StrReplace {

      public static String replace(String strSource,String strFrom,String strTo){
        String strDest = "";
        if(strFrom.equals("")) return "";
        int intFromLen = strFrom.length();
        int intPos; 
 
        while((intPos=strSource.indexOf(strFrom))!=-1){
            strDest = strDest + strSource.substring(0,intPos);
            strDest = strDest + strTo;
            strSource = strSource.substring(intPos+intFromLen);
        }
        strDest = strDest + strSource;
        return strDest;
    }
}
