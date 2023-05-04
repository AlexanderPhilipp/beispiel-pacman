import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Die Renderer Klasse zeichnet JComponents im Fenster
 * @author Alexander Philipp
 */
public class Renderer extends JPanel implements Runnable
{
    private Color _backgroundColor;
    private ArrayList<RenderObject> _renderObjects = new ArrayList<RenderObject>();
    private Thread _renderThread;
    private String _threadName = "Renderer";

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

    /**
     * Diese Methode fügt ein Objekt dem Renderer hinzu
     * @param obj Das Objekt was gezeichnet werden soll
     */
    public void addRenderObject(RenderObject obj)
    {
        _renderObjects.add(obj);
    }

    /**
     * Diese Methode zeichnet die Grafik auf dem Fenster
     * @param g Die Grafik, welche auf dem Fenster gezeichnet werden soll
     */
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(_backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (RenderObject obj: _renderObjects)
        {
            obj.renderObject(g);
        }
    }

    /**
     * Diese Methode zeichnet erneuert alle vorherig hinzugefügten Grafiken
     */
    @Override
    public void repaint() {
        super.repaint();
    }

    public void startRenderer()
    {
        if(_renderThread == null){
            _threadName = "Renderer";
            _renderThread = new Thread(this, _threadName);
            _renderThread.start();
        }
    }

    void updateRenderer(){
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void run()
    {
        while (_renderThread.isAlive())
        {
            try {
                updateRenderer();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
