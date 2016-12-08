package fcu.iecs.oop.pokemon;

import java.util.Random;

public class GYM {
	public static Player fight(Player... players){
		int sc = 0;
		Player champion = null;
		Pokemon[] p1 = players[0].getPokemons();
		Pokemon[] p2 = players[1].getPokemons();
		for(int i = 0; i < 3; i++){
			if(p1[i].getType() == p2[i].getType() ){
				if(p1[i].getCp() == p2[i].getCp() ){
					Random rand = new Random();
					boolean flag = rand.nextBoolean();
					sc += (flag) ? 1 : -1;
				}
				else{
					sc += (p1[i].getCp() > p2[i].getCp() ) ? 1 : -1;
				}
			}
			else{
				PokemonType p1_type = p1[i].getType(), p2_type = p2[i].getType();
				PokemonType f = PokemonType.FIRE, g = PokemonType.GRASS, w = PokemonType.WATER;
				sc += ((p1_type == f &&  p2_type == g) || (p1_type == g &&  p2_type == w) || (p1_type == w &&  p2_type == f) ) ? 1 : -1;
			}
			if(sc == 2 || sc == -2) break;
		}
		champion = (sc > 0) ? players[0] : players[1];
		champion.setLevel(champion.getLevel()+1);
		System.out.printf("Winner is %s, and his/her level becomes %d.", champion.getPlayerName(), champion.getLevel() );
		return champion;
	}
}
