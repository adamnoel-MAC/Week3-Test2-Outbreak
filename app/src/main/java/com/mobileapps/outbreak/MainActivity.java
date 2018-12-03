package com.mobileapps.outbreak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Room rooms[][] = new Room[10][10];
        String floor = "";
        TextView tvFloor = findViewById(R.id.tvFloor);


        //Clean floor
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                rooms[i][j] = new Room(false);
            }
        }

        //Random infections
        Random rand = new Random();
        boolean tmpinf = false;
        int tmprand;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (rand.nextInt(10) >= 9){
                    tmpinf = true;
                }else{ tmpinf = false;}
                rooms[i][j] = new Room(tmpinf);
            }
        }



        //Display Floor
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                floor = floor + (rooms[i][j].isInfected ? "x" : "_");
                if (j < 9) floor = floor + "|";
            }
            floor = floor + "\n";
        }

        int numinf = infectedrooms(rooms);
        floor = floor + "\n Infected Rooms: " + numinf;

        tvFloor.setText(floor);

        boolean ck = isOutbreak(rooms);

    }

    public int infectedrooms(Room[][] floor){

        int result = 0;

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (floor[i][j].isInfected) result++;
            }
        }

        return result;
    }


    public static boolean isOutbreak(Room[][] floor) {

        boolean result = false;

        for (int row = 0; row <= 5; row++){
            for (int col = 0; col <= 5; col++){
                check5x5(floor, row, col);
            }
        }


        return result;
    }

    public static boolean check5x5(Room[][] floor, int row, int col){

        Log.d("TAG", "check5x5: row: " + row + "; col: " + col);

        int adjRooms = 0;

        for (int i = row; i < row + 5; i++){
            for (int j = col; j < col + 5; j++){
                // if Here isInfected, visited = true
                    // if cango R, visited = true
                        //if R isInfected adjRooms++
                    // cango L, visited = true
                        //if L isInfected adjRooms++
                    // cango U, visited = true
                        //if U isInfected adjRooms++
                    // cango D, visited = true
                        //if D isInfected adjRooms++
            }
        }
        return false;
    }



}
