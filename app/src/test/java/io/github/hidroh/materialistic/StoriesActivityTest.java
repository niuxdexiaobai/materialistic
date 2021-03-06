package io.github.hidroh.materialistic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;

import io.github.hidroh.materialistic.data.ItemManager;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class StoriesActivityTest {
    @Test
    public void testShowActivity() {
        ActivityController<ShowActivity> controller = Robolectric.buildActivity(ShowActivity.class);
        ShowActivity activity = controller.create().start().resume().get();
        assertEquals(activity.getString(R.string.title_activity_show), activity.getDefaultTitle());
        assertEquals(ItemManager.FetchMode.show, activity.getFetchMode());
        controller.pause().stop().destroy();
    }

    @Test
    public void testNewActivity() {
        ActivityController<NewActivity> controller = Robolectric.buildActivity(NewActivity.class);
        NewActivity activity = controller.create().start().resume().get();
        assertEquals(activity.getString(R.string.title_activity_new), activity.getDefaultTitle());
        assertEquals(ItemManager.FetchMode.newest, activity.getFetchMode());
        controller.pause().stop().destroy();
    }

    @Test
    public void testAskActivity() {
        ActivityController<AskActivity> controller = Robolectric.buildActivity(AskActivity.class);
        AskActivity activity = controller.create().start().resume().get();
        assertEquals(activity.getString(R.string.title_activity_ask), activity.getDefaultTitle());
        assertEquals(ItemManager.FetchMode.ask, activity.getFetchMode());
        controller.pause().stop().destroy();
    }

    @Test
    public void testJobsActivity() {
        ActivityController<JobsActivity> controller = Robolectric.buildActivity(JobsActivity.class);
        JobsActivity activity = controller.create().start().resume().get();
        assertEquals(activity.getString(R.string.title_activity_jobs), activity.getDefaultTitle());
        assertEquals(ItemManager.FetchMode.jobs, activity.getFetchMode());
        controller.pause().stop().destroy();
    }
}
