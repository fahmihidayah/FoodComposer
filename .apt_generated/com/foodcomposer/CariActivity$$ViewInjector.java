// Generated code from Butter Knife. Do not modify!
package com.foodcomposer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CariActivity$$ViewInjector {
  public static void inject(Finder finder, final com.foodcomposer.CariActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230723, "field 'editTextKategoriCari'");
    target.editTextKategoriCari = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230725, "field 'listViewKategoriCari'");
    target.listViewKategoriCari = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131230724, "method 'onClikCari'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClikCari(p0);
        }
      });
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

  public static void reset(com.foodcomposer.CariActivity target) {
    target.editTextKategoriCari = null;
    target.listViewKategoriCari = null;
  }
}
