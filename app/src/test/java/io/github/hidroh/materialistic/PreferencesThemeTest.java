package io.github.hidroh.materialistic;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowPreferenceManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class PreferencesThemeTest {

    private Activity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(Activity.class);
        shadowOf(activity.getTheme()).setTo(activity.getResources().newTheme());
    }

    @Test
    public void testDefaultTheme() {
        Integer originalTheme = shadowOf(activity).callGetThemeResId();
        Preferences.applyTheme(activity);
        assertThat(shadowOf(activity).callGetThemeResId()).isEqualTo(originalTheme);
    }

    @Test
    public void testDarkTheme() {
        ShadowPreferenceManager.getDefaultSharedPreferences(activity)
                .edit()
                .putString(activity.getString(R.string.pref_theme),
                        activity.getString(R.string.pref_theme_value_dark))
                .commit();
        Preferences.applyTheme(activity);
        assertThat(shadowOf(activity).callGetThemeResId()).isEqualTo(R.style.AppTheme_Dark);
    }
}
