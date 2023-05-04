import java.awt.*;

/**
 * Dies ist der Einstiegspunkt für das Programm
 * @author Alexander Philipp
 */

public class Main
{
    public static void main(String[] args)
    {
        //Erstellt ein neues Fenster mit der Größe 560 X 650 und dem Titel "Pacman"
        GameWindow window = new GameWindow(560, 650, "Pacman");
        Renderer gameRenderer = new Renderer(560, 650, Color.BLACK);
        InputManager inputManager = new InputManager();

        window.add(gameRenderer);
        window.openWindow();
        window.addKeyListener(inputManager);

        Level level = new Level(560, 620, gameRenderer);

        Pacman pacman = new Pacman(level.getStartPosX(), level.getStartPosY(), level.getCellWidth());
        gameRenderer.addRenderObject(pacman);
        inputManager.addInputListener(pacman);

        gameRenderer.startRenderer();
    }
}
