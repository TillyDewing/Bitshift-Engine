
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;


public class Main 
{
	private static Game game;
	
	public static void main(String[] args)
	{
		initGame();
		initDisplay();
		initGL();
		gameLoop();
	}
	
	private static void gameLoop()
	{
		game.Start();
		
		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			
			game.Update();
			game.Render();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		System.exit(0);
	}
	
	private static void initDisplay()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(game.options.resolutionX,game.options.resolutionY));
			Display.setTitle(game.gameTitle);
			Display.create();
			
		}
		catch(LWJGLException e)
		{
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}
	
	private static void initGL()
	{
		glMatrixMode(GL_PROJECTION); //set the matrix to be edited to the projection matrix
		glLoadIdentity(); //clear the matrix
		//			Size									depth
		glOrtho(0,Display.getWidth(),0,Display.getHeight(), -1,1); //set the size and depth of the canvas
		
		glMatrixMode(GL_MODELVIEW); //set the matrix to the model view
		//			r  g   b  opacity (0-1)
		//glClearColor(6,86,152,0); //set the background color
		glDisable(GL_DEPTH_TEST);//disable depth test information no needed for 2D
	}
	
	private static void initGame()
	{
		game = new Game();
	}
	
	public static void setDisplayMode(int width, int height, boolean fullscreen) {
		 
	    // return if requested DisplayMode is already set
	    if ((Display.getDisplayMode().getWidth() == width) && (Display.getDisplayMode().getHeight() == height) && (Display.isFullscreen() == fullscreen)) 
	    {
	        return;
	    }
	 
	    try 
	    {
	        DisplayMode targetDisplayMode = null;
	         
	        if (fullscreen) 
	        {
	        	DisplayMode[] modes = Display.getAvailableDisplayModes();
	        	int freq = 0;
	                 
	        	for (int i=0;i<modes.length;i++) 
	        	{
	        		DisplayMode current = modes[i];
	                     
			        if ((current.getWidth() == width) && (current.getHeight() == height)) 
			        {
			            if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) 
			            {
			                if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) 
			                {
			                	targetDisplayMode = current;
			                	freq = targetDisplayMode.getFrequency();
			                }
			             }
			 
			            // if we've found a match for bpp and frequence against the 
			            // original display mode then it's probably best to go for this one
			            // since it's most likely compatible with the monitor
			            if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) && (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) 
			            {
			            	targetDisplayMode = current;
			                break;
			            }
			        }
	        	}
	        } 
	        else 
	        {
	            targetDisplayMode = new DisplayMode(width,height);
	        }
	 
	        if (targetDisplayMode == null) 
	        {
	            System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);
	            return;
	        }
	 
	        Display.setDisplayMode(targetDisplayMode);
	        Display.setFullscreen(fullscreen);
	             
	    } 
	    catch (LWJGLException e) 
	    {
	        System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
	    }
	}
}
