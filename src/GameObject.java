
public abstract class GameObject 
{
	protected String name;
	protected String tag;
	
	//protected float x;
	//protected float y;
	//protected float width;
	//protected float height;
	
	protected Vector2 position;
	protected Vector2 size;
	
	
	protected float rotation;
	
	protected SpriteRenderer spriteRenderer;
	
	abstract void Update();
	
	abstract void Start();
	
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
	
	public void Draw()
	{
		SpriteRenderer.Draw(this);
	}
	
}
