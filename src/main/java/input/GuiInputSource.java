package input;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GuiInputSource implements InputSource {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    @Override
    public String getInput() {
        try {
            return queue.take();  
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setInput(String input) {
        queue.add(input);
    }
}
