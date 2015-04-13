package nmct.howest.be.colorpicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Gregoire on 26/02/2015.
 */
public class ColorView extends View {


    //attributen
    private String _color = "#FFFFFF";
    private Paint _paint;
    private Rect _rect = new Rect();

    //constructors
    public ColorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Init();
    }

    public ColorView(Context context) {
        super(context);

        Init();
    }

    //getters and setters
    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        _color = color;
        _paint.setColor(Color.parseColor(color));

        invalidate();
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    //methodes
    private void showColorDialog() {
        AlertDialog.Builder b = new AlertDialog.Builder(getContext());

        b.setTitle("Pick a color")
                .setItems(R.array.holo_colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectColor(which);

                        }
                });

        b.create().show();
    }

    private void selectColor(int which) {
        switch(which)
        {
            case 0:
                setColor("#33B5E5");
                break;
            case 1:
                setColor("#AA66CC");
                break;
            case 2:
                setColor("#99CC00");
                break;
            case 3:
                setColor("#FFBB33");
                break;
            case 4:
                setColor("#FF4444");
                break;
            default:
                break;
        }
    }

    private void Init()
    {
        _paint = new Paint();
        _paint.setColor(Color.parseColor(_color));

        _rect.set(0,0,getWidth(),getHeight());

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorDialog();
            }
        });

    }


    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        _rect.set(0, 0, getWidth(), getHeight());
        canvas.drawRect(_rect, _paint);


    }

}
