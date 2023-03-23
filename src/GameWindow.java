import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Diese Klasse repräsentiert das Fenster
 * @author Alexander Philipp
 */

public class GameWindow extends JFrame
{
    private int _windowWidth;
    private int _windowHeight;
    private String _windowTitle;

    /**
     * Kreiert das Fenster
     * @param width Die Fensterbreite
     * @param height Die Fensterhöhe
     * @param title Der Fenstertitel
     */

    public GameWindow(int width, int height, String title)
    {
        _windowWidth = width;
        _windowHeight = height;

        _windowTitle = title;

        setSize(_windowWidth, _windowHeight);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Macht das Fenster sichtbar
     */
    public void openWindow()
    {
        setVisible(true);
    }

    /**
     * Die Methode gibt die Breite des Fensters wieder
     * @return Die Fensterbreite
     */
    public int getWidth(){ return _windowWidth; }

    /**
     * Die Methode gibt die Höhe des Fensters wieder
     * @return Die Fensterhöhe
     */
    public int getHeight(){ return _windowHeight; }

    /**
     * Die Methode gibt den Titel des Fensters wieder
     * @return Der Fenstertitel
     */
    public String getWindowTitle(){ return _windowTitle; }
}
