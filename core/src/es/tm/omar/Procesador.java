package es.tm.omar;

import com.badlogic.gdx.InputProcessor;

/**
 * Creado por Omar Torrado Míguez el 02/12/2017
 */
//Documentacion: https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/InputProcessor.html
public class Procesador implements InputProcessor {
    //pulsar una tecla
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }
    //soltar una tecla
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
    //escribir un caracter
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    //hacer click o tocar la pantalla del telefono
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    //soltar el click
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    //mover el raton pulsando
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    //mover el raton
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    //mover la rueda del raton (1 o -1 dependiendo de la direccion)
    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
