package ly.count.android.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.socks.library.KLog;

import java.util.HashMap;
import java.util.Map;

import ly.count.android.sdk.Countly;

public class ActivityExampleCustomEvents extends Activity {
    Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_custom_events);
        Countly.onCreate(this);

    }

    public void onClickRecordEvent01(View v) {
        Countly.sharedInstance().recordEvent("App_Event");
    }

    // 事件键和计数
    public void onClickRecordEvent02(View v) {
        Countly.sharedInstance().recordEvent("App_Event", 3);
    }

    // 事件键、计数和加和
    public void onClickRecordEvent03(View v) {
        Countly.sharedInstance().recordEvent("Custom event 3", 1, 134);
    }

    public void onClickRecordEvent04(View v) {
        Countly.sharedInstance().recordEvent("Custom event 4", null, 1, 0, 55);
    }

    public void onClickRecordEvent05(View v) {
        Map<String, String> segmentation = new HashMap<>();
        segmentation.put("advert_id", "green");
        segmentation.put("play_count", "1");
        Countly.sharedInstance().recordEvent("Record_Event", segmentation, 1, 0, 0);
    }

    public void onClickRecordEvent06(View v) {
        Map<String, String> segmentation = new HashMap<>();
        segmentation.put("wall", "red");
        Countly.sharedInstance().recordEvent("Custom event 6", segmentation, 15, 0, 0);
    }

    public void onClickRecordEvent07(View v) {
        Map<String, String> segmentation = new HashMap<>();
        segmentation.put("wall", "blue");
        Countly.sharedInstance().recordEvent("Custom event 7", segmentation, 25, 10, 0);
    }

    public void onClickRecordEvent08(View v) {
        Map<String, String> segmentation = new HashMap<>();
        segmentation.put("wall", "yellow");
        Countly.sharedInstance().recordEvent("Custom event 8", segmentation, 25, 10, 50);
    }

    public void onClickRecordEvent09(View v) {
        KLog.e();
        Countly.sharedInstance().startEvent("Custom event 9");
    }

    public void onClickRecordEvent10(View v) {
        Countly.sharedInstance().endEvent("Custom event 9");
    }

    public void onClickRecordEvent11(View v) {
        Map<String, String> segmentation = new HashMap<>();
        segmentation.put("wall", "orange");
        Countly.sharedInstance().endEvent("Custom event 9", segmentation, 4, 34);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Countly.sharedInstance().onStart(this);
    }

    @Override
    public void onStop()
    {
        Countly.sharedInstance().onStop();
        super.onStop();
    }
}
