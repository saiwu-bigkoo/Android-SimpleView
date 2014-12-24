package com.simpleview.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/**
 * 不滚动的GridView，所有Item直接全部显示，用于兼容在ScrollView里面
 */
public class NotScrollGridView extends GridView{
	public NotScrollGridView(Context context) {
		super(context);
	}
	public NotScrollGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * 设置不滚动
	 */
	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
