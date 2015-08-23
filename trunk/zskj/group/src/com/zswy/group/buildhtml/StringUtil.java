/**
 * @(#) StringUtil.java
 * @version 1.0.1
 */
package com.zswy.group.buildhtml;


import java.util.Vector;
import java.io.UnsupportedEncodingException;

public class StringUtil
{
    public static boolean blnTextBox = true;

    /**
     * getGBKFromISO, translate it into Chinese
     * param String str, is father string
     * @return String, the chinese string
     */
    public static String getGBKFromISO(String str)
    {
        try{
            byte[] buf = str.getBytes("iso-8859-1");
            str = new String(buf,"gb2312");
            return str;
        }catch(java.io.UnsupportedEncodingException e){
            return "";
        }
    }

    public static String getISO(String str)
    {
        try{
            byte[] buf = str.getBytes("iso-8859-1");
            str = new String(buf);
            return str;
        }catch(java.io.UnsupportedEncodingException e){
            return "";
        }
    }

    /**
     * explode, separate string into a Vector
     * param String handleStr, is father string
     * param String pointStr, is separator
     * @return Vector, include separated string
     */
    public static Vector explode(String handleStr, String pointStr)
    {
        Vector v = new Vector();
        int pos1,pos2;
        try
        {
            if(handleStr.length()>0)
            {
                pos1 = handleStr.indexOf(pointStr);
                pos2 = 0;
                while(pos1 != -1)
                {
                    v.addElement(handleStr.substring(pos2,pos1));
                    pos2 = pos1+pointStr.length();
                    pos1 = handleStr.indexOf(pointStr,pos2);
                }
                v.addElement(handleStr.substring(pos2));
            }
        }catch(Exception error)
        {
            error.printStackTrace();
        }
        return v;
    }

    /**
     * replace, replace a string with another string in a string
     * param String handleStr, is father string
     * param String pointStr, is to-replaced string
     * param String repStr, is replaced string
     * @return string,
     */
    public static String replace(String handleStr, String pointStr, String repStr)
    {
        String str = new String();
        int pos1,pos2;
        try
        {
            if(handleStr.length()>0)
            {
                pos1 = handleStr.indexOf(pointStr);
                pos2 = 0;
                while(pos1 != -1)
                {
                    str += handleStr.substring(pos2,pos1);
                    str += repStr;
                    pos2 = pos1+pointStr.length();
                    pos1 = handleStr.indexOf(pointStr,pos2);
                }
                str += handleStr.substring(pos2);
            }
        }catch(Exception error)
        {
            error.printStackTrace();
        }
        return str;
    }

    public static void setReturn(boolean blnAttrib)
    {
        blnTextBox = blnAttrib;
    }

    /**
     * htmlspecialchars, Change HTML special char in String
     * param String handleStr, is father string
     * @return String
     */
    public static String htmlSpecialChars(String handleStr)
    {
        return htmlSpecialChars(handleStr, true);
    }

    public static String htmlSpecialChars(String handleStr, boolean seq)
    {
        String str = handleStr;

        if (seq){
            str = replace(str,"&","&amp;");
            str = replace(str,"\"","&quot;");
            str = replace(str,"<","&lt;");
            str = replace(str,">","&gt;");
        }else{
            str = replace(str,"&amp;","&");
            str = replace(str,"&quot;","\"");
            str = replace(str,"&lt;","<");
            str = replace(str,"&gt;",">");
        }

        if(!blnTextBox)
            if (seq)
                str = replace(str,"\n","<br>");
            else
                str = replace(str,"<br>","\n");

        return str;
    }
       /**
     * @param s
     * @return ȥ�����еĿո�
     */
    public static String trim(String s){

		StringBuffer temp=new StringBuffer("");
	      s=s.trim();   
	      String[] strtmp=s.split(" ");	      
	      for(int i=0;i<strtmp.length;i++)
	      {
	    	  temp.append(strtmp[i]);	    	  
	      }	      	    
	      return temp.toString();
    	
    	
    }
    /**
     * htmlspecialchars, replace '\n' with '<br>', used in page
     * param String handleStr, is father string
     * @return String
     */
    public static String returnChar2BR(String handleStr)
    {
        String str = handleStr;
        str = replace(str,"\n","<br>&nbsp;&nbsp;");
        return str;
    }

