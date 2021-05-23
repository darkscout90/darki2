package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ChangeUser extends AppCompatActivity {
    Button insertUserBtn;
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextName2;
    EditText editTextLastName2;
    EditText editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user);

        insertUserBtn = findViewById(R.id.insertUserBtn);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);

        editTextName2 = findViewById(R.id.editTextName2);
        editTextLastName2 = findViewById(R.id.editTextLastName2);
        editTextPhone = findViewById(R.id.editTextPhone);
        insertUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Users users = Users.get(ChangeUser.this);

                users.changeUser( users.findUser(editTextName.getText().toString(),editTextLastName.getText().toString()),editTextName2.getText().toString(),editTextLastName2.getText().toString(),editTextPhone.getText().toString());
//                Users users = Users.get(AddUserActivity.this);
//                User user = new User();
//                user.setUserName(editTextName.getText().toString());
//                user.setUserLastName(editTextLastName.getText().toString());
//                user.setPhone(editTextPhone.getText().toString());
//                users.addUser(user);
                onBackPressed();
            }
        });

    }
}