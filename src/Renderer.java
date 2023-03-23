import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel
{
    private Color _backgroundColor;


    /**
     * Kreiert eine neue Renderer Klasse
     * @param width Breite
     * @param height Höhe
     * @param backgroundColor Hintergrundfarbe
     */
    public Renderer(int width, int height, Color backgroundColor)
    {
        _backgroundColor = backgroundColor;
        setSize(width, height);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(_backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
