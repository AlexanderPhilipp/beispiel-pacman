import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

interface IInputEventListener
{
    void onKeyDown(KeyEvent e);
    void onKeyUp(KeyEvent e);
}

public class InputManager implements KeyListener
{
    private List<IInputEventListener> inputEventListeners= new ArrayList<IInputEventListener>();

    public void addInputListener(IInputEventListener listener)
    {
        inputEventListeners.add(listener);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        for (IInputEventListener listener:inputEventListeners)
        {
            listener.onKeyDown(e);
        }
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        for (IInputEventListener listener:inputEventListeners)
        {
            listener.onKeyUp(e);
        }
    }
}
