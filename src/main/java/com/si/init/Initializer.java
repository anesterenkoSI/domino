package com.si.init;

import com.si.entity.Domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Initializer {

    public static List<Domino> fill(int cnt) {
        List<Domino> all = collectionAllDominos();
        Collections.shuffle(all);
        List<Domino> gameCollection = new ArrayList<Domino>();
        for (int i = 0; i < cnt; i++) {
            gameCollection.add(all.get(i));
        }
        return gameCollection;
    }

    private static List<Domino> collectionAllDominos() {
        List<Domino> genericList = new ArrayList<Domino>();
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                Domino domino = new Domino(i, j);
                genericList.add(domino);
            }
        }
        return genericList;
    }

}
