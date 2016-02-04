package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue f806a;
    private TypedValue f807b;
    private TypedValue f808c;
    private TypedValue f809d;
    private TypedValue f810e;
    private TypedValue f811f;
    private final Rect f812g;
    private OnAttachListener f813h;

    public interface OnAttachListener {
        void m2106a();

        void m2107b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f812g = new Rect();
    }

    public void m2128a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.f813h = onAttachListener;
    }

    public void m2127a(int i, int i2, int i3, int i4) {
        this.f812g.set(i, i2, i3, i4);
        if (ViewCompat.m1191t(this)) {
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        TypedValue typedValue;
        int dimension;
        Object obj;
        TypedValue typedValue2;
        int dimension2;
        Object obj2 = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            typedValue = obj3 != null ? this.f809d : this.f808c;
            if (!(typedValue == null || typedValue.type == 0)) {
                if (typedValue.type == 5) {
                    dimension = (int) typedValue.getDimension(displayMetrics);
                } else if (typedValue.type == 6) {
                    dimension = (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                } else {
                    dimension = 0;
                }
                if (dimension > 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f812g.left + this.f812g.right), MeasureSpec.getSize(i)), 1073741824);
                    obj = 1;
                    if (mode2 == Integer.MIN_VALUE) {
                        typedValue = obj3 == null ? this.f810e : this.f811f;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            if (typedValue.type == 5) {
                                dimension = (int) typedValue.getDimension(displayMetrics);
                            } else if (typedValue.type != 6) {
                                dimension = (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                            } else {
                                dimension = 0;
                            }
                            if (dimension > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f812g.top + this.f812g.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (obj == null && mode == Integer.MIN_VALUE) {
                        typedValue2 = obj3 == null ? this.f807b : this.f806a;
                        if (!(typedValue2 == null || typedValue2.type == 0)) {
                            dimension2 = typedValue2.type != 5 ? (int) typedValue2.getDimension(displayMetrics) : typedValue2.type != 6 ? (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (dimension2 > 0) {
                                dimension2 -= this.f812g.left + this.f812g.right;
                            }
                            if (mode2 < dimension2) {
                                dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
                                obj2 = 1;
                                if (obj2 == null) {
                                    super.onMeasure(dimension2, i2);
                                }
                            }
                        }
                    }
                    dimension2 = dimension;
                    if (obj2 == null) {
                        super.onMeasure(dimension2, i2);
                    }
                }
            }
        }
        obj = null;
        if (mode2 == Integer.MIN_VALUE) {
            if (obj3 == null) {
            }
            if (typedValue.type == 5) {
                dimension = (int) typedValue.getDimension(displayMetrics);
            } else if (typedValue.type != 6) {
                dimension = 0;
            } else {
                dimension = (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
            }
            if (dimension > 0) {
                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f812g.top + this.f812g.bottom), MeasureSpec.getSize(i2)), 1073741824);
            }
        }
        super.onMeasure(i, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj3 == null) {
        }
        if (typedValue2.type != 5) {
            if (typedValue2.type != 6) {
            }
        }
        if (dimension2 > 0) {
            dimension2 -= this.f812g.left + this.f812g.right;
        }
        if (mode2 < dimension2) {
            dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
            obj2 = 1;
            if (obj2 == null) {
                super.onMeasure(dimension2, i2);
            }
        }
        dimension2 = dimension;
        if (obj2 == null) {
            super.onMeasure(dimension2, i2);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f806a == null) {
            this.f806a = new TypedValue();
        }
        return this.f806a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f807b == null) {
            this.f807b = new TypedValue();
        }
        return this.f807b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f808c == null) {
            this.f808c = new TypedValue();
        }
        return this.f808c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f809d == null) {
            this.f809d = new TypedValue();
        }
        return this.f809d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f810e == null) {
            this.f810e = new TypedValue();
        }
        return this.f810e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f811f == null) {
            this.f811f = new TypedValue();
        }
        return this.f811f;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f813h != null) {
            this.f813h.m2106a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f813h != null) {
            this.f813h.m2107b();
        }
    }
}
