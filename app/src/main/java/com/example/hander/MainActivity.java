package com.example.hander;

import android.os.*;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            ((TextView) findViewById(R.id.textView)).setText(msg.obj.toString());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Messenger messenger = new Messenger(handler);
        findViewById(R.id.button).setOnClickListener(v -> {
            Message message = new Message();
            message.obj = ((EditText) findViewById(R.id.editTextTextPersonName)).getText();
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }
}