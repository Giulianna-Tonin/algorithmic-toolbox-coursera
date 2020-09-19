package week3;

public class CarFueling {

    //950 distancia
    //400 milles


    //400       200        25 + 400
    //0         200         375         550         750         950


//  700
//  200


    //200       100          200        100          200
    //0         100           200         300         400        700

    static int computeMinRefills(int dist, int tank, int[] stops) {
        int refills = 0;
        int init = 0;
        int tankCapacity = tank;

        for (int s = 0; s < stops.length; s++) {
            int thisDist = stops[s] - init;
            tank -= thisDist;

            int nextDist = getNextDist(dist, stops, s);

            if (tank < nextDist) {
                int qtt = tankCapacity - tank;
                tank += qtt;
                refills++;
            }

            if (!isEnough(tank, nextDist)) {
                refills = -1;
                break;
            }

            init = stops[s];
        }

        return refills;
    }

    private static boolean isEnough(int tank, int nextDist) {
        return tank >= nextDist;
    }

    private static int getNextDist(int dist, int[] stops, int s) {
        int next;
        if (s == stops.length - 1) {
            next = dist;
        } else {
            next = stops[s + 1];
        }
        return next - stops[s];
    }


    public static void main(String[] args) {

        int[] stops = {200, 375, 550, 750};
        int[] stops2 = {1, 2, 5, 9};
        int[] stops4 = {100, 200, 300, 400};


        //2
        System.out.println(computeMinRefills(950, 400, stops));

        //-1
        System.out.println(computeMinRefills(10, 3, stops2));

        //2
        System.out.println(computeMinRefills(500, 200, stops4));

        //-1
        System.out.println(computeMinRefills(700, 200, stops4));


    }


}
