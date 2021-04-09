package markus.wieland.games.screen.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.R;
import markus.wieland.games.screen.interact_listener.ScreenInteractListener;

public abstract class ScreenView extends FrameLayout {

    protected ScreenInteractListener screenInteractListener;

    @LayoutRes
    protected int layoutId;

    protected int animationStartOffset;
    protected int animationDuration;
    protected float animateStartAlpha;
    protected float animateEndAlpha;

    public ScreenView(@NonNull Context context) {
        this(context, null);
    }

    public ScreenView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScreenView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        load(context, attrs, defStyleAttr);
    }

    public void setScreenInteractListener(ScreenInteractListener screenInteractListener) {
        this.screenInteractListener = screenInteractListener;
    }

    protected void load(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ScreenView, defStyleAttr, 0);

        layoutId = array.getResourceId(R.styleable.ScreenView_layout_background, -1);
        if (layoutId == -1)
            throw new IllegalArgumentException("This screen has no layout. Assign one by adding \"app:layout_background='@layout/<>' to your view inside your layout file.");

        LayoutInflater.from(context).inflate(layoutId, this, true);

        setClickable(true);
        
        animateEndAlpha = array.getFloat(R.styleable.ScreenView_entry_animation_alpha_end,1f);
        animateStartAlpha = array.getFloat(R.styleable.ScreenView_entry_animation_alpha_start,0f);
        animationDuration = array.getInteger(R.styleable.ScreenView_entry_animation_alpha_duration,500);
        animationStartOffset = array.getInteger(R.styleable.ScreenView_entry_animation_alpha_offset,0);

        if (animationDuration < 0) throw new IllegalArgumentException("Animation duration can't be less than 0");
        if (animationStartOffset < 0) throw new IllegalArgumentException("Animation start delay can't be less than 0");
        if (animateEndAlpha < 0f || animateEndAlpha > 1f) throw new IllegalArgumentException("Animation end alpha must be a float value between 0 and 1.");
        if (animateStartAlpha < 0f || animateStartAlpha > 1f) throw new IllegalArgumentException("Animation start alpha must be a float value between 0 and 1.");

        setAlpha(animateStartAlpha);

        onBuild();

        array.recycle();
    }

    protected abstract void onBuild();

    public void show(){
        setAlpha(animateStartAlpha);
        setVisibility(VISIBLE);
        animate().alpha(animateEndAlpha).setStartDelay(animationStartOffset).setDuration(animationDuration);
        onShow();
    }

    public void close(){
        setVisibility(GONE);
        onClose();
    }

    public void close(boolean withConfiguration) {
        setVisibility(GONE);
        onClose(withConfiguration);
    }

    protected abstract void onShow();
    protected abstract void onClose();
    protected abstract void onClose(boolean withConfiguration);

}