    /**
     * implode, link a vector into a string with a separate string
     * param Vector handler, is father vector
     * param String separator, is separator
     * @return String, linked string
     */
    public static String implode(Vector handler, String separator)
    {
        StringBuffer strbuf = new StringBuffer();
        try
        {
            if(!handler.isEmpty())
            {
                int len = handler.size();
                for(int loopi=0; loopi<len; loopi++)
                {
                    strbuf.append((String)handler.get(loopi));
                    if(loopi != len-1)
                        strbuf.append(separator);
                }
            }
        }catch(Exception error)
        {
            error.printStackTrace();
        }
        return strbuf.toString();
    }

    /**
     *  Return appointed String from a String Vector
     *	param1: String Vector
     *	param2: appointed Index
     *	param3: include Excel CSV process.
     */
    public static String getField(Vector vt, int i, boolean isExcel)
    {
        String str = "";
        try
        {
            str = (String)vt.get(i);
            if(str != null && str.length() > 2 && isExcel)
            {
                if(str.substring(0,1).compareTo("\"")==0)
                {
                    str = str.substring(1,str.length()-1);
                    str = StringUtil.replace(str,"\"\"","\"");
                }
            }
        }catch(ArrayIndexOutOfBoundsException aibe){
            System.out.println("Exceed the length of array, Please check the field number");
            return "";
        }
        return str;
    }

    /**
     * fill in inschar in string's left or right, in order to let string have appoint length.
     *	param1: father string
     *	param2: need fill in char
     *	param3: 0 is left fill in
     *	        1 is right fill in
     *	param4: total string length after fill in char
     */
    public static String insStr(String str,String InsChar,int intDirect ,int Len)
    {
        int intLen=str.length();
        StringBuffer strBuffer=new StringBuffer(str);

        if(intLen<Len)
        {
            int inttmpLen=Len-intLen;
            for(int i=0;i<inttmpLen;i++)
            {
                if(intDirect==1)
                {
                    str=str.concat(InsChar);
                }
                else if(intDirect ==0)
                {
                    strBuffer.insert(0,InsChar);
                    str=strBuffer.toString();
                }
            }
        }
        return str;
    }

    public static int searchDiv(String str,String divided)
    {
        String tmpsearchstr= new String();
        tmpsearchstr=str;
        divided=divided.trim();
        int divpos=-1;

        if(tmpsearchstr!="")
        {
            divpos=tmpsearchstr.indexOf(divided);

            return divpos;
        }
        else
            return 0;
    }

    public static String extractStr(String str,String startdiv,String enddiv)
    {
        //  String tmpsubstr= new String();
        int startdivlen=startdiv.length();
        //  int enddivlen=enddiv.length();
        str=str.trim();

        int startpos=-1;
        int endpos=-1;

        startdiv=startdiv.trim();
        enddiv=enddiv.trim();
        startpos=searchDiv(str,startdiv);
        if(str!="")
        {
            if(startpos>=0)
            {
                str=str.substring(startpos+startdivlen);
                str=str.trim();
            }
            endpos=searchDiv(str,enddiv);
            if(endpos==-1) return "";
            str=str.substring(0,endpos);
            str=str.trim();
        }
        return str;
    }

    public static String isNull(String str)
    {
        return isNull(str, "&nbsp;");
    }

    public static String isNull(String str, String def)
    {
        if (str == null)
            return def;
        else if (str.length() == 0)
            return def;
        else
            return str;
    }

    public static int StringToInt(String str)
    {
        return StringToInt(str, 0);
    }

    public static int StringToInt(String str, int def)
    {
        int intRet = def;
        try
        {
            intRet = Integer.parseInt(str);
        }
        catch(NumberFormatException e) {}
        return intRet;
    }

    public static float StringToFloat(String str)
    {
        return StringToFloat(str, 0);
    }

    public static float StringToFloat(String str, float def)
    {
        float fRet = def;
        try
        {
            fRet = Float.parseFloat(str);
        }
        catch(NumberFormatException e) {}
        return fRet;
    }

    public static double StringToDouble(String str)
    {
        return StringToDouble(str, (double)0);
    }

    public static double StringToDouble(String str, double def)
    {
        double dRet = (double)def;
        try
        {
            dRet = Double.parseDouble(str);
        }
        catch(NumberFormatException e) {}
        return dRet;
    }

    public static String getSafeString(String str)
    {
        if (str == null)
            return "";
        else
            return str.trim();
    }

