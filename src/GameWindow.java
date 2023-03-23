import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Hier wird das Spielfenster kreiert
 * @author Alexander Philipp
 */

public class GameWindow extends JPanel
{
    private int _windowWidth;
    private int _windowHeight;
    private String _windowTitle;

    private final JFrame window;


    public GameWindow(int width, int height, String title)
    {
        _windowWidth = width;
        _windowHeight = height;

        _windowTitle = title;

        window = new JFrame();
        window.setContentPane(this);
        window.setTitle(title);
        setPreferredSize(new Dimension(width, height));
        window.setResizable(false);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public int GetWidth(){ return _windowWidth; }
    public int GetHeight(){ return _windowHeight; }
    public String GetWindowTitle(){ return _windowTitle; }
}
