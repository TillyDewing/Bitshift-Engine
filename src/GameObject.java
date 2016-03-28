import org.newdawn.slick.opengl.Texture;

public abstract class GameObject 
{
	protected String name; //name of object used for searching and referencing
	protected String tag; //gameObjects tag will be used later by a tag class that will allow for gameobject searching by tag
	
	//protected float x;
	//protected float y;
	//protected float width;
	//protected float height;
	
	protected Vector2 position; //world position of the object
	protected Vector2 size; //size of the rectangle that makes up the object
	
	
	protected float rotation; //objects z-axis rotation 
	
	protected Texture sprite; //the objects sprite
	
	abstract void Update(); //update function called every frame
	
	abstract void Start(); //called when the object is created
	
	public GameObject(float x, float y,float width,float height)
	{
		position = new Vector2(x,y);
		size = new Vector2(width, height);
		//this.x = x;
		//this.y = y;
		//this.width = width;
		//this.height = height;
	}
	
	public GameObject(float x, float y,float width,float height, float rotaion)
	{
		position = new Vector2(x,y);
		size = new Vector2(width, height);
		this.rotation = rotaion;
	}
	
	public GameObject(Vector2 position, Vector2 size)
	{
		this.position = position;
		this.size = size;
	}
	
	public GameObject(Vector2 position, Vector2 size, float rotation)
	{
		this.position = position;
		this.size = size;
		this.rotation = rotation;
	}
	
	public void Draw()  //Draws the gameobject
	{
		SpriteRenderer.Draw(this);
	}
	
}
