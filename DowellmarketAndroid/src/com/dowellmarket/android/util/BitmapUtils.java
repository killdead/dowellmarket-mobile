package com.dowellmarket.android.util;

import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;
import android.widget.ImageView;

public class BitmapUtils
{
  public static void displayRatingsStars(ImageView paramImageView, Float paramFloat)
  {
    switch (Integer.valueOf(Math.round(paramFloat.floatValue() / 2.0F)).intValue())
    {
    
    case 1:paramImageView.setImageResource(2130837746);break;
    case 2: paramImageView.setImageResource(2130837747);break;
    case 3:  paramImageView.setImageResource(2130837748);break;
    case 4:paramImageView.setImageResource(2130837749);break;
    case 5:paramImageView.setImageResource(2130837750);break;
    default:
        paramImageView.setImageResource(2130837745);
    }
  
  }

  public static boolean resizePhoto(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    String str = localOptions.outMimeType;
    int k = 1;
    if ((paramInt1 > 0) || (paramInt2 > 0))
      k = Math.min(i / paramInt1, j / paramInt2);
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = k;
    localOptions.inPurgeable = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      if (str.equals("image/jpeg"))
      {
        bool = localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      }
      else if (str.equals("image/png"))
      {
        bool = localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      }
      else
      {
        localFileOutputStream.flush();
        localFileOutputStream.close();
        localBitmap.recycle();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool;
  }

  public static Bitmap scaleCenterCrop(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Log.d("Bitmap source sizes", "width: " + i + "px height: " + j + "px");
    Log.d("Bitmap dest sizes", "width: " + paramInt1 + "px height: " + paramInt2 + "px");
    float f1 = Math.max(paramInt1 / i, paramInt2 / j);
    float f2 = f1 * i;
    float f3 = f1 * j;
    float f4 = (paramInt1 - f2) / 2.0F;
    float f5 = (paramInt2 - f3) / 2.0F;
    RectF localRectF = new RectF(f4, f5, f4 + f2, f5 + f3);
    Bitmap localBitmap =null;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
      new Canvas(localBitmap).drawBitmap(paramBitmap, null, localRectF, null);
    }
      return localBitmap;
  }
}

/* Location:           C:\Users\Utilisateur\Documents\Dev\ApkToJar\tools\classes-dex2jar.jar
 * Qualified Name:     com.drivy.android.util.BitmapUtils
 * JD-Core Version:    0.6.0
 */