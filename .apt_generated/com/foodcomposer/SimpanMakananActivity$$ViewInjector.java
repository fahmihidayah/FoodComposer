// Generated code from Butter Knife. Do not modify!
package com.foodcomposer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SimpanMakananActivity$$ViewInjector {
  public static void inject(Finder finder, final com.foodcomposer.SimpanMakananActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230733, "field 'editTextNamaBahanMakanan'");
    target.editTextNamaBahanMakanan = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230739, "field 'editTextJenisMasakan'");
    target.editTextJenisMasakan = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230741, "field 'listViewBahanMakanan'");
    target.listViewBahanMakanan = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131230738, "method 'onClickSimpan'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickSimpan(p0);
        }
      });
    view = finder.findRequiredView(source, 2131230740, "method 'onClickTambahBahanMakanan'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickTambahBahanMakanan(p0);
        }
      });
  }

  public static void reset(com.foodcomposer.SimpanMakananActivity target) {
    target.editTextNamaBahanMakanan = null;
    target.editTextJenisMasakan = null;
    target.listViewBahanMakanan = null;
  }
}
