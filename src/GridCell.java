import java.awt.*;

public class GridCell extends RenderObject
{
    private int _xPos;
    private int _yPos;

    private int _width;
    private int _height;

    private Color _color;


    public GridCell(int x, int y, int width, int height, Color color)
    {
        _xPos = x;
        _yPos = y;
        _width = width;
        _height = height;
        _color = color;
    }

    @Override
    public void renderObject(Graphics g)
    {
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(_color);
        graphic.drawRect(_xPos, _yPos, _width, _height);
    }
}
