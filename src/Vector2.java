
public class Vector2 
{
	protected float x;
	protected float y;
	
	protected static Vector2 zero = new Vector2(0,0);
	
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static float Distance(Vector2 v1, Vector2 v2)
	{
		float distance = (float) Math.sqrt((double)(Math.pow((v2.x - v1.x), 2) + Math.pow((v2.y - v1.y), 2)));
		return distance;
	}
}
