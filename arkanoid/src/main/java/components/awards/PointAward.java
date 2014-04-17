package components.awards;

public class PointAward extends Award{
    public PointAward(double xPos, double yPos, int limit) {
        super(xPos, yPos, limit);
    }

    @Override
    public void giveAware() {
        this.getScene().getScoreBoard().add(200);
    }
}
