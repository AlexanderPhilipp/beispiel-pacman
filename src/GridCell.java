import java.awt.*;
import java.util.Random;

public class GridCell extends RenderObject
{
    public enum CellType
    {
        Air, Wall, Coin
    }

    private int _xPos;
    private int _yPos;

    private int _width;
    private int _height;

    private Color _color;
    private CellType _cellType;


    public GridCell(int x, int y, int width, int height, Color color, CellType type)
    {
        _xPos = x;
        _yPos = y;
        _width = width;
        _height = height;
        _color = color;
        _cellType = type;
    }

    @Override
    public void renderObject(Graphics g)
    {
        Graphics2D graphic = (Graphics2D) g;

        switch (_cellType){
            case Air:
                break;
            case Wall:
                graphic.setColor(_color);
                graphic.fillRect(_xPos, _yPos, _width, _height);
                break;
            case Coin:
                break;
            default:
                break;
        }
    }
}
