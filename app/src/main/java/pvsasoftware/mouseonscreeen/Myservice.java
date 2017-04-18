package pvsasoftware.mouseonscreeen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Service;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.Random;
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
    private TranslateAnimation animation;

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
        this.mRootView = LayoutInflater.from(this).inflate(R.layout.home,null,false);
        this.mDesignMouse_top_right = (ImageView)mRootView.findViewById(R.id.design_mouse_top_right);
        this.mDesignMouseFunny_Bottom = (ImageView)mRootView.findViewById(R.id.funny_mouse_bottom);
        Point point = new Point();
        localDisplay.getSize(point);
        this.device_height = point.x;
        this.device_width = point.y;
        this.drawableArray = new int[40];
        for (int i = 0;i < 40; i++) {
            if ( i< 40) {
                try {
                    this.drawableArray[i] = getID("imgg_" + String.format("%04d",new Object[]{Integer.valueOf(i+1)}), android.R.drawable.class);
                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
        }
        startMouse();

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

    private void startMouse() {
        setOverLay();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setOverLay2();
            }
        },8000);
        this.windowManager.addView(mRootView,createDefaultSystemWindownParams(true));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_NOT_STICKY;
    }

    public void setOverLay() {
        BitmapDrawable bd = (BitmapDrawable)getResources().getDrawable(R.drawable.r1_imgg_0004);
        final int img_height = bd.getBitmap().getHeight();
        final int img_width = bd.getBitmap().getWidth();
        int[] resArray = new int[40];
        for (int i = 0;i<40;i++) {
            try {
                resArray[i] = getID("r1_imgg_" + String.format("%04d",new Object[]{Integer.valueOf(i+1)}),R.drawable.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int j = 0; j< 40;j++) {
            animationDrawable.addFrame(getResources().getDrawable(resArray[j]),80);
        }
        animationDrawable.setOneShot(false);
        this.mDesignMouse_top_right.setImageDrawable(animationDrawable);
        animationDrawable.start();
        animation = new TranslateAnimation(0.0f,0.0f,(float)(-img_height),this.device_height);
        this.animation.setDuration(8000);
        this.mDesignMouse_top_right.startAnimation(animation);
        this.animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                int i = device_width;
//                int j = img_height/2;
//                 i = new Random().nextInt(((i-j-0 +1 ) + 0));
//                mDesignMouse_top_right.layout(i,-j,mDesignMouse_top_right.getMeasuredWidth()+i,j+mDesignMouse_top_right.getMeasuredHeight());
                // mDesignMouse_top_right.setX(device_height/3);
                //mDesignMouse_top_right.setY(device_height/3);
                mDesignMouse_top_right.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void setOverLay2() {
        BitmapDrawable bd = (BitmapDrawable)getResources().getDrawable(R.drawable.r1_imgg_0004);
        final int img_height = bd.getBitmap().getHeight();
        final int img_width = bd.getBitmap().getWidth();
        int[] resArray = new int[40];
        for (int i = 0;i<40;i++) {
            try {
                resArray[i] = getID("r1_imgg_" + String.format("%04d",new Object[]{Integer.valueOf(i+1)}),R.drawable.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int j = 0; j< 40;j++) {
            animationDrawable.addFrame(getResources().getDrawable(resArray[j]),80);
        }
        animationDrawable.setOneShot(false);
        this.mDesignMouseFunny_Bottom.setImageDrawable(animationDrawable);
        animationDrawable.start();
        animation = new TranslateAnimation((float)-img_width,this.device_width,0.0f,0.0f);
        this.animation.setDuration(10000);
        this.mDesignMouseFunny_Bottom.startAnimation(animation);
        this.animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                int i = device_width;
//                int j = img_height/2;
//                 i = new Random().nextInt(((i-j-0 +1 ) + 0));
//                mDesignMouse_top_right.layout(i,-j,mDesignMouse_top_right.getMeasuredWidth()+i,j+mDesignMouse_top_right.getMeasuredHeight());
                // mDesignMouse_top_right.setX(device_height/3);
                //mDesignMouse_top_right.setY(device_height/3);
                mDesignMouseFunny_Bottom.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
