package dmi.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button btn_iniciar;
    TextView tv_registrate;
    EditText et_correoLogin, et_contraLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_iniciar= findViewById(R.id.btn_iniciar);
        tv_registrate= findViewById(R.id.tv_registrarse);
        et_contraLogin= findViewById(R.id.et_contraLogin);
        et_correoLogin= findViewById(R.id.et_correoLogin);


        tv_registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
