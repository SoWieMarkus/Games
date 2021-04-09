package markus.wieland.games.game.level;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class LevelFragment<L extends Level> extends Fragment {

    @LayoutRes
    private final int layoutId;

    protected final L level;

    protected View view;

    protected final LevelEventListener<L> levelEventListener;

    public LevelFragment(int layoutId, L level, LevelEventListener<L> levelEventListener) {
        this.layoutId = layoutId;
        this.level = level;
        this.levelEventListener = levelEventListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(layoutId, container, false);
        initializeViews();
        loadLevel();
        return view;
    }

    protected abstract void initializeViews();
    protected abstract void loadLevel();

    protected void completeLevel(LevelResult levelResult) {
        levelEventListener.onLevelCompleted(level, levelResult);
    }

    protected abstract LevelResult getResult();

    public final <V extends View> V findViewById(@IdRes int id) {
        return view.findViewById(id);
    }

}
