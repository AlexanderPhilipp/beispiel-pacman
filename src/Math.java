public class Math
{
    /**
     * Clamps the designated value between the designated boundaries
     * @param value The value wich should be clamped
     * @param minInclusive The lower limit including the value
     * @param maxExclusive The upper limit excluding the value
     * @return
     */
    public static int clamp(int value, int minInclusive, int maxExclusive)
    {
        int clampedValue = 0;
        if(value >= maxExclusive)
            clampedValue = maxExclusive - 1;
        else if(value < minInclusive)
            clampedValue = minInclusive;
        else
            clampedValue = value;

        return clampedValue;
    }
}
