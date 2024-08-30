package com.example.hhr_project;




import android.content.Intent;
import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Button;
        import android.widget.GridView;
        import android.widget.Toast;
        import androidx.appcompat.app.AppCompatActivity;

public class Seat extends AppCompatActivity {
    private Button btn,bookButton;
    private static final int NUM_ROWS = 5; // Updated number of rows to 5
    private static final int SEATS_PER_ROW = 4; // Seats per row, not including the aisle

    private boolean[][] seatSelection = new boolean[NUM_ROWS][SEATS_PER_ROW];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new SeatAdapter());
        bookButton=findViewById(R.id.bookButton);
        findViewById(R.id.bookButton).setOnClickListener(v -> bookSelectedSeats()

        );
        btn=findViewById(R.id.seatBackArrow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seat.this, Search.class));//redirect to other page

            }
        });

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seat.this, MainActivity.class));//redirect to other page

            }
        });

    }

    private void bookSelectedSeats() {
        Toast.makeText(this, "Seats booked successfully!", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                seatSelection[i][j] = false;
            }
        }
        ((GridView) findViewById(R.id.gridView)).invalidateViews(); // Refresh the GridView to show the updated selection state
    }

    private class SeatAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            // Adjusting the count to reflect the updated number of rows (including invisible aisles)
            return NUM_ROWS * 5; // 5 columns to accommodate 4 seats and an aisle
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Button seatButton;
            if (convertView == null) {
                seatButton = new Button(Seat.this);
                seatButton.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                seatButton.setPadding(8, 8, 8, 8);
            } else {
                seatButton = (Button) convertView;
            }

            int row = position / 5; // Total columns (including aisle)
            int column = position % 5; // Determine the specific column

            // Make the middle column (aisle) invisible
            if (column == 2) {
                seatButton.setVisibility(View.INVISIBLE); // Aisle (invisible button)
            } else {
                seatButton.setVisibility(View.VISIBLE);
                int adjustedColumn = column > 2 ? column - 1 : column; // Adjust for aisle
                seatButton.setText(String.format("%d,%d", row + 1, adjustedColumn + 1));
                seatButton.setBackgroundResource(seatSelection[row][adjustedColumn] ? R.drawable.booked_seat_bg : R.drawable.available_seat_bg);
                seatButton.setOnClickListener(v -> {
                    seatSelection[row][adjustedColumn] = !seatSelection[row][adjustedColumn];
                    notifyDataSetChanged();
                });
            }

            return seatButton;
        }
    }
}