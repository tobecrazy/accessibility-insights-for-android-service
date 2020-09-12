package com.microsoft.gui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.microsoft.accessibilityinsightsforandroidservice.R;

public class MainActivity extends AppCompatActivity {
    Button copyButton;
    Button settingButton;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyButton = findViewById(R.id.click_to_copy);
        copyButton.setOnClickListener(v -> {
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText(getText(R.string.label), getText(R.string.command));
                    assert cm != null;
                    cm.setPrimaryClip(clip);
                    Toast.makeText(this, getText(R.string.command), Toast.LENGTH_LONG).show();
                }
        );
        settingButton = findViewById(R.id.click_to_setting);
        settingButton.setOnClickListener(v -> {
            Intent settings = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(settings);
        });

    }
}
