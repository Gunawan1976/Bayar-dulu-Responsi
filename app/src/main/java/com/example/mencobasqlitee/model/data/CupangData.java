package com.example.mencobasqlitee.model.data;

import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.model.Cupang;

import java.util.ArrayList;

public class CupangData {
    private static String[] nama = {
            "Cupang Halfmoon",
            "Cupang Crown",
            "Cupang Doubletail",
            "Cupang Plakat",
            "Cupang Snakehead",
            "Cupang Sawah",
            "Cupang Sampah",
            "Cupang Jelek",
    };
    private static int[]image={
            R.drawable.halfmoon,
            R.drawable.crown,
            R.drawable.doubletail,
            R.drawable.plakat,
            R.drawable.snakehead,
            R.drawable.cupangbosok,
            R.drawable.akarensis,
            R.drawable.cupangbsok2,
    };
    public static ArrayList<Cupang>getData(){
        ArrayList<Cupang> list = new ArrayList<>();
        for (int position = 0 ; position<nama.length;position++){
            Cupang cupang = new Cupang();
            cupang.setNama(nama[position]);
            cupang.setImage(image[position]);
            list.add(cupang);
        }
        return list;
    }
}
