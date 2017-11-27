package mchehab.com.fragmentlifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private LifecycleFragment lifecycleFragment = new LifecycleFragment();
    private final String TAG = "ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtonAttachFragmentOnClick();
        setButtonDetachFragmentOnClick();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    private void setButtonAttachFragmentOnClick(){
        findViewById(R.id.buttonAttachFragment).setOnClickListener(e -> {
            addFragment();
        });
    }

    private void setButtonDetachFragmentOnClick(){
        findViewById(R.id.buttonDetachFragment).setOnClickListener(e -> {
            removeFragment();
        });
    }

    private void addFragment(){
        getFragmentManager().beginTransaction().add(R.id.frameLayout, lifecycleFragment).commit();
    }

    private void removeFragment(){
        getFragmentManager().beginTransaction().remove(lifecycleFragment).commit();
    }
}