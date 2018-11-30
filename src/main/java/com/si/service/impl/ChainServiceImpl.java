package com.si.service.impl;

import com.si.entity.Domino;
import com.si.service.IChainService;

import java.util.ArrayList;
import java.util.List;

public class ChainServiceImpl implements IChainService{

    @Override
    public List<Domino> calculateChain(List<Domino> dominoList) {
        List<List<Domino>> result  = new ArrayList<List<Domino>>();
        for (Domino current : dominoList) {
            List<Domino> chain = new ArrayList<Domino>();
            List<Domino> remainder = new ArrayList<Domino>(dominoList);
            chain.add(current);
            remainder.remove(dominoList.indexOf(current));
            maxChain(chain, remainder, result);
        }

        List<Domino> resultChain = new ArrayList<Domino>();

        for (List<Domino> chain : result) {
            if (resultChain.size() < chain.size()) {
                resultChain = chain;
            }
        }
        return resultChain;
    }

    private static void maxChain(List<Domino> mainChain, List<Domino> remainderChain, List<List<Domino>> result) {
        for (Domino current : remainderChain) {
            Domino previous = mainChain.get(mainChain.size() - 1);
            if (previous.getSide2() == current.getSide2()) {
                current.reverse();
            }
            if (previous.getSide2() == current.getSide1()) {
                List<Domino> chainNew = new ArrayList<Domino>(mainChain);
                List<Domino> remainderNow = new ArrayList<Domino>(remainderChain);
                chainNew.add(current);
                result.add(chainNew);
                remainderNow.remove(current);
                maxChain(chainNew, remainderNow, result);
            }
        }
    }


}
