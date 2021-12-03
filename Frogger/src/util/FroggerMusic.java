package util;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//On charge et lance la musique ici
//Mais le fichier n'est pas reconnu
//l'erreur n'empeche pas de lancer le jeu

public class FroggerMusic {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);

        File file = new File("AdventureMusic.mp3");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        String res = "";

        while (!res.equals("Q")) {
            System.out.println("L =lance la musique, S=stop, Re=relance, Q=quitte");
            System.out.println("Faites votre choix");

            res = scanner.next();
            res = res.toUpperCase();

            switch (res) {
                case ("L"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case ("Re"):
                    clip.setMicrosecondPosition(0);
                case ("Q"):
                    clip.close();
                    break;
                default:
                    System.out.println("Erreur lors de la lecture des touches ");
            }
        }
    }

}
