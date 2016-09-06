package com.example.a0905;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/9/5.
 */
public class DBManager {
    private File smsFile;

    public File getSmsFile() {
        return smsFile;
    }

    public void setSmsFile(File smsFile) {
        this.smsFile = smsFile;
    }

    public DBManager(Context context){
        File file=context.getExternalFilesDir("sms");//源路径
        smsFile=new File(file,"sms.db");//创建的路径
        if(smsFile.exists()){
            return;
        }else{
            copy(context);
        }
    }

    private void copy(Context context) {
        InputStream in=context.getResources().openRawResource(R.raw.sms);
        OutputStream out=null;
        try {
            out=new FileOutputStream(smsFile);
            byte[] buff=new byte[1024];
            int len=0;
            while ((len=in.read(buff))!=-1){
                out.write(buff,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void insert(String zName){
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(smsFile,null);
        String sql="insert into ZSMSCATEGORY(ZNAME) values('"+zName+"')";
        db.execSQL(sql);
        db.close();
    }



}
