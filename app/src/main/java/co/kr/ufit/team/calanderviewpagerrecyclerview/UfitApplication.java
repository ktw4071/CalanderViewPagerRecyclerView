package co.kr.ufit.team.calanderviewpagerrecyclerview;

import android.app.Application;
import android.content.Context;

/**
 * Created by ccei on 2016-07-27.
 */
public class UfitApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
