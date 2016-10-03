package yinlei.com.userpermission;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wuyinlei on 2016/10/3.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * 为子类提供一个权限的检查方法
     * @param permissions  需要的权限
     * @return  false  true
     */
    public boolean hasPermission(String... permissions){
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this,permission)
                    != PackageManager.PERMISSION_GRANTED){

                return false;
            }
        }
        return true;
    }

    /**
     * 为子类提供一个权限的请求方法
     * @param code
     * @param permissions
     */
    public void requestPermission(int code ,String... permissions){
        ActivityCompat.requestPermissions(this,permissions,code);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case Constants.WRITE_READ_EXTERNAL_CODE:
                doSdCardPermission();
                break;
            case Constants.CALL_PHONE_CODE:
                doCallPhone();
                break;
        }
    }

    /**
     * 默认的打电话权限
     */
    public void doCallPhone() {

    }

    /**
     * 写入sdcard权限
     */
    public void doSdCardPermission() {


    }
}
