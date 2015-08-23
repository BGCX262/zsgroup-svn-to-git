package com.zswy.group.buildhtml;

import java.io.*;

/**
 * Created by zywang
 * Date: 2006-8-28
 * Time: 19:32:10
 */
public class FileIO {

    static public String LoadFile(String strFileName){
        String str = "";
        char[] chrBuffer = new char[1];
        File objFile = new File(strFileName);
        try {
            if(objFile.exists()){
                FileReader  objFileReader = new FileReader(objFile);
                while((objFileReader.read(chrBuffer))!=-1){
                    str = str + String.valueOf(chrBuffer);
                }
                objFileReader.close();
            }
            else{
                System.out.println("�����ļ������ڣ�"+strFileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

   static synchronized public void SaveToFile(String strbody,String strFileName){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(strFileName));
            pw.println(strbody);
            pw.close();
        } catch(IOException e) {
            System.out.println("д���ļ�ʧ�ܣ�"+strFileName);
            e.printStackTrace();
        }
    }

    static synchronized public void SaveToFile(String strbody, String filename, String filepath){
       try{
            CheckFloder(filepath);
            FileOutputStream fileoutputstream = new FileOutputStream(filepath + filename);

            byte abyte0[] = strbody.getBytes();
            fileoutputstream.write(abyte0);
            fileoutputstream.close();
        }catch(IOException e){
            System.out.println("д���ļ�ʧ�ܣ�"+e.getMessage());
        }
    }

    static public boolean DelFile(String filepath){
        boolean flag = false;
        File file = new File(filepath);
        if (file.exists()){
            file.delete();
            flag = true;
        }
        return flag;
    }

    static public boolean ExistFloder(String foldpath){
        boolean flag = false;
        File file = new File(foldpath);
        if (file.isDirectory()){
            flag = true;
        }
        return flag;
    }

    static public boolean CreateFloder (String foldpath){
        boolean flag = true;
        File file = new File(foldpath);
        if (!file.exists()){
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

    static public boolean RemoveFloder(String foldpath){
        boolean flag = true;
        File file = new File(foldpath);
        if (file.exists()){
            try {
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

    static public boolean RemoveFloders(String foldpath){
        boolean flag = true;
        File file = new File(foldpath);
        try {
            FileIO.DeleteFolds(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    static public boolean DeleteFolds(File file) throws IOException {
        boolean flag = true;

        if(!file.exists()){
            System.out.println("ָ��Ŀ¼������:"+file.getName());
        }

        if(!(flag=file.delete())){
            File subs[] = file.listFiles();
            for (int i = 0; i <= subs.length - 1; i++) {
                if (subs[i].isDirectory())
                    DeleteFolds(subs[i]);
                flag = subs[i].delete();
            }
            flag = file.delete();
        }
        if(!flag){
            System.out.println("�޷�ɾ��:"+file.getName());
        }
        return flag;
    }

    static public void CheckFloder (String filepath){
        File file = new File(filepath);
        if (!file.exists()){
            try {
                file.mkdirs();
            } catch (Exception e) {
                System.out.println("�����ļ���ʧ�ܣ�"+filepath);
                e.printStackTrace();
            }
        }
    }
}
