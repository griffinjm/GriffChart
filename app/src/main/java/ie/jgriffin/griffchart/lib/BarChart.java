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

    private float edgeWidth = 1f;
    private int viewWidth, viewHeight;
    private int backgroundColor = Color.WHITE;

    private float chartTopBound, chartBottomBound, chartLeftBound, chartRightBound, chartBoundPadding = 5f;

    private Paint edgePaint;

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
        initChartBounds();
    }

    private void initPaints() {
        edgePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        edgePaint.setColor(Color.BLACK);
        edgePaint.setStyle(Paint.Style.FILL);
    }

    private void initChartBounds(){
        chartTopBound = chartBoundPadding;
        chartBottomBound = viewHeight - chartBoundPadding;
        chartLeftBound = chartBoundPadding;
        chartRightBound = viewWidth - chartBoundPadding;
    }


    private void drawBackground(Canvas canvas) {
        canvas.drawColor(backgroundColor);
    }

    private void drawEdge(Canvas canvas) {
        //top
        canvas.drawLine(edgeWidth, edgeWidth, viewWidth - edgeWidth, edgeWidth, edgePaint);
        //left
        canvas.drawLine(edgeWidth, edgeWidth, edgeWidth, viewHeight - edgeWidth, edgePaint);
        //bottom
        canvas.drawLine(edgeWidth, viewHeight - edgeWidth, viewWidth - edgeWidth, viewHeight - edgeWidth, edgePaint);
        //right
        canvas.drawLine(viewWidth - edgeWidth, edgeWidth, viewWidth - edgeWidth, viewHeight - edgeWidth, edgePaint);
    }

    public void redraw(){
        invalidate();
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

    public float getEdgeWidth() {
        return edgeWidth;
    }

    public void setEdgeWidth(float edgeWidth) {
        this.edgeWidth = edgeWidth;
    }

    public Paint getEdgePaint() {
        return edgePaint;
    }

    public void setEdgePaint(Paint edgePaint) {
        this.edgePaint = edgePaint;
    }



}
