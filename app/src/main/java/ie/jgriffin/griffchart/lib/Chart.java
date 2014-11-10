package ie.jgriffin.griffchart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by JGriffin on 07/11/2014.
 */
public class Chart extends View {


    protected float edgeWidth = 1f;
    protected int viewWidth, viewHeight;
    protected int backgroundColor = Color.WHITE;

    protected float chartTopBound, chartBottomBound, chartLeftBound, chartRightBound, chartBoundPadding = 5f;
    protected float chartVerticalSize, chartHorizontalSize;
    protected float dataMax = 100f, dataScalingFactor;

    protected Paint edgePaint;

    protected ArrayList<ChartPoint> chartPoints = new ArrayList<ChartPoint>();


    public Chart(Context context) {
        super(context);
        initPaints();
    }

    public Chart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    public Chart(Context context, AttributeSet attrs, int defStyleAttr) {
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
        initChartBounds();
        drawBackground(canvas);
        drawEdge(canvas);
    }

    public void redraw(){
        invalidate();
    }


    protected void drawBackground(Canvas canvas) {
        canvas.drawColor(backgroundColor);
    }

    protected void drawEdge(Canvas canvas) {
        //top
        canvas.drawLine(edgeWidth, edgeWidth, viewWidth - edgeWidth, edgeWidth, edgePaint);
        //left
        canvas.drawLine(edgeWidth, edgeWidth, edgeWidth, viewHeight - edgeWidth, edgePaint);
        //bottom
        canvas.drawLine(edgeWidth, viewHeight - edgeWidth, viewWidth - edgeWidth, viewHeight - edgeWidth, edgePaint);
        //right
        canvas.drawLine(viewWidth - edgeWidth, edgeWidth, viewWidth - edgeWidth, viewHeight - edgeWidth, edgePaint);
    }

    protected void initPaints() {
        edgePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        edgePaint.setColor(Color.BLACK);
        edgePaint.setStyle(Paint.Style.FILL);
    }

    protected void initChartBounds(){
        chartTopBound = chartBoundPadding;
        chartBottomBound = viewHeight - chartBoundPadding;
        chartLeftBound = chartBoundPadding;
        chartRightBound = viewWidth - chartBoundPadding;
        chartVerticalSize = chartBottomBound - chartTopBound;
        chartHorizontalSize = chartRightBound - chartLeftBound;
        dataScalingFactor = chartVerticalSize / dataMax;
    }

    public ArrayList<ChartPoint> getChartPoints() {
        return chartPoints;
    }

    public void setChartPoints(ArrayList<ChartPoint> chartPoints) {
        this.chartPoints = chartPoints;
        redraw();
    }

    public float getDataMax() {
        return dataMax;
    }

    public void setDataMax(float dataMax) {
        this.dataMax = dataMax;
    }

    public float getDataScalingFactor() {
        return dataScalingFactor;
    }

    public void setDataScalingFactor(float dataScalingFactor) {
        this.dataScalingFactor = dataScalingFactor;
    }

    public float getEdgeWidth() {
        return edgeWidth;
    }

    public void setEdgeWidth(float edgeWidth) {
        this.edgeWidth = edgeWidth;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Paint getEdgePaint() {
        return edgePaint;
    }

    public void setEdgePaint(Paint edgePaint) {
        this.edgePaint = edgePaint;
    }

    public float getChartBoundPadding() {
        return chartBoundPadding;
    }

    public void setChartBoundPadding(float chartBoundPadding) {
        this.chartBoundPadding = chartBoundPadding;
    }
}
