// Generated code from Butter Knife. Do not modify!
package com.foodcomposer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SimpanBahanMakananActivity$$ViewInjector {
  public static void inject(Finder finder, final com.foodcomposer.SimpanBahanMakananActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230735, "field 'editTextSatuanUrt'");
    target.editTextSatuanUrt = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230737, "field 'editTextTakaran'");
    target.editTextTakaran = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230733, "field 'editTextNamaBahanMakanan'");
    target.editTextNamaBahanMakanan = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230738, "method 'onClickSimpan'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickSimpan(p0);
        }
      });
  }

  public static void reset(com.foodcomposer.SimpanBahanMakananActivity target) {
    target.editTextSatuanUrt = null;
    target.editTextTakaran = null;
    target.editTextNamaBahanMakanan = null;
  }
}
