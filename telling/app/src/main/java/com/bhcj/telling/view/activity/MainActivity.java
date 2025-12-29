
package com.bhcj.telling.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bhcj.telling.R;
import com.bhcj.telling.TarotCard;
import com.bhcj.telling.TarotDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout cardContainer;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardContainer = findViewById(R.id.cardContainer);
        Button btnDaily = findViewById(R.id.btnDaily);
        Button btnThree = findViewById(R.id.btnThree);

        btnDaily.setOnClickListener(v -> drawCards(1));
        btnThree.setOnClickListener(v -> drawCards(3));
    }

    private void drawCards(int count) {
        cardContainer.removeAllViews(); // 清空上次结果

        // 复制牌堆并洗牌
        List<TarotCard> deck = new ArrayList<>(TarotDeck.DECK);
        Collections.shuffle(deck);

        for (int i = 0; i < count; i++) {
            TarotCard card = deck.get(i);
            boolean isReversed = random.nextBoolean(); // 随机正逆位

            // 创建垂直布局（图片 + 文字）
            LinearLayout cardLayout = new LinearLayout(this);
            cardLayout.setOrientation(LinearLayout.VERTICAL);
            cardLayout.setGravity(android.view.Gravity.CENTER);

            // 牌图
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(card.drawableId);
            if (isReversed) imageView.setRotation(180); // 逆位旋转180度
            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(
                    dpToPx(180), dpToPx(280));
            imgParams.setMargins(0, 0, dpToPx(16), 0);
            imageView.setLayoutParams(imgParams);

            // 解读文字
            TextView textView = new TextView(this);
            String position = count == 3 ? new String[]{"过去", "现在", "未来"}[i] : "今日运势";
            String meaning = isReversed ? card.reversed : card.upright;
            textView.setText(position + "：\n" + card.name + "\n(" +
                    (isReversed ? "逆位" : "正位") + ")\n" + meaning);
            textView.setTextSize(16);
            textView.setGravity(android.view.Gravity.CENTER);

            cardLayout.addView(imageView);
            cardLayout.addView(textView);
            cardContainer.addView(cardLayout);
        }
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}