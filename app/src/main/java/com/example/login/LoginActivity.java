package com.example.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.R;
import com.example.settings.SettingsActivity;
import android.content.Intent;

/**
 * A login screen that offers login via username/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mUsernameView;
    private EditText mPasswordView;
    private Button loginButton;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mUsernameView = (AutoCompleteTextView) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
        imageView = (ImageView) findViewById(R.id.logoView);

        mUsernameView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = mUsernameView.getText().toString();
                String password = mPasswordView.getText().toString();
                displayLoginButton(verifyInputs(email, password));
            }
        });

        mPasswordView.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println("Prueba uno exitosa");
                String email = mUsernameView.getText().toString();
                String password = mPasswordView.getText().toString();
                displayLoginButton(verifyInputs(email, password));
            }
        });


        mUsernameView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (view.hasFocus()){
                    findViewById(R.id.usrLabel).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.usrLabel).setVisibility(View.GONE);
                }
            }
        });


        mPasswordView.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View view, boolean b) {
                if (view.hasFocus()){
                    findViewById(R.id.passwordLabel).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.passwordLabel).setVisibility(View.GONE);
                }
            }
        });

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsActivity = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(settingsActivity);
            }
        });

        loginButton = (Button) findViewById(R.id.button_next);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

    }

    private void displayLoginButton(Boolean inputs) {
        System.out.println("Llego al displayLoginButton");
        if(inputs){
            attemptLogin();
            loginButton.setVisibility(View.VISIBLE);
        } else {
            loginButton.setVisibility(View.GONE);
        }
    }

    private void displayErrors(Boolean inputs){
        // Reset errors.
        mUsernameView.setError(null);
        mPasswordView.setError(null);
    }

    private boolean verifyInputs(String username, String password){
            mUsernameView.setError(null);
            mPasswordView.setError(null);

            return isUsernameValid(username) && isPasswordValid(password);
    }



    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        System.out.println("Intento de login");
        loginButton.setVisibility(View.GONE);


    }

    private boolean isUsernameValid(String username) {
        //TODO: Replace this with your own logic
        return !username.isEmpty();
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 8;
    }


}

