package markus.wieland.game;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.screen.view.StartScreenView;

public class GameStartScreenView extends StartScreenView {

    private Button close;

    public GameStartScreenView(@NonNull Context context) {
        super(context);
    }

    public GameStartScreenView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GameStartScreenView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected GameConfiguration getConfiguration() {
        return null;
    }

    @Override
    protected void onBuild() {
        close = findViewById(R.id.button);
        close.setOnClickListener(v -> onClose());
    }


}
