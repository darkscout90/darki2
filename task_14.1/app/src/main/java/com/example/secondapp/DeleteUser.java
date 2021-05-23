package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteUser extends AppCompatActivity {
    Button insertUserBtn;
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        insertUserBtn = findViewById(R.id.insertUserBtn);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPhone = findViewById(R.id.editTextPhone);
        insertUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Users users = Users.get(DeleteUser.this);

                    users.deleteUser( users.findUser(editTextName.getText().toString(),editTextLastName.getText().toString()));
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