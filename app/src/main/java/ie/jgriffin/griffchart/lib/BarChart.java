package ie.jgriffin.griffchart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by JGriffin on 22/10/2014.
 */
public class BarChart extends View {

    private int viewWidth, viewHeight;
    private int backgroundColor = Color.WHITE;

    private Paint blackFillPaint;

    private ArrayList<ChartPoint> chartPoints = new ArrayList<ChartPoint>();

    public BarChart(Context context) {
        super(context);
        initPaints();
    }

    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    public BarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(viewWidth, viewHeight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawEdge(canvas);
    }

    private void initPaints() {
        blackFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        blackFillPaint.setColor(Color.BLACK);
        blackFillPaint.setStyle(Paint.Style.FILL);
    }


    private void drawBackground(Canvas canvas) {
        canvas.drawColor(backgroundColor);
    }

    private void drawEdge(Canvas canvas) {
        //top
        canvas.drawLine(1, 1, viewWidth - 1, 1, blackFillPaint);
        //left
        canvas.drawLine(1, 1, 1, viewHeight - 1, blackFillPaint);
        //bottom
        canvas.drawLine(1, viewHeight - 1, viewWidth - 1, viewHeight - 1, blackFillPaint);
        //right
        canvas.drawLine(viewWidth - 1, 1, viewWidth - 1, viewHeight - 1, blackFillPaint);
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public ArrayList<ChartPoint> getChartPoints() {
        return chartPoints;
    }

    public void setChartPoints(ArrayList<ChartPoint> chartPoints) {
        this.chartPoints = chartPoints;
    }
}
