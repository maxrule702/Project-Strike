package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed,spacePressed;

    //debug
    public boolean showDebugText;
    public int Skins;


    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(gp.gameState == gp.playState){
            playState(code);
        }




        if(gp.gameState == gp.titleState){
            titleState(code);
        }


        if(gp.gameState == gp.characterState){
                charSate(code);
        }


    }

    public void titleState(int code){
        //Title State

        if (gp.gameState == gp.titleState) {

            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }

            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }


            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    //PLAY GAME
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNum == 1) {
                    //SKINS


                }
                if (gp.ui.commandNum == 2) {
                    //EXIT

                    System.exit(0);
                }
            }

        }
    }


    public void playState(int code){
        //Play State

        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }

            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }

            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }
            if (code == KeyEvent.VK_C) {
                gp.gameState = gp.characterState;

            }

            if (code == KeyEvent.VK_P) {
                if (gp.gameState == gp.playState) {
                    gp.gameState = gp.pauseState;
                } else if (gp.gameState == gp.pauseState) {
                    gp.gameState = gp.playState;
                }
            }


                if (code == KeyEvent.VK_ENTER) {
                    enterPressed = true;
                }

            }
            //debug
            if (code == KeyEvent.VK_T) {
                if (showDebugText == false) {
                    showDebugText = true;
                } else if (showDebugText == true) {
                    showDebugText = false;
                }
            }
            //Refresh map changes while in-game or while the game is running
            if (code == KeyEvent.VK_F) {
                gp.tileM.loadMap("/worldMap.txt");
            }
        }








    public void charSate(int code){
//Char state

         if (gp.gameState == gp.characterState){
            if(code == KeyEvent.VK_C ){
                gp.gameState = gp.characterState;

            }
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        if (code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }

        if(code == KeyEvent.VK_C ) {
            gp.gameState = gp.playState;
        }

        if(code == KeyEvent.VK_P ) {
            gp.gameState = gp.playState;
        }


    }
}
