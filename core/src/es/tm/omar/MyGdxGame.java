package es.tm.omar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/*
La clase aplication adapter es la que se encarga de que el juego sea multiplataforma y se carga desde
la clase launcher de cada plataforma
Documentacion: https://libgdx.badlogicgames.com/nightlies/docs/api/
 */
public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion imgRegion;

	private int anchoPantalla, altoPantalla;
	private int anchoImagen, altoImagen;

	//Este es el metodo que se lanza al iniciar el juego
	@Override
	public void create () {
		//El SpriteBatch se usa para dibujar las imagenes en la pantalla
		batch = new SpriteBatch();
		/*
		La clase Texture se usa para cargar las imagenes desde un archivo de la carpeta assets
		Como nota, con openGL las texturas se cargan mas rapido sisu tamaño es una potencia de 2 (16x16, 128x64...)
		Por otro lado, si tenemos una imagen que no queremos usar entera, tenemos otra clase que son las textureRegion
		Para las imagenes el eje de coordenadas empieza arriba a la izquierda
		 */
		img = new Texture("badlogic.jpg");
		// TextureRegion(Texture t,int posX,int posY,int ancho,int alto) posX y posY son los pixeles desde donde recorta(desde 0,0 arriba izquierda no recortaria nada)
		//el ancho y alto sería el tamaño de la imagen(tambien recortaria de lo que queda en caso de ser mas pequeña, o rellena copiando los pixeles del borde si es mas grande)
		imgRegion= new TextureRegion(img,0,128,64,64);
		/*
		La clase gdx nos permite controlar el audio, los graficos, los archivos, etc.
		Con los metodos de la subclase graphics .getWidth() y .getHeigth() obtenemos el ancho y alto de la pantalla en pixeles
		Tambien podemos hacerlo con la clase texture
		 */
		anchoPantalla=Gdx.graphics.getWidth();
		altoPantalla=Gdx.graphics.getHeight();
		anchoImagen=img.getWidth();
		altoImagen= img.getHeight();
		System.out.println(anchoPantalla+", "+altoPantalla+", "+altoImagen+", "+anchoImagen);

	}

	//este es el metodo que se lanza para dibujar cosas en pantalla, se ejecuta automaticamente de 30 a 60 veces por segundo (seran algo asi como los FPS?)
	@Override
	public void render () {
		//El metodo .glClearColor se usa para pintar el fondo de la pantalla, se le pasan floats entre 0 y 1 en formato rgba(red,green,blue,alpha)
		Gdx.gl.glClearColor(0.1f, 0.5f, 0, 0.9f);
		//Este metodo limpia la memoria grafica para que no se carguen cosas que pudiesen haber quedado en memoria (por no haber hecho un .dispose() con ellas)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		/*
		El metodo begin inicia una lista de instrucciones para pasarle al batch, en este caso el .draw() que tiene diferentes constructores. Una vez escritas
		todas las instrucciones que queremos ejecutar, se llama al meto .end() que envia la lista de instrucciones a la grafica
		 */
		batch.begin();
		//imagen dibujada en la esquina inferior izquierda con .draw(Texture variableTexture,int posicionX,int posicionY)
		batch.draw(img, 0, 0);
		//imagen dibujada en la esquina superior derecha
		batch.draw(img,anchoPantalla-anchoImagen,altoPantalla-altoImagen);
		//dibujamos la textureRegion imgRegion
		batch.draw(imgRegion,0,altoPantalla/2);
		batch.end();
		/*
		Desde la clase Gdx.input tenemos acceso a los metodos que nos permiten indicar que hace cada control. Nos da acceso a las teclas del teclado, el raton,
			toque en la pantalla del movil, el acelerometro, la rotaccion, y mas.
		Con el metodo .isTouched() devolveria verdadero cada vez que se ejecuta el render y se esta tocando la pantalla, con lo cual un toque breve se lanzaria aun
			asi varias veces.
		Para evitar esto tambien existe el metodo .justTouched() que solo devolveria verdadero una vez por pulsacion.
		 */
		if(Gdx.input.justTouched()){
			System.out.println("pulsando");
		}
		/*
		Este modo de hacerlo, con el if y el input es poco eficiente. Ver clase Procesador para mas info sobre hacerlo de manera mas eficiente
		En el caso de un teclado tenemos los metodos .isKeyPressed(Input.Keys.teclaElegida) y .isKeyJustPressed(Input.Keys.teclaElegida)
		Input.Keys. nos proporciona una lista de constantes que representan las teclas. Aqui tambien tendriamos teclas como back y home de un telefono, botones de mandos, etc
		 */
		if(Gdx.input.isKeyJustPressed(Input.Keys. SPACE)){
				System.out.println("Pulsado espacio");
		}
	}

	//Este metodo se encarga de limpiar de la memoria grafica los archivos cargaados y dibujados en pantalla
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
