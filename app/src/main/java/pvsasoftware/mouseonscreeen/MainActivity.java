
package pvsasoftware.myapplication;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 23 && (!Settings.canDrawOverlays(getApplicationContext()))) {
                    startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:"+ getPackageName())),100);
                } else {
                    MainActivity.this.startService(new Intent(getApplicationContext(),Myservice.class));
                    Intent newIntent = new Intent("android.intent.action.MAIN");
                    newIntent.addCategory("android.intent.category.HOME");
                    startActivity(newIntent);
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (Build.VERSION.SDK_INT >= 23 && Settings.canDrawOverlays(this)) {
                MainActivity.this.startService(new Intent(getApplicationContext(),Myservice.class));
                Intent newIntent = new Intent("android.intent.action.MAIN");
                newIntent.addCategory("android.intent.category.HOME");
                startActivity(newIntent);
            }
        } else {
            return;
        }
    }
}
