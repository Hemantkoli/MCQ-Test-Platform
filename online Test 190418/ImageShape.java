import java.awt.*;
import java.awt.font.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;
import javax.imageio.ImageIO;
import java.net.URL;
import java.io.File;

class ImageShape 
{
	public static BufferedImage setSmallImage(int rollno)
	{
		BufferedImage bi=null;
		try
		{
			File f=new File("images\\"+rollno+".png");
			if(f!=null&&f.length()!=0)
				bi=getScaledInstance(ImageIO.read(f.toURI().toURL()),150,150,true);
			else
			{
				f=new File("images\\login.png");
				System.out.println(f.length());
				bi=getScaledInstance(ImageIO.read(f.toURI().toURL()),150,150,true);
				System.out.println(f.length());
			}
			ImageIO.write(textEffect(bi,0),"png",f);
		}
		catch(Exception e){System.out.println("1111"+e);}
		return null;
	}
	public static BufferedImage getScaledInstance(BufferedImage img,int targetWidth,int targetHeight,boolean higherQuality)
	{
		int type = (img.getTransparency() == Transparency.OPAQUE)?BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = (BufferedImage)img;
		int w, h;
		if (higherQuality) 
		{
			// Use multi-step technique: start with original size, then
			// scale down in multiple passes with drawImage()
			// until the target size is reached
			w = img.getWidth();
			h = img.getHeight();
			if(w<=targetWidth || h<=targetHeight)
			{
				BufferedImage tmp = new BufferedImage(targetWidth,targetHeight, type);
				Graphics2D g2 = tmp.createGraphics();
				g2.drawImage(ret, 0, 0, targetWidth,targetHeight, null);
				g2.dispose();
				return tmp;
			}
		} 
		else 
		{
			// Use one-step technique: scale directly from original
			// size to target size with a single drawImage() call
			w = targetWidth;
			h = targetHeight;
		}

		do 
		{
			if (higherQuality && w > targetWidth) 
			{
				w /= 2;
				if (w < targetWidth) 
				{
					w = targetWidth;
				}
			}

			if (higherQuality && h > targetHeight) 
			{
				h /= 2;
				if (h < targetHeight) 
				{
					h = targetHeight;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
		   // g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();
			ret = tmp;
		} while (w!= targetWidth || h != targetHeight);
		return ret;
	}
	
	static BufferedImage textEffect(BufferedImage image,int flag) throws Exception
	{
		BufferedImage text=null;
		
		try
		{
			//image=ImageIO.read(new File("images\\1.jpg").toURI().toURL());
			if(flag==0)
				text=ImageIO.read(new File("images\\crop0.png").toURI().toURL());
			if(flag==1)
				text=ImageIO.read(new File("images\\crop1.png").toURI().toURL());
		}
		catch(Exception e){System.out.println(e);}
		
		if (image.getWidth() != text.getWidth() ||image.getHeight() != text.getHeight())
		{
			throw new IllegalArgumentException("Dimensions are not the same!");
		}
		BufferedImage img = new BufferedImage(image.getWidth(),
											  image.getHeight(),
											  BufferedImage.TYPE_INT_ARGB_PRE);

		for (int y = 0; y < image.getHeight(); ++y) 
		{
			for (int x = 0; x < image.getWidth(); ++x) 
			{
			   int textPixel = text.getRGB(x,y);
			   if(new Color(textPixel).getRed()<=100)
			   {
				   img.setRGB(x,y,image.getRGB(x, y));
				   img.flush();
				   text.flush();
			   }
			  // System.out.println(image.getWidth()+"   "+image.getHeight());
			}
		}
		return img;
	}
}