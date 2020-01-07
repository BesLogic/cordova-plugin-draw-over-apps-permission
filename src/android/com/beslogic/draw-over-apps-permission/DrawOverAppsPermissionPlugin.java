package com.beslogic.drawoverappspermission;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.net.Uri;
import android.provider.Settings;
import android.app.Activity;

public class DrawOverAppsPermissionPlugin extends CordovaPlugin {

    public static final String CHECK_PERMISSIONS = "checkPermissions";
    public Activity activity;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        activity = this.cordova.getActivity();
        boolean actionState = true;
        if (action.equals(CHECK_PERMISSIONS)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!checkDrawOverAppsPermission(activity)) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,Uri.parse("package:" + activity.getPackageName()));
                    activity.startActivityForResult(intent, 0);
                }
            }
            callbackContext.success();
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDrawOverAppsPermission(Activity currentActivity) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(currentActivity);
        } else {
            return true;
        }

    }
}
