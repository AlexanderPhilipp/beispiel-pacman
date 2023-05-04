import java.awt.*;
import java.awt.event.KeyEvent;

public class Pacman extends RenderObject implements IInputEventListener
{
    //Visual Handleing
    private int _size;
    private int _posX;
    private int _posY;

    //Input Handling
    private int _xInput;
    private int _yInput;

    private boolean _leftKeyDown;
    private boolean _rightKeyDown;
    private boolean _upKeyDown;
    private boolean _downKeyDown;


    public Pacman(int xPos, int yPos, int pacmanSize)
    {
        _posX = xPos;
        _posY = yPos;
        _size = pacmanSize;

        _xInput = 0;
        _yInput = 0;
    }

    //Gets called every frame
    @Override
    public void renderObject(Graphics g) {
        Graphics2D graphic = (Graphics2D) g;
        graphic.setColor(Color.yellow);
        graphic.fillArc(_posX, _posY, _size, _size, 25, 310);

        _posX += _xInput;
        _posY += _yInput;

        handleInput();
        handleCollision();
    }

    void handleCollision(){
        int[][] gridCells = Level.map;

        int cellIndexX = (_posX + (_size / 2)) / _size;
        int cellIndexY = (_posY + (_size / 2)) / _size;

        int leftAdjacentCellIndex = Math.clamp(cellIndexX - 1, 0, gridCells[0].length);
        int rightAdjacentCellIndex = Math.clamp(cellIndexX + 1, 0, gridCells[0].length);
        int topAdjacentCellIndex = Math.clamp(cellIndexY - 1, 0, gridCells.length);
        int bottomAdjacentCellIndex = Math.clamp(cellIndexY + 1, 0, gridCells.length);

        boolean leftCellHasCollision = gridCells[cellIndexY][leftAdjacentCellIndex] == 1;
        boolean rightCellHasCollision = gridCells[cellIndexY][rightAdjacentCellIndex] == 1;
        boolean topCellHasCollision = gridCells[topAdjacentCellIndex][cellIndexX] == 1;
        boolean bottomCellHasCollision = gridCells[bottomAdjacentCellIndex][cellIndexX] == 1;

        int leftCellSignificantEdge = leftCellHasCollision ? leftAdjacentCellIndex * _size : -100;
        int rightCellSignificantEdge = rightCellHasCollision ? rightAdjacentCellIndex * _size : gridCells[0].length * _size;
        int topCellSignificantEdge = topCellHasCollision ? topAdjacentCellIndex * _size : -100;
        int bottomCellSignificantEdge = bottomCellHasCollision ? bottomAdjacentCellIndex * _size : gridCells.length * _size;

        boolean hasLeftCollision = _posX - _size <= leftCellSignificantEdge;
        boolean hasRightCollision = _posX + _size >= rightCellSignificantEdge;
        boolean hasTopCollision = _posY - _size <= topCellSignificantEdge;
        boolean hasBottomCollision = _posY + _size >= bottomCellSignificantEdge;

    }

    void handleInput(){
        if(_leftKeyDown && !_rightKeyDown)
            _xInput = -1;
        else if(!_leftKeyDown && _rightKeyDown)
            _xInput = 1;
        else if(_leftKeyDown && _rightKeyDown)
            _xInput = 0;
        else
            _xInput = 0;

        if(_upKeyDown && !_downKeyDown)
            _yInput = -1;
        else if(!_upKeyDown && _downKeyDown)
            _yInput = 1;
        else if(_upKeyDown && _downKeyDown)
            _yInput = 0;
        else
            _yInput = 0;
    }

    @Override
    public void onKeyDown(KeyEvent e) {
        if(e.getKeyCode() == 68) //Keycode D
            _rightKeyDown = true;
        if(e.getKeyCode() == 65) //Keycode A
            _leftKeyDown = true;
        if(e.getKeyCode() == 87) //Keycode W
            _upKeyDown = true;
        if(e.getKeyCode() == 83) // Keycode S
            _downKeyDown = true;
    }

    @Override
    public void onKeyUp(KeyEvent e) {
        if(e.getKeyCode() == 68) //Keycode D
            _rightKeyDown = false;
        if(e.getKeyCode() == 65) //Keycode A
            _leftKeyDown = false;
        if(e.getKeyCode() == 87) //Keycode W
            _upKeyDown = false;
        if(e.getKeyCode() == 83) // Keycode S
            _downKeyDown = false;
    }
}
