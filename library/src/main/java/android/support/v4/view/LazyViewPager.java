package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * There is a bug with the standard ViewPager implementation, when you set a PagerAdapter on the ViewPager
 * it always populates the first few items in the pager, even if you immediately call setCurrentItem().
 *
 * This pager waits until setCurrentItem is called before populating the Pager, so should hopefully be
 * less wasteful.
 */
public class LazyViewPager extends ViewPager {
    boolean currentItemSet = false;
    boolean setAdapterFlag = false;

    public LazyViewPager(Context context) {
        super(context);
    }

    public LazyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        setAdapterFlag = true;
        super.setAdapter(adapter);
        setAdapterFlag = false;
    }

    @Override
    void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        if(!setAdapterFlag) {
            currentItemSet = true;
        }
        super.setCurrentItemInternal(item, smoothScroll, always, velocity);
    }

    @Override
    void populate() {
        if(currentItemSet) {
            super.populate();
        }
    }
}
