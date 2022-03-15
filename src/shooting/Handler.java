package shooting;

import java.awt.Graphics; import java.util.LinkedList;

public class Handler {

    LinkedList<GameObjectShoot> object = new LinkedList<GameObjectShoot> ();

    public void tick() {

        for (int i = 0; i < object.size(); i++) {
            GameObjectShoot tempobject = object.get(i);

            tempobject.tick();

        }
    }

        public void render (Graphics g) {
            for (int i = 0; i < object.size(); i++) {
                GameObjectShoot tempobject = object.get(i);

                tempobject.render(g);
            }
        }

                public void addObject ( GameObjectShoot tempobject){
                    object.add(tempobject);

                }

                public void tempobject (GameObjectShoot tempobject){
                    object.remove(tempobject);

                }

            }
