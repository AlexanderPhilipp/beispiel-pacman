import java.awt.*;

/**
 * Dies ist der Einstiegspunkt für das Programm
 * @author Alexander Philipp
 */

public class Main
{
    public static void main(String[] args)
    {
        //Erstellt ein neues Fenster mit der Größe 500 X 500 und dem Titel "Pacman"
        GameWindow window = new GameWindow(600, 660, "Pacman");
        Renderer gameRenderer = new Renderer(600, 660, Color.BLACK);

        window.add(gameRenderer);
        window.openWindow();

        Level level = new Level(560, 620, gameRenderer);
        gameRenderer.repaint();
    }
}
