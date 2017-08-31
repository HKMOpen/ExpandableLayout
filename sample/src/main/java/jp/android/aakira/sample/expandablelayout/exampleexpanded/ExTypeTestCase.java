package jp.android.aakira.sample.expandablelayout.exampleexpanded;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import jp.android.aakira.sample.expandablelayout.R;

/**
 * Created by hesk on 31/8/2017.
 */

public class ExTypeTestCase extends AppCompatActivity implements View.OnClickListener {


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, ExTypeTestCase.class));
    }

    private RelativeLayout mExpandButton;
    private ExpandableRelativeLayout mExpandLayout;
    private LinearLayout mContainer;
    private Button mShowAdd;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_scrollable);

        getSupportActionBar().setTitle(ExampleReadMoreActivity.class.getSimpleName());

        mShowAdd = (Button) findViewById(R.id.add);
        mExpandButton = (RelativeLayout) findViewById(R.id.part_fb);
        mExpandLayout = (ExpandableRelativeLayout) findViewById(R.id.info_box_fb);
        mContainer = (LinearLayout) findViewById(R.id.part_fb_box);
        mExpandButton.setOnClickListener(this);
        mShowAdd.setOnClickListener(this);

        mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //mExpandLayout.move(mContainer.getHeight(), 0, null);
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mContainer.getViewTreeObserver().removeGlobalOnLayoutListener(mGlobalLayoutListener);
                } else {
                    mContainer.getViewTreeObserver().removeOnGlobalLayoutListener(mGlobalLayoutListener);
                }
                mExpandLayout.setExpanded(false);
            }
        };
        mContainer.getViewTreeObserver().addOnGlobalLayoutListener(mGlobalLayoutListener);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.add:
                View a = LayoutInflater.from(this).inflate(R.layout.p_fa, mContainer, false);
                mContainer.addView(a);
                //  mExpandLayout.addView(a);
                mExpandLayout.initLayout();
                //..mExpandLayout.move(199);
                break;
            case R.id.part_fb:
                mExpandLayout.toggle();

                //mExpandLayout.move(12, 0, null);
                //mExpandButton.setVisibility(View.GONE);
                //      mContainer.setVisibility(View.GONE);
                break;
        }
    }
}
