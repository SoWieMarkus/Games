package markus.wieland.games.game.level;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.game.view.GameBoardView;

public abstract class LevelGameBoardView<L extends Level> extends GameBoardView {

    public LevelGameBoardView(@NonNull Context context) {
        super(context);
    }

    public LevelGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LevelGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected abstract void loadLevel(L l);

}
