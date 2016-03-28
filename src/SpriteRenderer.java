import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class SpriteRenderer 
{
	protected Texture sprite;
	
	public static Texture getTexture(String fileName)
	{
		try 
		{
			return TextureLoader.getTexture("png", new FileInputStream(new File("sprites/" + fileName + ".png")));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			
			//ToDo add missing Texture Option
		}
		
		return null;
	}
	
	
	public static void Draw(GameObject object)
	{
		Texture texture;
		
		try
		{
			texture = object.spriteRenderer.sprite;
		}
		catch(NullPointerException e)
		{
			texture = null;
		}
		
		
		//Texture texture = null;
		
		if(texture != null)
		{
			
		}
		else
		{
			//add a new matrix for transform to make stop interference form other transforms
			glPushMatrix();
			{
				float width = object.size.x / 2;
				float height = object.size.y / 2;
				
				glTranslatef(object.position.x,object.position.y,0);
				glRotatef(object.rotation, 0,0,1);
				
				glBegin(GL_QUADS);
				{
					glVertex2f(-width,-height);
					glVertex2f(-width,height);
					glVertex2f(width,height);
					glVertex2f(width,-height);
					
				}
				glEnd();
			}
			glPopMatrix();
		}
	}
}
