package week3;

public class CoveringSegments {


//    private static int[] optimalPoints(Segment[] segments) {
//        //write your code here
//        int[] points = new int[2 * segments.length];
//        for (int i = 0; i < segments.length; i++) {
//            points[2 * i] = segments[i].start;
//            points[2 * i + 1] = segments[i].end;
//        }
//        return points;
//    }
//
//    private static class Segment {
//        int start, end;
//
//        Segment(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//    }
//


    private static int[] optimalPoints(Segment[] segments) {


        //sort seg?

        


        //write your code here
        int[] points = new int[2 * segments.length];
        for (int i = 0; i < segments.length; i++) {
            points[2 * i] = segments[i].start;
            points[2 * i + 1] = segments[i].end;
        }
        return points;
    }



    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        Segment one = new Segment(4,7);
        Segment two = new Segment(1,3);
        Segment tre = new Segment(2,5);
        Segment four = new Segment(5,6);

        Segment[] segments = {one, two, tre, four};

        optimalPoints(segments);

    }





}
