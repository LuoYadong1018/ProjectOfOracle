package com.lyd.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lyd.dao.PwdDao;
import com.lyd.projectoforacle.R;

public class Login  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final EditText txtpwd=(EditText) findViewById(R.id.txtLogin);
        final EditText txtuser=(EditText) findViewById(R.id.txtLogin1);
        Button btlogin=(Button) findViewById(R.id.btlogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, MainActivity.class);
                PwdDao pwdDAO=new PwdDao(Login.this);
                if(pwdDAO.getCount()==0||pwdDAO.find().getPwd().isEmpty()){
                    if(txtpwd.getText().toString().isEmpty()){
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "请不要输入任何密码登录", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    if(pwdDAO.find().getPwd().equals(txtpwd.getText().toString())){
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                    }
                }
                txtpwd.setText("");
            }
        });

        Button btclose=findViewById(R.id.btexit);
        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
