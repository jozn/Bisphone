package android.support.v4.graphics;

import android.graphics.Color;

public class ColorUtils {
    public static int m622a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int c = m625c(alpha2, alpha);
        return Color.argb(c, m623a(Color.red(i), alpha2, Color.red(i2), alpha, c), m623a(Color.green(i), alpha2, Color.green(i2), alpha, c), m623a(Color.blue(i), alpha2, Color.blue(i2), alpha, c));
    }

    private static int m625c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int m623a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int m624b(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
