package com.si.main;

import com.si.entity.Domino;
import com.si.init.Initializer;
import com.si.service.IChainService;
import com.si.service.impl.ChainServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("Please enter the number of dominos:");
		Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
		List<Domino> gameCollection = Initializer.fill(cnt);
		System.out.println("RANDOM CHAIN:"+gameCollection.toString());
		IChainService chainService = new ChainServiceImpl();
        List<Domino> result = chainService.calculateChain(gameCollection);
		System.out.println("RESULT MAX CHAIN:"+result.toString());
	}
	
}
