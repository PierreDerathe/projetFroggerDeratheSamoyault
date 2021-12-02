package gameCommons;

import environment.Environment;
import frog.Frog;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {

		//Caract�ristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = 50;
		int minSpeedInTimerLoops = 6;
		double defaultDensity = 0.02;
		
		//Cr�ation de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Cr�ation de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity);
		//Cr�ation et liason de la grenouille
		IFrog frog = new Frog(game);
		game.setFrog(frog);
		graphic.setFrog(frog);
		//Cr�ation et liaison de l'environnement
		IEnvironment env = new Environment(game);
		game.setEnvironment(env);
				
		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.update();
				graphic.repaint();
				if(game.getTempsDeJeu() == "C'est repartie") {
					//Cr�ation de l'interface graphique
					graphic.reset();
					//Cr�ation de la partie
					//Cr�ation et liason de la grenouille
					IFrog frog = new Frog(game);
					game.setFrog(frog);
					graphic.setFrog(frog);
					//Cr�ation et liaison de l'environnement
					IEnvironment env = new Environment(game);
					game.setEnvironment(env);
					game.reset();
				}
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
