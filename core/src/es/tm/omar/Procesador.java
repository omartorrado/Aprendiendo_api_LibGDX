package es.tm.omar;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

/**
 * Creado por Omar Torrado Míguez el 02/12/2017
 */
/*Documentacion: https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/InputProcessor.html
public class Procesador implements InputProcessor {
Con inputProcessor tendriamos que implementar todos los metodos de la clase, para evitar esto y solo usar los que necesitemos
existe el InputAdapter, que nos permite usar solo los que nos interesen
*/
public class Procesador extends InputAdapter {
    /*
    Los metodos touchUp y touchDown sirven para recoger pulsaciones en una pantalla tactil
    Los parametros screenX e screenY nos darian la posicion donde hemos pulsado (en pixeles)
    El parametro pointer nos indicaria con que dedo hemos pulsado. El primero es el 0, el segundo el 1, etc (dependiendo del hardware, 3-5 dedos o mas)
        en el caso de no haber pantalla multitouch o de un raton siempre devolvera un 0
    El parametro button nos indica que boton del raton hemos pulsado (0 izq,1 dcho, 2 rueda, etc si tiene mas botones)
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Has pulsado en la posicion "+screenX+","+screenY);
        System.out.println("Has usado el dedo "+pointer+" y el boton "+button);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("Has dejado de pulsar");
        return true;
    }

    /*
    Estos serian todos los metodos de InputProcessor, devuelve un booleano que indicará a la api si se ha realizado alguna accion
    con lo cual tendremos que devolver true para que ejecute el codigo de ese metodo

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
    }*/
}
