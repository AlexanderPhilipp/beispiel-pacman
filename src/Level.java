import java.awt.*;

public class Level
{
    private int _horizontalCellCount;
    private int _verticalCellCount;

    private int _horizontalCellSize;
    private int _verticalCellSize;

    private Renderer _rendererInstance;

    public Level(int cellCountX, int cellCountY, int frameWidth, int frameHeight, Renderer renderer)
    {
        _horizontalCellCount = cellCountX;
        _verticalCellCount = cellCountY;

        _horizontalCellSize = frameWidth / cellCountX;
        _verticalCellSize = frameHeight / cellCountY;

        _rendererInstance = renderer;
        generateGrid();
    }

    void generateGrid()
    {
        for(int x = 0; x < _horizontalCellCount; x++)
        {
            for(int y = 0; y < _verticalCellCount; y++)
            {
                GridCell wall = new GridCell(x * _horizontalCellSize, y * _verticalCellSize,
                        _horizontalCellSize, _verticalCellSize, Color.BLUE);

                _rendererInstance.addRenderObject(wall);
            }
        }
    }
}
