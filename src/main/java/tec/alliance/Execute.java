package tec.alliance;

import tec.alliance.obj.PipeBox;
import tec.alliance.obj.PipeBoxPoint;

import java.util.Scanner;

public class Execute {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        //System.in is a standard input stream
        Scanner sc= new Scanner(System.in);
        System.out.println("---Enter first PipeBox---");
        System.out.print("Enter starting angle number: ");
        double firstStartingAngle = sc.nextDouble();
        System.out.print("Enter starting distance: ");
        double firstStartingDistance = sc.nextDouble();
        System.out.print("Enter end angle: ");
        double firstEndAngle = sc.nextDouble();
        System.out.print("Enter end distance: ");
        double firstEndDistance = sc.nextDouble();

        System.out.println("---Enter second PipeBox---");
        System.out.print("Enter starting angle number: ");
        double secondStartingAngle = sc.nextDouble();
        System.out.print("Enter starting distance: ");
        double secondStartingDistance = sc.nextDouble();
        System.out.print("Enter end angle: ");
        double secondEndAngle = sc.nextDouble();
        System.out.print("Enter end distance: ");
        double secondEndDistance = sc.nextDouble();

        PipeBox firstBox = new PipeBox(firstStartingAngle, firstEndAngle, firstStartingDistance, firstEndDistance);
        PipeBox secondBox = new PipeBox(secondStartingAngle, secondEndAngle, secondStartingDistance, secondEndDistance);

        // Check and calculate the overlap in percent
        calculateOverlapPercentage(firstBox, secondBox);
    }

    private static void calculateOverlapPercentage(PipeBox firstBox, PipeBox secondBox) {
        boolean overlap = PipeBoxPoint.isBoxOverlap(firstBox, secondBox);

        if (overlap) {
            System.out.println("-----------\nResult: Two Pipe-Box overlap");
            double overlapPercent = PipeBox.ratioOverlapPercentage(firstBox, secondBox);
            System.out.println("Ratio overlap in percent: " + overlapPercent + "%");
        } else {
            System.out.println("-----------\nResult: Two Pipe-Box don't overlap");
            System.out.println("Ratio overlap in percent: 0%");
        }
    }
}
