package yinlei.com.userpermission;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 拨打电话
     */
    private void callPhone() {
        if (hasPermission(Manifest.permission.CALL_PHONE)) {
            doCallPhone();
        } else {
            requestPermission(Constants.CALL_PHONE_CODE, Manifest.permission.CALL_PHONE);
        }
    }

    /**
     * 子类去具体的实现打电话的业务逻辑
     */
    @Override
    public void doCallPhone() {
        super.doCallPhone();

        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + "10086");
        intent.setData(uri);
        startActivity(intent);
    }


    /**
     * 写入sdcard
     */
    private void sdCardPermission(){
        if (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            doSdCardPermission();
        } else {
            requestPermission(Constants.WRITE_READ_EXTERNAL_CODE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void doSdCardPermission() {
        super.doSdCardPermission();

    }
}
