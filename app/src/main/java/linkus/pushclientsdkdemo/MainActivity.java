package linkus.pushclientsdkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linkus.push.sdk.PushClientSDK;

public class MainActivity extends AppCompatActivity {

    private static final String PUSH_HOST = "http://162.16.4.36:8080/";
    public static final String PUSH_ACCOUNT = "test";
    private static final String PUSH_TOKEN = "123456";
    private static final String PUSH_DEVICE_TOKEN = "android-push-test-demo";

    private PushClientSDK sdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        try {
            sdk = new PushClientSDK(this);
        }catch (Exception e){
            showToast(e.getMessage());
        }
        //启动socket按钮
        final Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(((Button)v).getText());
                try {
                    sdk.start(PUSH_HOST, PUSH_ACCOUNT, PUSH_TOKEN, PUSH_DEVICE_TOKEN);
                }catch (Exception ex){
                    showToast(ex.getMessage());
                }
            }
        });
        //关闭socket
        final Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showToast(((Button)v).getText());
                try {
                    sdk.stop();
                }catch (Exception ex){
                    showToast(ex.getMessage());
                }
            }
        });
        //
        final EditText txtTag = (EditText)findViewById(R.id.txtTag);
        //绑定设备标签
        final Button btnAddTag = (Button) findViewById(R.id.btnAddTag);
        btnAddTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String tag = txtTag.getText().toString();
                showToast(((Button)v).getText() + ":" + tag);
                try {
                    sdk.addOrChangedTage(tag);
                }catch (Exception ex){
                    showToast(ex.getMessage());
                }
            }
        });
        //解除设备标签
        final Button btnClearTag = (Button)findViewById(R.id.btnClearTag);
        btnClearTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(((Button)v).getText());
                try {
                    sdk.clearTag();
                }catch (Exception ex){
                    showToast(ex.getMessage());
                }
            }
        });
    }

    //若提示
    private void showToast(final CharSequence msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(sdk != null) sdk.close();
    }
}