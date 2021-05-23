package com.example.secondapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.secondapp.database.UserBaseHelper;
import com.example.secondapp.database.UserDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {
    /*private String name;
    private String phone;*/
    private static Users users;
    private SQLiteDatabase database;
    private Context context;
    private List<String> userList;

    public static Users get(Context context){
        if (users == null){
            users = new Users(context);
        }
        return users;
    }

    private Users(Context context) {
        this.context = context.getApplicationContext();
        this.database = new UserBaseHelper(context).getWritableDatabase();
    }

    public void addUser(User user){ // Метод добавления пользователя в БД
        ContentValues values = getContentValues(user);
        database.insert(UserDbSchema.UserTable.NAME,null,values);
    }

    public void deleteUser(UUID u1){ // Метод удаления пользователя в БД
        //ContentValues values = getContentValues(user);
    //   database.delete(UserDbSchema.UserTable.NAME,"FIRSTNAME = eric",null);
       database.execSQL("delete from "+UserDbSchema.UserTable.NAME+" where uuid =" +"'"+u1+"'");
    }


    public void changeUser(UUID u1,String name,String lastname,String phone){ // Метод изменения пользователя в БД
        //ContentValues values = getContentValues(user);
        //   database.delete(UserDbSchema.UserTable.NAME,"FIRSTNAME = eric",null);
        database.execSQL("update "+UserDbSchema.UserTable.NAME+" set firstname = "+"'"+name+"'" +", lastname = "+"'"+lastname+"'" +  ", phone = "+"'"+phone+"'" +  " where uuid =" +"'"+u1+"'");
    }

    private static ContentValues getContentValues(User user){
        ContentValues values = new ContentValues();
        values.put(UserDbSchema.UserTable.Cols.UUID, user.getUuid().toString());
        values.put(UserDbSchema.UserTable.Cols.FIRSTNAME, user.getUserName());
        values.put(UserDbSchema.UserTable.Cols.LASTNAME, user.getUserLastName());
        values.put(UserDbSchema.UserTable.Cols.PHONE, user.getPhone());
        return values;
    }

    private UserCursorWrapper queryUsers(){
        Cursor cursor = database.query(UserDbSchema.UserTable.NAME,null,null,null,null,null,null);
        return new UserCursorWrapper(cursor);
    }
   // получение списка с юзерами
    public List<String> getUserList(){
        userList = new ArrayList<>();
        UserCursorWrapper cursorWrapper = queryUsers();
        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                User user = cursorWrapper.getUser();
                userList.add(user.getUserName()+" "+user.getUserLastName());
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }

        /*for (int i = 0; i < 100; i++) {
            this.userList.add("Человек_"+i);
        }*/
        return this.userList;
    }

    public UUID findUser(String name, String lastname){

        String kek= "desu";
        UUID u1 = null;
        UserCursorWrapper cursorWrapper = queryUsers();
        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                User user = cursorWrapper.getUser();
//                kek = user.getUserName();

                if (user.getUserName().equals(name) && (user.getUserLastName().equals(lastname))){
                    u1 = user.getUuid();
                }
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }

        /*for (int i = 0; i < 100; i++) {
            this.userList.add("Человек_"+i);
        }*/
        return u1;
    }
}
