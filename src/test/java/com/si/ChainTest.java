package com.si;

import com.si.entity.Domino;
import com.si.service.IChainService;
import com.si.service.impl.ChainServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChainTest {

    private List<Domino> gameCollection = new ArrayList<Domino>();
    private List<Domino> expectedResult = new ArrayList<Domino>();
    private List<Domino> actualResult = new ArrayList<Domino>();

    private IChainService chainService = new ChainServiceImpl();

    @Before
    public void initCollection() {
        gameCollection.add(new Domino(0,0));
        gameCollection.add(new Domino(3,3));
        gameCollection.add(new Domino(2,2));
        gameCollection.add(new Domino(5,3));
        gameCollection.add(new Domino(5,0));
        gameCollection.add(new Domino(6,2));
        gameCollection.add(new Domino(3,0));
    }

    @Test
    public void testCalcChain() {
        expectedResult.add(new Domino(0, 0));
        expectedResult.add(new Domino(0, 5));
        expectedResult.add(new Domino(5, 3));
        expectedResult.add(new Domino(3, 3));
        expectedResult.add(new Domino(3, 0));
        System.out.println("EXPECTED : "+expectedResult);
        actualResult = chainService.calculateChain(gameCollection);
        System.out.println("ACTUAL   : "+actualResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMaxChainValue() {
        assertEquals(expectedResult.size(),actualResult.size());
    }

}
