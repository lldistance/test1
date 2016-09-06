package com.example.a0905;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager dbManager=new DBManager(this);
        dbManager.insert("ll");

        try {
            InputStream in=getAssets().open("sms.db");
            File file=getExternalFilesDir("sms");
            File smsFile=new File(file,"sms.db");
            OutputStream out=new FileOutputStream(smsFile);
            byte[] buff=new byte[1024];
            int len=0;
                while ((len=in.read(buff))!=-1){
                    out.write(buff,0,len);
                }
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*InputStream in=getResources().openRawResource(R.raw.sms);
        File file=getExternalFilesDir("sms");
        File smsFile=new File(file,"sms.db");//创建的路径
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
        }*/
//        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(dbManager.getSmsFile(),null);
//        String sql="select ZNAME from ZSMSCATEGORY";
//        List<String> list=new ArrayList<>();
//        Cursor cursor=db.rawQuery(sql,null);
//        TextView textView= (TextView) findViewById(R.id.tv);
//        textView.setText("");
//        while (cursor.moveToNext()){
//            int ZNAMEIndex=cursor.getColumnIndex("ZNAME");
//            String ZNAME=cursor.getString(ZNAMEIndex);
//            textView.append(ZNAME+"\n");
//        }
//        db.close();

//        MySqliteOpenHelper openHelper=new MySqliteOpenHelper(this,"user.db",null,1);
//        SQLiteDatabase db=openHelper.getWritableDatabase();
//        String sql="insert into user(name,age,sex) values('baidu',18,'true')";
//        db.execSQL(sql);
//        ContentValues cv=new ContentValues();
//        cv.put("name","baiyu");
//        cv.put("age",20);
//        cv.put("sex","true");//bool要用字符串形式。否则变0和1
        //参数：表名，不添加数据的列，键值对ContentValues
//        db.insert("user","id",cv);
//        db.close();

//        String sql="delete from user where name='fenghuo'";
//        db.execSQL(sql);
        //参数：表名，条件，条件值
//        db.delete("user","name=?",new String[]{"fenghuo"});
//        db.close();

//        String sql="update user set age=27,sex='false' where id=4 and name='baiyu'";
//        db.execSQL(sql);
//        ContentValues cv=new ContentValues();
//        cv.put("age",29);
//        cv.put("sex","true");
        //参数：表名，键值对ContentValues，条件，条件值
//        db.update("user",cv,"id=? and name=?",new String[]{"4","baiyu"});
//        db.close();

        //"select name,age from user where name='baiyu'";
//        Cursor cursor=db.query("user",new String[]{"name","age"},"name=?",new String[]{"baidu"},null,null,null);
//        //获取显示的数据
//        List<User> list=new ArrayList<>();
//        while (cursor.moveToNext()){
//            int a=cursor.getColumnIndex("name");
//            String name=cursor.getString(a);
//            int b=cursor.getColumnIndex("age");
//            int age=cursor.getInt(b);
//            User user=new User();
//            user.setName(name);
//            user.setAge(age);
//            list.add(user);
//        }
//        TextView textView= (TextView) findViewById(R.id.tv);
//        textView.setText("");
//        for (User u:list
//             ) {
//            textView.append(u.getName()+" "+u.getAge()+" "+"\n");//在已有基础上增加
//        }
//        db.close();
    }
}
