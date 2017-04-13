package pvsasoftware.mouseonscreeen;

import android.app.Service;
import android.content.Intent;
import android.graphics.Point;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by thien on 4/14/2017.
 */

public class Myservice extends Service {


    private int device_height;
    private int device_width;
    private int[] drawableArray;
    private ImageView mDesignMouse;
    private ImageView mDesignMouse2;
    private ImageView mDesignMouseFunny_Bottom;
    private ImageView mDesignMouse_top_right;

    private View mRootView;
    private WindowManager windowManager;
    private long mouse_duration;
    private int mouse_speed;


    private static WindowManager.LayoutParams createDefaultSystemWindownParams(boolean paramBoolean) {
        for (int i = 256;; i = 0) {
            WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1,-1,2006,i,-3);
            localLayoutParams.format = 1;
            return localLayoutParams;
        }
    }




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display localDisplay = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point point = new Point();
        localDisplay.getSize(point);
        this.device_height = point.x;
        this.device_width = point.y;
        this.drawableArray = new int[40];
        int i = 0;
        for (;;) {
            if ( i< 40) {
                try {
                    this.drawableArray[i] = getID("imgg_" + String.format("%04d",new Object[]{Integer.valueOf(i+1)}),R.drawable.class);
                } catch (Exception e) {
                    for (;;) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }

    public static int getID(String string,Class<?> class1) {
        try {
            Field field = class1.getDeclaredField(string);
            int  i = field.getInt(field);
            return i;
        } catch (Exception localException) {
            throw new RuntimeException("");
        }
    }





}
