package tec.alliance.obj;

import tec.alliance.utils.OverlapPercentUtils;

public class PipeBox {

    private double startingAngle;
    private double endAngle;
    private double startingDistance;
    private double endDistance;

    private PipeBoxPoint pipeBoxPointTopLeft;
    private PipeBoxPoint pipeBoxPointBottomRight;

    private double width;
    private double height;
    private double pipeBoxArea;

    public PipeBox(double startingAngle, double endAngle, double startingDistance, double endDistance) {
        this.startingAngle = startingAngle;
        this.endAngle = endAngle;
        this.startingDistance = startingDistance;
        this.endDistance = endDistance;
        initialBoxPointTopLeft();
        initialBoxPointBottomRight();
    }

    public PipeBox(double startingAngle, double endAngle, double startingDistance,
                   double endDistance, PipeBoxPoint pipeBoxPointTopLeft, PipeBoxPoint pipeBoxPointBottomRight) {
        this.startingAngle = startingAngle;
        this.endAngle = endAngle;
        this.startingDistance = startingDistance;
        this.endDistance = endDistance;
        this.pipeBoxPointTopLeft = pipeBoxPointTopLeft;
        this.pipeBoxPointBottomRight = pipeBoxPointBottomRight;
    }

    public double getStartingAngle() {
        return startingAngle;
    }

    public void setStartingAngle(double startingAngle) {
        this.startingAngle = startingAngle;
    }

    public double getEndAngle() {
        return endAngle;
    }

    public void setEndAngle(double endAngle) {
        this.endAngle = endAngle;
    }

    public double getStartingDistance() {
        return startingDistance;
    }

    public void setStartingDistance(double startingDistance) {
        this.startingDistance = startingDistance;
    }

    public double getEndDistance() {
        return endDistance;
    }

    public void setEndDistance(double endDistance) {
        this.endDistance = endDistance;
    }

    public PipeBoxPoint getPipeBoxPointTopLeft() {
        return pipeBoxPointTopLeft;
    }

    public void setPipeBoxPointTopLeft(PipeBoxPoint pipeBoxPointTopLeft) {
        this.pipeBoxPointTopLeft = pipeBoxPointTopLeft;
    }

    public PipeBoxPoint getPipeBoxPointBottomRight() {
        return pipeBoxPointBottomRight;
    }

    public void setPipeBoxPointBottomRight(PipeBoxPoint pipeBoxPointBottomRight) {
        this.pipeBoxPointBottomRight = pipeBoxPointBottomRight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPipeBoxArea() {
        return pipeBoxArea;
    }

    public void setPipeBoxArea(double pipeBoxArea) {
        this.pipeBoxArea = pipeBoxArea;
    }

    private void initialBoxPointTopLeft() {
        double x = OverlapPercentUtils.calculateXPosition(startingAngle, startingDistance);
        int xPosition = (int) Math.round(x);
        double y = OverlapPercentUtils.calculateYPosition(startingAngle, startingDistance);
        int yPosition = (int) Math.round(y);
        PipeBoxPoint pipeBoxPointTopLeft = new PipeBoxPoint(xPosition, yPosition);
        this.pipeBoxPointTopLeft = pipeBoxPointTopLeft;
    }

    private void initialBoxPointBottomRight() {
        double x = OverlapPercentUtils.calculateXPosition(endAngle, endDistance);
        int xPosition = (int) Math.round(x);
        double y = OverlapPercentUtils.calculateYPosition(endAngle, endDistance);
        int yPosition = (int) Math.round(y);
        PipeBoxPoint pipeBoxPointBottomRight = new PipeBoxPoint(xPosition, yPosition);
        this.pipeBoxPointBottomRight = pipeBoxPointBottomRight;
    }

    public static double ratioOverlapPercentage(PipeBox firstBox, PipeBox secondBox) {
        double result;

        // ratio overlap in percent between box_1 and box_2
        double firstBoxArea = firstBox.getWidth() * firstBox.getHeight();
        double secondBoxArea = secondBox.getWidth() * secondBox.getHeight();

        double partOne    = Math.min(secondBox.getPipeBoxPointBottomRight().getxCoordinate(), firstBox.getPipeBoxPointBottomRight().getxCoordinate());
        double partSecond = Math.max(secondBox.getPipeBoxPointTopLeft().getxCoordinate(), firstBox.getPipeBoxPointTopLeft().getxCoordinate());
        double partThird  = Math.min(secondBox.getPipeBoxPointBottomRight().getyCoordinate(), firstBox.getPipeBoxPointBottomRight().getyCoordinate());
        double partFour   = Math.max(secondBox.getPipeBoxPointTopLeft().getyCoordinate(), firstBox.getPipeBoxPointTopLeft().getyCoordinate());

        double intersectingArea = Math.max(0, partOne - partSecond) * Math.max(0, partThird - partFour);
        double intersectingAreaUnion = firstBoxArea + secondBoxArea - intersectingArea;

        // ratio
        result = intersectingArea / intersectingAreaUnion;
        result *= 100.0; //percentage
        if (result == 0) // It's mean both box overlap together with same topleft and bottomright point
            result = 100;
        return result;
    }
}
