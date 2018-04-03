package com.gfee2.siddhi.signup_g2.view.adapter;

import android.animation.ArgbEvaluator;
import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import com.gfee2.siddhi.signup_g2.R;

@BindingMethods({
    @BindingMethod(type = ViewPager.class, attribute = "android:offscreenPageLimit", method = "setOffscreenPageLimit"),
    @BindingMethod(type = ViewPager.class, attribute = "android:adapter", method = "setAdapter"),
    @BindingMethod(type = ViewPager.class, attribute = "android:currentPage", method = "setCurrentItem")
}) public final class ViewPagerBinder {

  @InverseBindingAdapter(attribute = "android:currentPage", event = "android:currentPageAttrChanged")
  public static int getCurrentPage(@NonNull final ViewPager viewPager) {
    return viewPager.getCurrentItem();
  }

  @BindingAdapter(value = {
      "android:onPageScrolled", "android:onPageSelected", "android:onPageScrollStateChanged",
      "android:currentPageAttrChanged"
  }, requireAll = false)
  public static void onSetAdapter(@NonNull final ViewPager viewPager, final OnPageScrolled scrolled,
      final OnPageSelected selected, final OnPageScrollStateChanged scrollStateChanged,
      final InverseBindingListener currentPageAttrChanged) {

    final int color1 = R.color.cyan;
    final int color2 = R.color.orange;
    final int color3 = R.color.green;

    final int[] colorList = new int[] { color1, color2, color3 };
    final ArgbEvaluator evaluator = new ArgbEvaluator();

    final ViewPager.OnPageChangeListener newListener;
    if (scrolled == null
        && selected == null
        && scrollStateChanged == null
        && currentPageAttrChanged == null) {
      newListener = null;
    } else {
      newListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
          int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position],
              colorList[position == 2 ? position : position + 1]);
          viewPager.setBackgroundColor(colorUpdate);
        }

        @Override public void onPageSelected(int position) {
          switch (position) {
            case 0:
              viewPager.setBackgroundResource(color1);
              break;
            case 1:
              viewPager.setBackgroundResource(color2);
              break;
            case 2:
              viewPager.setBackgroundResource(color3);
              break;
          }
        }

        @Override public void onPageScrollStateChanged(int state) {

        }
      };
    }
    final ViewPager.OnPageChangeListener oldValue =
        ListenerUtil.trackListener(viewPager, newListener, R.id.page_change_listener);
    if (oldValue != null) {
      viewPager.removeOnPageChangeListener(oldValue);
    }
    if (newListener != null) {
      viewPager.addOnPageChangeListener(newListener);
    }
  }

  public interface OnPageScrolled {
    void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
  }

  public interface OnPageSelected {
    void onPageSelected(int position);
  }

  public interface OnPageScrollStateChanged {
    void onPageScrollStateChanged(int state);
  }

  private ViewPagerBinder() {
    throw new UnsupportedOperationException();
  }
}
