package checktick.rebelo.com.checktick.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import checktick.rebelo.com.checktick.R;


/**
 * Created by rebelo on 24/04/2017.
 */

public class Util {
    public static void saveCheckTime(Context context, String checkTime) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(context.getString(R.string.key_check_time), checkTime);
        editor.apply();
    }

    public static void clearCheckTime(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(context.getString(R.string.key_check_time), context.getString(R.string.default_check_time));
        editor.apply();
    }

    public static String getCheckTime(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPrefs.getString(context.getString(R.string.key_check_time), context.getString(R.string.default_check_time));
    }
}
