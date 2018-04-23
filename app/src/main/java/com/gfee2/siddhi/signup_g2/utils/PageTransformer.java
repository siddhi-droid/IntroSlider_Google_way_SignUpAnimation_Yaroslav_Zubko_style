package com.gfee2.siddhi.signup_g2.utils;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.gfee2.siddhi.signup_g2.R;

public class PageTransformer implements ViewPager.PageTransformer {

  private static final float MIN_SCALE = 0.55f;
  private static final float MIN_ALPHA = 0.3f;

  @Override public void transformPage(View page, float position) {
    int pageWidth = page.getWidth();
    int pageHeight = page.getHeight();
    View sectionImg = page.findViewById(R.id.sectionImg);
    //View sectionImg2 = page.findViewById(R.id.section_img2);
    View sectionImg3 = page.findViewById(R.id.section_img3);
    View sectionLabel = page.findViewById(R.id.section_label);
    View sectionDesc = page.findViewById(R.id.section_desc);

    if (position < -1) { // [-Infinity,-1)
      // This page is way off-screen to the left.
      page.setAlpha(0);
    } else if (position <= 1) { // [-1,1]
      // Modify the default slide transition to shrink the page as well
      float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
      float vertMargin = pageHeight * (1 - scaleFactor) / 2;
      float horzMargin = pageWidth * (1 - scaleFactor) / 2;
      if (position < 0) {
        //page.setTranslationX(horzMargin - vertMargin / 2);
        sectionLabel.setTranslationX(/*horzMargin - vertMargin*/ (position) *(pageWidth/ 2));
        sectionImg.setTranslationX(/*horzMargin - vertMargin*/ (float) ((position) *(pageWidth/ (1.7))));
        sectionDesc.setTranslationX(/*horzMargin - vertMargin*/
            (float) ((position) *(pageWidth/ (0.5))));
        //sectionImg2.setTranslationX(/*horzMargin - vertMargin*/ (position) *(pageWidth/ 3));
        sectionImg3.setTranslationX(/*horzMargin - vertMargin*/
            (float) ((position) *(pageWidth/ (0.5))));
      } else {
       // page.setTranslationX(-horzMargin + vertMargin / 2);
        sectionLabel.setTranslationX(/*-horzMargin + vertMargin*/ (position) *(pageWidth/ 2));
        sectionImg.setTranslationX(/*horzMargin - vertMargin*/ (float) ((position) *(pageWidth/ (1.7))));
        sectionDesc.setTranslationX(/*horzMargin - vertMargin*/
            (float) ((position) *(pageWidth/ (0.5))));
        //sectionImg2.setTranslationX(/*horzMargin - vertMargin*/ (float) ((position) *(pageWidth/ (3.1))));
        sectionImg3.setTranslationX(/*horzMargin - vertMargin*/ (float) ((position) *(pageWidth/ (2.4))));
      }

      // Scale the page down (between MIN_SCALE and 1)
      /*page.setScaleX(scaleFactor);
      page.setScaleY(scaleFactor);*/

      // Fade the page relative to its size.
      page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
    } else { // (1,+Infinity]
      // This page is way off-screen to the right.
      page.setAlpha(0);
    }
  }
}
