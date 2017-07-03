package com.mohamed.monitor;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button connectButton, disConnectButton, monitorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInit();
        init();

    }

    void buttonInit(){
        connectButton = (Button)findViewById(R.id.connectButton);
        connectButton.setOnClickListener(this);
        disConnectButton = (Button)findViewById(R.id.disConnectButton);
        disConnectButton.setOnClickListener(this);
        monitorButton = (Button)findViewById(R.id.monitorButton);
        monitorButton.setOnClickListener(this);

    }
    void init(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.connectButton:
                startActivity(new Intent("android.intent.action.BT1") );
                break;
            case R.id.disConnectButton:
                Bluetooth.disconnect();
                break;
            case R.id.monitorButton:
                startActivity(new Intent(MainActivity.this ,Graph.class));
                break;
        }


    }
}
