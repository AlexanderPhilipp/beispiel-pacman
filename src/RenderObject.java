import java.awt.*;

/**
 * Diese Klasse repräsentiert ein Objekt, welches gezeichnet werden soll
 * @author Alexander Philipp
 */
public class RenderObject
{

    public RenderObject()
    {

    }

    public void renderObject(Graphics g){
        Graphics2D graphic = (Graphics2D) g;

        //Hier muss die Überschriebene Zeichnung eingefügt werden
        graphic.setColor(Color.RED);
        graphic.fillRect(50, 50, 50, 50);
    }
}
