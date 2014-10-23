package ie.jgriffin.griffchart.lib;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by JGriffin on 23/10/2014.
 */
public class ChartPoint {
    private int value;
    private Paint paint;
    private final Paint.Style defaultStyle = Paint.Style.FILL_AND_STROKE;
    private final float defaultStrokeWidth = 2f;

    public ChartPoint() {
        value = 0;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(defaultStyle);
        paint.setStrokeWidth(defaultStrokeWidth);
    }

    public ChartPoint(int value, Paint paint) {
        this.value = value;
        this.paint = paint;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
