package com.example.andres.flixnet;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.SignInButton;

public class LoginActivity extends AppCompatActivity {

    //Temporal
    private final String DUMMY_USER = "Tony";
    private final String DUMMY_PASSWORD = "IronMan";

    private EditText nomUsu, password;
    private Button btnLogin, btnRegister;
    //private SignInButton signInGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Instancionamos y referenciamos los elementos del layout
        nomUsu = findViewById(R.id.loginUsuario);
        password = findViewById(R.id.loginPassword);
        btnLogin = findViewById(R.id.loginButton);
        btnRegister = findViewById(R.id.registerButton);

        //Funcionalidad al botón de registro (new OnClick...)
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intención de lanzar la actividad de registro
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                intent.putExtra("msg","Bienvenido al registro de FlixNet");
                startActivity(intent);
            }
        });

        //Funcionalidad al botón de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intención de lanzar la actividad postlogeo
                String usr = nomUsu.getText().toString().trim();
                String psw = password.getText().toString().trim();

                Log.d("FLIXNETLOGIN", "Usuario: " + usr + ", Pass: "
                    + psw);

                if (usr.isEmpty() || psw.isEmpty()) {
                    Snackbar.make(view, R.string.login_error_login_vacia, Snackbar.LENGTH_LONG).show();
                } else if (usr.equals(DUMMY_USER) && psw.equals(DUMMY_PASSWORD)) {
                    Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                    startActivity(intent);
                } else {
                    Snackbar.make(view, R.string.login_error_login, Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }
}
