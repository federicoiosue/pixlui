package com.neopixl.pixlui.links;

import android.text.style.ClickableSpan;
import android.view.View;

//This is class which gives us the clicks on the links which we then can
// use.

public class InternalURLSpan extends ClickableSpan {
	private String clickedSpan;
	private TextLinkClickListener mTextLinkClickListener;

	public InternalURLSpan(String clickedString) {
		clickedSpan = clickedString;
	}

	public void setTextLinkClickListener(TextLinkClickListener mTextLinkClickListener) {
		this.mTextLinkClickListener = mTextLinkClickListener;
	}

	@Override
	public void onClick(View view) {
		mTextLinkClickListener.onTextLinkClick(view, clickedSpan);
	}
}
