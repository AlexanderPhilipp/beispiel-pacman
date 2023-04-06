import java.awt.*;

public class Pacman extends RenderObject
{
    private int _posX;
    private int _posY;

    private int _size;


    public Pacman(int xPos, int yPos, int pacmanSize)
    {
        _posX = xPos;
        _posY = yPos;
        _size = pacmanSize;
    }

    @Override
    public void renderObject(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(Color.yellow);
        graphic.fillArc(_posX, _posY, _size, _size, 0, 360);
    }
}
