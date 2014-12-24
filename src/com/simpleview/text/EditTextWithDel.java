package com.simpleview.text;

import com.simpleview.R;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
/**
 * 带删除按钮的输入框 
 * */
public class EditTextWithDel extends EditText {
	private Drawable imgDel;
	private Context mContext;

	public EditTextWithDel(Context context) {
		super(context);
		mContext = context;
		init();
	}

	public EditTextWithDel(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		init();
	}

	public EditTextWithDel(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}
	
	private void init() {
		setText("");
		imgDel = mContext.getResources().getDrawable(R.drawable.editdel_delete);
		addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override
			public void afterTextChanged(Editable s) {
				setDrawable();
			}
		});
		setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				setDrawable();
			}
		});
		setDrawable();
	}
	
	//设置删除图片
	private void setDrawable() {
		if(length() < 1||!hasFocus())
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		else
			setCompoundDrawablesWithIntrinsicBounds(null, null, imgDel, null);
	}
	
	 // 处理删除事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgDel != null && event.getAction() == MotionEvent.ACTION_UP) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 50;
            if(rect.contains(eventX, eventY)) 
            	setText("");
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    @Override
	public void setText(CharSequence text, BufferType type) {
		if (text == null) {
			text = "";
		}
		super.setText(text, type);
	}

}

