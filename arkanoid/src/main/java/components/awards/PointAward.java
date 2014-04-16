package components.awards;

public class PointAward extends Award{
    public PointAward(double xPos, double yPos) {
        super(xPos, yPos);
    }

    @Override
    public void giveAware() {
        this.getScene().getScoreBoard().add(200);
    }
}
