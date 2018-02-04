package dp.school.utility.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by PC on 20/12/2017.
 */

public class PermissionUtils {
    public static final int PERMISSIONS_REQUEST_MULTI_PERMISSIONS = 6001;
    public static final int PERMISSIONS_REQUEST_CAPTURE_IMAGE = 6002;
    public static final int PERMISSIONS_REQUEST_WRITE_STORAGE = 6003;
    public static final int PERMISSIONS_REQUEST_READ_STORAGE = 6004;
    public static final int PERMISSIONS_REQUEST_CALL_PHONE = 6005;
    public static final int PERMISSIONS_REQUEST_SEND_SMS = 6006;
    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 6007;
    public static final int PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION= 6008;
    public static final int PERMISSIONS_REQUEST_GET_ACCOUNTS = 6009;



    public static boolean isGetAccountsPermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_GET_ACCOUNTS, Manifest.permission.GET_ACCOUNTS);
    }

    public static boolean isCameraPermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_CAPTURE_IMAGE, Manifest.permission.CAMERA);
    }

    public static boolean isWriteStoragePermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_READ_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static boolean isReadStoragePermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_WRITE_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    public static boolean isPhonePermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_CALL_PHONE, Manifest.permission.CALL_PHONE);
    }

    public static boolean isSmsPermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_SEND_SMS, Manifest.permission.SEND_SMS);
    }

    public static boolean isFineLocationPermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
    }
    public static boolean isCoarseLocationPermissionAvailable(Context context) {
        return checkPermissions(context, PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    private static boolean checkPermissions(Context context, int permissionRequestCode, String mainFestPermission) {
        String[] permissionArray = new String[]{mainFestPermission};
        if (ContextCompat.checkSelfPermission(context, mainFestPermission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, permissionArray, permissionRequestCode);
            return false;
        }
        return true;
    }

    public static boolean isMultiPermissionsAvailable(Context context, String[] permissionArray) {
        boolean isAllPermissionsWorking = true;
        for (int i = 0; i < permissionArray.length; i++) {
            if (ContextCompat.checkSelfPermission(context, permissionArray[i]) != PackageManager.PERMISSION_GRANTED) {
                isAllPermissionsWorking = false;
                break;
            }
        }
        if (!isAllPermissionsWorking) {
            ActivityCompat.requestPermissions((Activity) context, permissionArray, PERMISSIONS_REQUEST_MULTI_PERMISSIONS);
        }
        return isAllPermissionsWorking;
    }

}
