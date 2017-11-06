package com.keepassdroid.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.keepass.R;
import com.keepassdroid.AboutDialog;
import com.keepassdroid.settings.SettingsActivity;

public class MenuUtil {

    public static void defaultMenuInflater(MenuInflater inflater, Menu menu) {
        // TODO Flavor buy
        inflater.inflate(R.menu.donation, menu);
        inflater.inflate(R.menu.default_menu, menu);
    }

    public static boolean onDefaultMenuOptionsItemSelected(Activity activity, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_donate:
                try {
                    Util.gotoUrl(activity, R.string.donate_url);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity, R.string.error_failed_to_launch_link, Toast.LENGTH_LONG).show();
                    return false;
                }

                return true;
            case R.id.menu_about:
                AboutDialog dialog = new AboutDialog(activity);
                dialog.show();
                return true;

            case R.id.menu_app_settings:
                SettingsActivity.Launch(activity);
                return true;

            default:
                return true;
        }
    }
}
