package model;

public class EventDataBeans {
    private String name;
    private int voteCount;

    public EventDataBeans(String name) {
        this.name = name;
        this.voteCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void addVote() {
        voteCount++;
    }
}
