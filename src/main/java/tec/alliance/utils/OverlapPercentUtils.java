package tec.alliance.utils;

import tec.alliance.obj.PipeBoxPoint;
import java.awt.*;

public class OverlapPercentUtils {

    public static double calculateXPosition(double angle, double distance) {
        // convert angle to radians
        double angleRadians = convertAngleFromDegreeToRadian(angle);
        // calculate x position
        double cosAngle = Math.cos(angleRadians);

        // X = distance * cos(angle)
        // Note: this is an angle and distance from the origin (0,0)
        double xPosition = distance * cosAngle;
        return xPosition;
    }

    public static double calculateYPosition(double angle, double distance) {
        // convert angle to radians
        double angleRadians = convertAngleFromDegreeToRadian(angle);

        // calculate y position
        double sinAngle = Math.sin(angleRadians);

        // Y= distance * sin(angle)
        // Note: this is an angle and distance from the origin (0,0)
        double yPosition = distance * sinAngle;
        return yPosition;
    }

    private static double convertAngleFromDegreeToRadian(double angle) {
        return Math.toRadians(angle);
    }
}
