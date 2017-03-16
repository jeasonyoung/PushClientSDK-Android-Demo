package linkus.pushclientsdkdemo;

import android.util.Log;
import android.widget.Toast;

import com.linkus.push.sdk.PushClientReceiver;
import com.linkus.push.sdk.models.AckResult;
import com.linkus.push.sdk.models.PublishModel;


/**
 * 推送消息接收
 * Created by jeasonyoung on 2017/3/14.
 */

public class PushReceiver extends PushClientReceiver {
    private static final String TAG = PushReceiver.class.getSimpleName();

    @Override
    protected String getAccount() {
        return MainActivity.PUSH_ACCOUNT;
    }

    @Override
    protected void receiverPublishHandler(String title, String content, PublishModel publishModel) {
        Log.d(TAG, "receiverPublishHandler["+ title +"]=>" + content);
        Toast.makeText(getContext(), title + "\n\n" + content, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void receiverErrorHandler(AckResult ackResult, String s) {
        Log.d(TAG, "receiverErrorHandler["+ ackResult +"]:" + s);
        Toast.makeText(getContext(), ackResult + "\n\n\n" + s, Toast.LENGTH_LONG).show();
    }
}