// Generated code from Butter Knife. Do not modify!
package com.foodcomposer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.foodcomposer.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230721, "method 'onClickMetode'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickMetode(p0);
        }
      });
    view = finder.findRequiredView(source, 2131230720, "method 'onClickMenuMakanan'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickMenuMakanan(p0);
        }
      });
  }

  public static void reset(com.foodcomposer.MainActivity target) {
  }
}
