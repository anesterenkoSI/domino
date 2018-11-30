package com.si.service;

import com.si.entity.Domino;

import java.util.List;

public interface IChainService {

    List<Domino> calculateChain(List<Domino> dominoList);

}
