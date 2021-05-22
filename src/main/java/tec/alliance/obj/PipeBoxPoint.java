package tec.alliance.obj;

import java.awt.*;

public class PipeBoxPoint {

    private int xCoordinate;
    private int yCoordinate;

    public PipeBoxPoint(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    // Returns true if two box (TopLeftBoxPoint_1, BottomRightBoxPoint_1) and (TopLeftBoxPoint_2, BottomRightBoxPoint_2) overlap
    public static boolean isBoxOverlap(PipeBox firstBox, PipeBox secondBox) {

        // Create first Box
        Point firstTopLeftPoint = new Point(firstBox.getPipeBoxPointTopLeft().getxCoordinate(), firstBox.getPipeBoxPointTopLeft().getyCoordinate());
        Point firstBottomRightPoint = new Point(firstBox.getPipeBoxPointBottomRight().getxCoordinate(), firstBox.getPipeBoxPointBottomRight().getyCoordinate());
        Rectangle firstPipeBox = new Rectangle(firstTopLeftPoint);
        firstPipeBox.add(firstBottomRightPoint);

        // Create second Box
        Point secondTopLeftPoint = new Point(secondBox.getPipeBoxPointTopLeft().getxCoordinate(), secondBox.getPipeBoxPointTopLeft().getyCoordinate());
        Point secondBottomRightPoint = new Point(secondBox.getPipeBoxPointBottomRight().getxCoordinate(), secondBox.getPipeBoxPointBottomRight().getyCoordinate());
        Rectangle secondPipeBox = new Rectangle(secondTopLeftPoint);
        secondPipeBox.add(secondBottomRightPoint);

        // Set width and height of Box_1 and Box_2
        firstBox.setWidth(firstPipeBox.getWidth());
        firstBox.setHeight(firstPipeBox.getHeight());

        secondBox.setWidth(secondPipeBox.getWidth());
        secondBox.setHeight(secondPipeBox.getHeight());

        // To check if either pipe-box is actually a line with overlap/ intersects
        if (firstPipeBox.intersects(secondPipeBox))
            return true;

        return false;
    }
}
