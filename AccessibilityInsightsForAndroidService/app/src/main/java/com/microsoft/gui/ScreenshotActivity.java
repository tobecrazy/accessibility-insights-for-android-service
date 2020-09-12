// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

package com.microsoft.gui;

import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.microsoft.accessibilityinsightsforandroidservice.AccessibilityInsightsForAndroidService;
import com.microsoft.accessibilityinsightsforandroidservice.MediaProjectionHolder;
import com.microsoft.accessibilityinsightsforandroidservice.R;
import com.microsoft.data.Constant;

public class ScreenshotActivity extends Activity {
    private MediaProjectionManager mediaManager;
    private static final int SCREENSHOT = 99999;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaManager = (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);
        if (mediaManager != null) {
            startActivityForResult(mediaManager.createScreenCaptureIntent(), SCREENSHOT);
        } else {
            showErrorMessage(getString(R.string.screenshot_permission_not_granted));
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SCREENSHOT) {
            if (resultCode == RESULT_OK) {
                MediaProjectionHolder.set(mediaManager.getMediaProjection(resultCode, data));
                if (MediaProjectionHolder.get() == null) {
                    showErrorMessage(getString(R.string.screenshot_permission_not_granted));
                }
            }
        }
        finish();
    }

    /**
     * @param message
     */
    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
