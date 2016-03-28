
import java.util.ArrayList;


public class Game 
{
	protected String gameTitle = "THE GAME";
	private ArrayList<GameObject> objects;
	protected Options options;
	
	
	public Game()
	{
		objects = new ArrayList<GameObject>();
		options = new Options();
		
	}
	public void Start()
	{
		InstatiateGameObject(new BounceBall(10,10,50,50));
	}
	
	public void Update()
	{
		for( GameObject g : objects)
		{
			g.Update();
		}
	}
	
	public void GetInput()
	{
		
	}
	
	public void InstatiateGameObject(GameObject object)
	{
		objects.add(object);
	}
	
	public void Render()
	{
		for( GameObject g : objects)
		{
			g.Draw();
		}
	}
}
