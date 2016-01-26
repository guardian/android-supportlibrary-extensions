package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * A {@link ViewPager} subclass that's lockable and which has a customisable scroll
 * velocity.
 *
 * @author Max Spencer <max.spencer@guardian.co.uk>
 */
public class CustomVelocityViewPager extends ViewPager {

    private int velocity = 1;
    private boolean isPagingEnabled = true;

    public CustomVelocityViewPager(Context context) {
        super(context);
    }

    public CustomVelocityViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    void smoothScrollTo(int x, int y, int velocity) {
        //ignore passed velocity, use one defined here
        super.smoothScrollTo(x, y, this.velocity);
    }

    public boolean getPagingEnabled() {
        return isPagingEnabled;
    }

    public void setPagingEnabled(boolean b) {
        isPagingEnabled = b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return isPagingEnabled && super.onInterceptTouchEvent(event);
    }

}