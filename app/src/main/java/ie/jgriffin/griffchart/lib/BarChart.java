package ie.jgriffin.griffchart.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;


/**
 * Created by JGriffin on 22/10/2014.
 */
public class BarChart extends Chart {


    private float barPadding = 1f, barWidth, halfBarWidth;
    private int barCount;


    public BarChart(Context context) {
        super(context);
    }

    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!chartPoints.isEmpty()){
            initBarBounds();
            drawBars(canvas);
        }
    }

    private void initBarBounds(){
        barCount = chartPoints.size();
        barWidth = (chartHorizontalSize - (barPadding * (barCount))) / barCount;
        halfBarWidth = barWidth / 2;
        dataScalingFactor = chartVerticalSize / dataMax;
    }

    private void drawBars(Canvas canvas) {
        for (int i = 0; i < chartPoints.size(); i++) {
            ChartPoint point = chartPoints.get(i);
            float[] rectBounds = calcRectBarWithOffset(i, point.getValue());
            canvas.drawRect(rectBounds[0], rectBounds[1], rectBounds[2], rectBounds[3], point.getPaint());
        }
    }

    private float[] calcRectBarWithOffset(int i, int value) {
        //don't draw higher than top of axis/background
        if (value > dataMax) {
            value = (int) dataMax;
        }

        float bottom = chartBottomBound;
        float top = bottom - (value * dataScalingFactor);
        float left = chartLeftBound + ((barPadding + barWidth) * i);
        float right = left + barWidth;

        return new float[]{left, top, right, bottom};
    }

    public float getBarPadding() {
        return barPadding;
    }

    public void setBarPadding(float barPadding) {
        this.barPadding = barPadding;
    }

}