    /**
     * ��������ַ��ȳ�����ָ���������ȡ
     * @param str �����ַ�
     * @param iLen ָ������
     * @return ��ʽ������ַ�
     */
    public static String substr(String str,int iLen)
    {
        if (str==null) return "";
        if (iLen>3)
        {
            if (str.length()>iLen-3)
            {
                str=str.substring(0,iLen-3)+"..." ;
            }
        }
        return str;
    }


    public static String UnicodeToChinese(String s){
        try{
            if(s==null||s.equals("")) return "";
            String newstring=null;
            newstring=new String(s.getBytes("ISO-8859-1"),"GBK");
            return newstring;
        }
        catch(UnsupportedEncodingException e)
        {
            return s;
        }
    }

    public static String substr2(String str,int strLen,int iLen)
    {
        if (str==null) return "";
        if (iLen>3)
        {
            if (str.length()>iLen-3)
            {
                str=str.substring(strLen,iLen-3)+"..." ;
            }


        }
        return str;
    }

    public static String getLimitLengthString(String str,String symbol,int len){
        String strtmp = "";
        if(str==null || str.trim().equals(""))
            return strtmp;
        try {
            int counterOfDoubleByte = 0;
            byte[] b = str.getBytes("GBK");

            if(b.length <= len)
                return str;

            for(int i = 0; i < len; i++){
                if(b[i] < 0)
                    counterOfDoubleByte++;
            }
            if(counterOfDoubleByte % 2 == 0)
                strtmp =  new String(b, 0, len, "gb2312") + symbol;
            else
                strtmp =  new String(b, 0, len - 1, "gb2312") + symbol;
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException = " + e);
        }
        strtmp = StringUtil.FilterHtmlCode(strtmp);
        return strtmp;
    }

    //�����ַ�תΪHtml
    public static String toHtml(String s){
        if(s == null){
            s = " ";
            return s;
        }
        s = Replace(s,"'","''");

        return s;
    }

    public static String toHtml2(String s){
        if(s == null){
            s = "";
            return s;
        }
        s = Replace(s,"&","&amp;");
        s = Replace(s,"<","&lt;");
        s = Replace(s,">","&gt;");
        s = Replace(s,"\t","    ");
        s = Replace(s,"\r\n","\n");
        s = Replace(s,"\n","<br>");
        s = Replace(s,"  "," &nbsp;");
        s = Replace(s,"'","&#39;");
        s = Replace(s,"\\","&#92;");
        s = Replace(s,"\"","&#34;");
        return s;
    }

    public static String toHtml3(String s){
        if(s == null){
            s = "";
            return s;
        }
        s = Replace(s,"\"","&#34;");
        s = Replace(s,"'","&#39;");
        return s;
    }

    public static String toHtml4(String s){
        if(s == null){
            s = "";
            return s;
        }
        s = Replace(s,"\n","<br>");
        s = Replace(s,"\r","");
        return s;
    }

    //��
    public static String unHtml(String s){
        s = Replace(s,"<br>","\n");
        s = Replace(s,"&nbsp;"," ");
        return s;
    }

    //StrReplace
    public static String Replace(String source,String oldString,String newString){
        if(source == null) return null;
        StringBuffer output = new StringBuffer();
        int lengOfsource = source.length();
        int lengOfold = oldString.length();
        int posStart = 0;
        int pos;
        while((pos = source.indexOf(oldString,posStart)) >= 0){
            output.append(source.substring(posStart,pos));
            output.append(newString);
            posStart = pos + lengOfold;
        }
        if(posStart < lengOfsource){
            output.append(source.substring(posStart));
        }
        return output.toString();
    }

    public static String ConvertIn(String s){
        if(s == null || s.trim().equals("")){
            s = " ";
            return s;
        }
        String temp=null;
        try{
           // temp = s;
            temp=new String(s.getBytes("UTF-8"),"gb2312");
        }catch(Exception e){
        }
        return temp;
    }

    public static String CommentFilter(String s){
        if(s == null || s.trim().equals("")){
            s = " ";
            return s;
        }         
        try{
            s = Replace(s,"<P>","");
            s = Replace(s,"</P>","");
            s = Replace(s,"<p>","");
            s = Replace(s,"</p>","");
        }catch(Exception e){
        }
        return s;
    }

    public static String FilterHtmlCode(String s){
        if(s == null || s.trim().equals("")){
            s = " ";
            return s;
        }
        try{
            s = s.replaceAll("<[^<>]+>","");
            s = Replace(s," ","");
            s = Replace(s,"&nbsp;","");
        }catch(Exception e){
        }
        return s;
    }
}
