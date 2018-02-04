package dp.school.utility.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import dp.school.R;

/**
 * Created by PC on 06/01/2018.
 */

public class AnimatedButtonView extends FrameLayout {

    public static final String TAG = "AnimatedButtonView";
    FrameLayout containerFrameLayout;
    TextView titleTextView;
    ImageView checkImageView;
    boolean isAnimationEnabled = false;
    OnAnimatedButtonListener onAnimatedButtonListener;
    public static int NO_DRAWABLE = 0;

    public AnimatedButtonView(@NonNull Context context) {
        super(context);
        init();
    }

    public AnimatedButtonView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public AnimatedButtonView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttributes(context, attrs);
    }

    private void init() {
        inflate(getContext(), R.layout.view_animated_button, this);
        titleTextView = findViewById(R.id.tv_animated_button_title);
        checkImageView = findViewById(R.id.iv_animated_button_logo_check);
        containerFrameLayout = findViewById(R.id.fl_animated_button_choose);
        setEvents();
    }

    private void setAttributes(Context context, @Nullable AttributeSet attrs) {
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AnimatedButtonView, 0, 0);
            titleTextView.setText(typedArray.getString(R.styleable.AnimatedButtonView_abtn_text));
            titleTextView.setTextColor(getResources().getColor(typedArray.getResourceId(R.styleable.AnimatedButtonView_abtn_text_color,0)));
    }


    private void setEvents() {
        containerFrameLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnimationEnabled()) {
                    animateButtonWidth();
                    containerFrameLayout.setOnClickListener(null);
                } else {
                    if (onAnimatedButtonListener == null) {
                        Log.d(TAG, "you must call setOnAnimatedButtonListener method");
                    } else {
                        onAnimatedButtonListener.onAnimationEnd(isAnimationEnabled());
                    }
                }

            }
        });
    }


    public void setAnimationEnabled(int drawable) {
        if(drawable!=NO_DRAWABLE) {
            containerFrameLayout.setBackground(getResources().getDrawable(drawable));
        }
        this.isAnimationEnabled = true;
    }

    public boolean isAnimationEnabled() {
        return isAnimationEnabled;
    }

    public void setOnAnimatedButtonListener(OnAnimatedButtonListener onAnimatedButtonListener) {
        this.onAnimatedButtonListener = onAnimatedButtonListener;
    }

    private void animateButtonWidth() {
        titleTextView.setVisibility(GONE);
        ValueAnimator anim = ValueAnimator.ofInt(containerFrameLayout.getMeasuredWidth(), getFabWidth());

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = containerFrameLayout.getLayoutParams();
                layoutParams.width = val;
                containerFrameLayout.requestLayout();
            }
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeOutTextAndShowProgressDialog();
            }
        });

        anim.setDuration(500);
        anim.start();
    }


    private void fadeOutTextAndShowProgressDialog() {

        titleTextView.animate().alpha(0f)
                .setDuration(50)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        showProgressDialog();
                    }
                })
                .start();
    }


    private void showProgressDialog() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkImageView.setAlpha(1f);
                checkImageView.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);
                checkImageView.setVisibility(VISIBLE);
                if (onAnimatedButtonListener == null) {
                    Log.d(TAG, "you must call setOnAnimatedButtonListener method");
                } else {
                    onAnimatedButtonListener.onAnimationEnd(isAnimationEnabled());
                }
            }
        }, 50);

    }

    public FrameLayout getButton(){
        return containerFrameLayout;
    }

    public void setTitle(String title){
        titleTextView.setText(title);
    }

    private int getFabWidth() {
        return (int) getResources().getDimension(R.dimen.dp40h);
    }

}
