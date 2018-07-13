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
import android.widget.TextView;


/**
 * A login screen that offers login via username/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private EditText mUsernameView;
    private EditText mPasswordView;
    private TextView textView;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mUsernameView = findViewById(R.id.username);
        mPasswordView = findViewById(R.id.password);


        mUsernameView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textView = findViewById(R.id.usrLabel);
                textView.setVisibility(View.GONE);
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

        mUsernameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_NEXT) {
                    mPasswordView.setVisibility(View.VISIBLE);
                    textView = findViewById(R.id.passwdLabel);
                    textView.setVisibility(View.VISIBLE);
                    mPasswordView.requestFocus();

                    return true;
                }
                return false;
            }
        });

        mPasswordView.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textView = findViewById(R.id.passwdLabel);
                textView.setVisibility(View.GONE);
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





   loginButton =  findViewById(R.id.login_button);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

    }

    private void displayLoginButton(Boolean inputs) {
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

