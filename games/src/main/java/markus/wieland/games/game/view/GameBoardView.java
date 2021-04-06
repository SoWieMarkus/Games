package markus.wieland.games.game.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.R;
import markus.wieland.games.game.GameBoardInteractionListener;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.persistence.GameState;

public abstract class GameBoardView extends FrameLayout {

    protected GameBoardInteractionListener gameBoardInteractionListener;
    protected int layoutId;

    public GameBoardView(@NonNull Context context) {
        this(context, null);
    }

    public GameBoardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GameBoardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        load(context, attrs, defStyleAttr);
    }

    protected void load(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.GameBoardView, defStyleAttr, 0);

        layoutId = array.getResourceId(R.styleable.GameBoardView_layout_for_game_board, -1);
        if (layoutId == -1)
            throw new IllegalArgumentException("This screen has no layout. Assign one by adding \"app:layout_background='@layout/<>' to your view inside your layout file.");

        LayoutInflater.from(context).inflate(layoutId, this, true);
        initializeFields();
        array.recycle();
    }

    public void setGameBoardInteractionListener(GameBoardInteractionListener gameBoardInteractionListener) {
        this.gameBoardInteractionListener = gameBoardInteractionListener;
    }

    protected abstract void initializeFields();

    protected abstract GameResult checkGameForFinish();

    protected abstract void loadGameState(GameState gameState);


}
