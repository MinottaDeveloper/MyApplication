package dmi.com.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_correo, et_contra;
    Button btn_registrar;
    TextView tv_irRegistro;

    FirebaseDatabase firebaseDatabase;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth= FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();



        et_nombre= findViewById(R.id.et_nombre);
        et_contra= findViewById(R.id.et_contra);
        et_correo=  findViewById(R.id.et_correo);
        btn_registrar= findViewById(R.id.btn_registrar);
        tv_irRegistro= findViewById(R.id.tv_irRegistro);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Usuario usuario= new Usuario(et_nombre.getText().toString(), et_correo.getText().toString(), et_contra.getText().toString());
                firebaseDatabase.getReference().child("usuario").push().setValue(usuario);*/

               auth.createUserWithEmailAndPassword(et_correo.getText().toString(), et_contra.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       Log.e(">>>",""+task.getException());
                       if(task.isSuccessful()){
                           Usuario usuario= new Usuario(et_nombre.getText().toString(), et_correo.getText().toString(), et_contra.getText().toString());
                           usuario.setUid(auth.getCurrentUser().getUid());
                           firebaseDatabase.getReference().child("usuarios").child(usuario.getUid()).setValue(usuario);
                       }else{

                       }
                   }
               });


            }
        });


        tv_irRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
