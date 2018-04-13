package com.example.eric.android_attack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_runtime = findViewById(R.id.btn_runtime);
        btn_runtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String package_name = "com.aaaaa";
                String s = "pm uninstall " + package_name + "\n";
                privilege.visitRuntime(s);
                Log.i("privilege",  "privilege visitRuntime");
            }
        });
    }
}
