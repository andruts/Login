package com.example.settings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.R;

public class SettingsActivity extends Activity{

    private EditText serviceLogin;

    private EditText serviceWaste;

    private EditText serviceApp;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        serviceLogin = (EditText) findViewById(R.id.serviceLogin);

        serviceWaste = (EditText) findViewById(R.id.serviceWaste);

        serviceApp = (EditText) findViewById(R.id.serviceApp);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        getApplicationContext(),
                        "Login: " + serviceLogin.getText() +"\n Mermas: "+ serviceWaste.getText() + "\n App: " + serviceApp.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
