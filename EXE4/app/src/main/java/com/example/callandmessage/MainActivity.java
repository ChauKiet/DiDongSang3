package com.example.callandmessage;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.TelephonyManager;
import android.telephony.PhoneStateListener;


public class MainActivity extends AppCompatActivity {
    private final int CALL_REQUEST = 100;
    EditText txtPhone, txtMessage;
    Button btnSend, btnDial, btnCall;
    private TelephonyManager mTelephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        addControls();
        addEvents();
        // add PhoneStateListener for monitoring
        mTelephonyManager = (TelephonyManager) getSystemService(getApplicationContext().TELEPHONY_SERVICE);
    }

    private void addEvents() {
        btnSend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = txtPhone.getText().toString();
                String message = txtMessage.getText().toString();
                if (!TextUtils.isEmpty( phone ) || (!TextUtils.isEmpty( message ))) {
                    Uri sms_uri = Uri.parse( "smsto:+" + phone );
                    Intent sms_intent = new Intent( Intent.ACTION_SENDTO, sms_uri );
                    sms_intent.putExtra( "sms_body", message );
                    startActivity( sms_intent );
                } else {
                    Toast.makeText( MainActivity.this, "Enter a phone number or Enter a message", Toast.LENGTH_SHORT ).show();
                }
            }
        } );

        btnDial.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = txtPhone.getText().toString();
                if (!TextUtils.isEmpty( phone )) {
                    Intent intent = new Intent(
                            Intent.ACTION_DIAL,
                            Uri.parse( "tel:" + phone )
                    );
                    startActivity( intent );
                } else {
                    Toast.makeText( MainActivity.this, "Enter a phone number", Toast.LENGTH_SHORT ).show();
                }
            }
        } );

        btnCall.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = txtPhone.getText().toString();
                if (!TextUtils.isEmpty( phone )) {
                    if (ActivityCompat.checkSelfPermission( MainActivity.this, Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ActivityCompat.checkSelfPermission( MainActivity.this, Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling

                            ActivityCompat.requestPermissions( MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST );

                            return;
                        }
                    }
                    Intent intent = new Intent(
                            Intent.ACTION_CALL,
                            Uri.parse( "tel:" + phone )
                    );
                    startActivity( intent );
                } else {
                    Toast.makeText( MainActivity.this, "Enter a phone number", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }

    private void addControls() {
        txtPhone = findViewById( R.id.txtPhone );
        txtMessage = findViewById( R.id.txtMessage );
        btnCall = findViewById( R.id.btnCall );
        btnDial = findViewById( R.id.btnDial );
        btnSend = findViewById( R.id.btnSend );
    }
    PhoneStateListener mPhoneStateListener = new PhoneStateListener() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);

            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:
                    Toast.makeText(MainActivity.this, "CALL_STATE_IDLE", Toast.LENGTH_SHORT).show();
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    Toast.makeText(MainActivity.this, "CALL_STATE_RINGING", Toast.LENGTH_SHORT).show();
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Toast.makeText(MainActivity.this, "CALL_STATE_OFFHOOK", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
