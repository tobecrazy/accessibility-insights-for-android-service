package com.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.microsoft.accessibilityinsightsforandroidservice.R;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.click_to_copy);
        button.setOnClickListener(v -> {
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText(getText(R.string.label), getText(R.string.command));
                    assert cm != null;
                    cm.setPrimaryClip(clip);
                    Toast.makeText(this, getText(R.string.command), Toast.LENGTH_LONG).show();
                }
        );


    }
}
