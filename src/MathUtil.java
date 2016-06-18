public class MathUtil {

    /*
        function normalize(value, min, max) {
            return (value - min) / (max - min);
        }

        function lerp(norm, min, max) {
            return (max - min) * norm + min;
        }

        function map(value, sourceMin, sourceMax, destMin, destMax) {
            return lerp(norm(value, sourceMin, sourceMax), destMin, destMax);
        }

        function clamp(value, min, max) {
            return MathUtil.min(MathUtil.max(value, min), max);
        }

        function distanceXY(x0, y0, x1, y1) {
            var dx = x0-x1;
            var dy = y0-y1;
            return MathUtil.sqrt(dx*dx + dy*dy);
        }

        function randomRange(min, max) {
            return min + MathUtil.random() * (max - min);
        }

        function randomInt(min, max) {
            return MathUtil.floor(min + MathUtil.random() * (max - min + 1));
        }

        function radsToDegress(radians) {
        return radians * 180 / MathUtil.PI;
        }

        function degreesToRads(degrees) {
        return degrees / 180 * MathUtil.PI;
        }

        function roundToPlaces(value, places) {
            var mult = MathUtil.pow(10, places);
            return MathUtil.round(value * mult) / mult;
        }

        function roundNearest(value, nearest) {
            return MathUtil.round(value / nearest) * nearest;
        }

        function randomDist(min, max, iterations) {
            var total = 0;

            for(var i = 0; i < iterations; i++) {
                total += utils.randomRange(min, max);
            }
            return total / iterations;
        }
        */

    public static int clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }
}
