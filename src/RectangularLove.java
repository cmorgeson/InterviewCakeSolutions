/*
    Problem #6
    Rectangular Love
    https://www.interviewcake.com/question/java/rectangular-love?

    Rectangle class provided by InterviewCake.

    Expected Output:
    5 2 2 2
*/

public class RectangularLove {
    public static class Overlap {

        private int startPoint;
        private int width;

        public Overlap(int startPoint, int width) {
            this.startPoint = startPoint;
            this.width = width;
        }

        public int getStartPoint() {
            return startPoint;
        }

        public int getWidth() {
            return width;
        }
    }

    public static class Rectangle {
        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    public static Overlap findOverlap(int start1, int width1, int start2, int width2) {
        int r1end = start1 + width1;
        int r2end = start2 + width2;
        int maxStart = Math.max(start1, start2);
        int minEnd = Math.min(r1end, r2end);

        if (maxStart >= minEnd) {
            return new Overlap(0,0);
        }

        int overlapWidth = minEnd - maxStart;

        return new Overlap(maxStart, overlapWidth);
    }

    public static Rectangle findIntersection(Rectangle r1, Rectangle r2) {
        if (r1 == null || r2 == null) {
            throw new IllegalArgumentException("Bad input");
        }

        Overlap x = findOverlap(r1.getLeftX(), r1.getWidth(), r2.getLeftX(), r2.getWidth());
        Overlap y = findOverlap(r1.getBottomY(), r1.getHeight(), r2.getBottomY(), r2.getHeight());

        if (x.getWidth() == 0 || y.getWidth() == 0) {
            return new Rectangle(0,0,0,0);
        }

        return new Rectangle(x.getStartPoint(), y.getStartPoint(), x.getWidth(), y.getWidth());
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 1, 6, 3);
        Rectangle r2 = new Rectangle(5, 2, 3, 6);
        Rectangle solution = findIntersection(r1, r2);
        System.out.println(solution.getLeftX() + " " + solution.getBottomY() + " " + solution.getWidth() + " " + solution.getHeight());
    }
}
