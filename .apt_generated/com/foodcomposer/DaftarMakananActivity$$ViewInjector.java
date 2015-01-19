// Generated code from Butter Knife. Do not modify!
package com.foodcomposer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DaftarMakananActivity$$ViewInjector {
  public static void inject(Finder finder, final com.foodcomposer.DaftarMakananActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230726, "field 'listViewMakanan'");
    target.listViewMakanan = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131230722, "method 'onClickTambah'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickTambah(p0);
        }
      });
  }

  public static void reset(com.foodcomposer.DaftarMakananActivity target) {
    target.listViewMakanan = null;
  }
}
