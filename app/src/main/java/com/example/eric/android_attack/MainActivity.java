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

        Button btn_root = findViewById(R.id.btn_root);
        btn_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "su";
                Privilege.visitRuntime(s);
                Log.i("Privilege",  "Privilege visitRuntime  root");
            }
        });

        Button btn_chmod = findViewById(R.id.btn_chmod);
        btn_chmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "chmod 777 /data/data com.example.eric.android_attack\n";
                Privilege.visitRuntime(s);
                Log.i("Privilege",  "Privilege visitRuntime chmod");
            }
        });

        Button btn_sh = findViewById(R.id.btn_sh);
        btn_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "sh a.sh\n";
                Privilege.visitRuntime(s);
                Log.i("Privilege",  "Privilege visitRuntime sh");
            }
        });

        Button btn_ps = findViewById(R.id.btn_ps);
        btn_ps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "ps -e\n";
                Privilege.visitRuntime(s);
                Log.i("Privilege",  "Privilege visitRuntime ps");
            }
        });



        Button btn_other = findViewById(R.id.btn_other);
        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String s = "ls \n";
                Privilege.visitRuntime(s);
                Log.i("Privilege",  "Privilege visitRuntime other");
            }
        });

    }
}
