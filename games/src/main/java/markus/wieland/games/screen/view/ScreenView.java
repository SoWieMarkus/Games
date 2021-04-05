package markus.wieland.games.screen.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.game.R;
import markus.wieland.games.screen.interact_listener.ScreenInteractListener;

public abstract class ScreenView extends FrameLayout {

    protected ScreenInteractListener screenInteractListener;

    @LayoutRes
    protected int layoutId;

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
        onBuild();

        array.recycle();
    }

    protected abstract void onBuild();

    //TODO make this variable by attributes
    public void show(){
        setAlpha(0);
        setVisibility(VISIBLE);
        animate().alpha(1f).setStartDelay(100).setDuration(500);
        onShow();
    }

    public void close(){
        setVisibility(GONE);
        onClose();
    }

    protected abstract void onShow();
    protected abstract void onClose();







}
