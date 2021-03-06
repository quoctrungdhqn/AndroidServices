package com.quoctrungdhqn.androidservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.quoctrungdhqn.androidservices.boundservice.BoundServiceActivity;
import com.quoctrungdhqn.androidservices.unboundservice.UnBoundServiceActivity;

public class MainActivity extends AppCompatActivity {

    Button btnUnBoundService, btnBoundService, btnIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUnBoundService = findViewById(R.id.btn_unbound_service);
        btnBoundService = findViewById(R.id.btn_bound_service);

        initHandle();
    }

    private void initHandle() {
        btnUnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UnBoundServiceActivity.class));
            }
        });

        btnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BoundServiceActivity.class));
            }
        });
    }
}
