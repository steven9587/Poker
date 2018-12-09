package com.steven.poker;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Poker poker = new Poker();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poker.shuffle();
        poker.print();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PokerAdapter());
    }

    class PokerAdapter extends RecyclerView.Adapter<PokerAdapter.PokerHolder>{
        @NonNull
        @Override
        public PokerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PokerHolder(getLayoutInflater().inflate(R.layout.poker_row , parent , false));
        }

        @Override
        public void onBindViewHolder(@NonNull PokerHolder holder, int position) {
            holder.pokerView.setText(poker.cards[position].getCard());
        }

        @Override
        public int getItemCount() {
            return poker.cards.length;
        }

        class PokerHolder extends RecyclerView.ViewHolder{
            TextView pokerView;
            public PokerHolder(View itemView) {
                super(itemView);
                pokerView = itemView.findViewById(R.id.tv_poker);
            }
        }
    }
}
