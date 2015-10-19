package it.luca.chessgame.test;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import it.luca.chessgame.model.Alfiere;
import it.luca.chessgame.model.ArrayConfiguration;
import it.luca.chessgame.model.CasellaVuota;
import it.luca.chessgame.model.Cavallo;
import it.luca.chessgame.model.Configuration;
import it.luca.chessgame.model.Pedone;
import it.luca.chessgame.model.Pezzo;
import it.luca.chessgame.model.Re;
import it.luca.chessgame.model.Regina;
import it.luca.chessgame.model.TilesModel;
import it.luca.chessgame.model.Torre;
import it.luca.chessgame.moves.Mover;

import org.junit.Test;

public class ScaccoDiGreco {
	private Configuration c = new ArrayConfiguration();
	private Simulate simulate;
	private final Color white = Color.WHITE;
	private final Color black = Color.BLACK;
	private Mover mover;
	
	@Test
	public void testScaccoDiGreco(){
		// inizializzo la scacchiera
		for(int x = 0; x < 8; x++)
			for(int y = 0; y < 8; y++)
				c.set(x, y, new CasellaVuota());

		c.set(0, 0, new Torre(black));
		c.set(0, 1, new Pedone(black));
		c.set(1, 1, new Alfiere(black));
		c.set(1, 2, new Pedone(black));
		c.set(2, 1, new Pedone(black));
		c.set(3, 0, new Regina(black));
		c.set(3, 2, new Alfiere(black));
		c.set(5, 0, new Torre(black));
		c.set(6, 0, new Re(black));
		c.set(6, 1, new Pedone(black));
		c.set(7, 1, new Pedone(black));
		c.set(5, 3, new Pedone(black));
		c.set(6, 5, new Cavallo(black));
	
		c.set(5, 0, new Pedone(white));
		c.set(6, 1, new Pedone(white));
		c.set(2, 4, new Alfiere(white));
		c.set(2, 7, new Torre(white));
		c.set(3, 3, new Cavallo(white));
		c.set(3, 7, new Regina(white));
		c.set(4, 7, new Re(white));
		c.set(4, 5, new Pedone(white));
		c.set(5, 5, new Pedone(white));
		c.set(5, 6, new Pedone(white));
		c.set(7, 6, new Pedone(white));
		c.set(7, 7, new Torre(white));
		
		simulate = new Simulate(c, c = c.swap(3, 3, 4, 1), c = c.swap(6, 0, 7, 0),
				c = c.swap(4, 1, 6, 2), c = c.swap(7, 1, 6, 2), c = c.swap(7, 6, 6, 5), 
				c = c.swap(3, 0, 7, 4), c = c.swap(7, 7, 7, 4));
		
		mover = new Mover(new TilesModel(c));
		mover.setTurno(false);
		
		assertTrue(mover.scaccoMatto());
	}
}