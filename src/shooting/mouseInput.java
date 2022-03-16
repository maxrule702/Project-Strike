package shooting;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseInput extends MouseAdapter {

private Handler handler;
private camera camera;

public mouseInput(Handler handler, shooting.camera camera){
    this.handler = handler;
    this.camera = camera;
}
    public void mousePressed(MouseEvent e){
    int mouseX = (int) (e.getX() + camera.getX());
        int mouseY = (int) (e.getY() + camera.getY());

        for (int i = 0; i < handler.object.size(); i++) {
            GameObjectShoot tempObj = handler.object.get(i);
        handler.addObject(new bullet(tempObj.getX()+16, tempObj.getY()+24, ID.bullet,handler,mouseX,mouseY));

        }

}
}
