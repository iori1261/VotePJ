package model;

import java.util.ArrayList;
import java.util.List;

public class VoteDataBeans {
    private List<EventDataBeans> eventDataBeans;

    public VoteDataBeans() {
        eventDataBeans = new ArrayList<>();
        eventDataBeans.add(new EventDataBeans("両方もっている"));
        eventDataBeans.add(new EventDataBeans("ノートPCだけ"));
        eventDataBeans.add(new EventDataBeans("デスクトップPCだけ"));
        eventDataBeans.add(new EventDataBeans("どちらも持っていない"));
        eventDataBeans.add(new EventDataBeans("持っていない"));
    }

    public void addVote(String eventName) {
        for (EventDataBeans event : eventDataBeans) {
            if (event.getName().equals(eventName)) {
                event.addVote();
                break;
            }
        }
    }

    public List<EventDataBeans> getEventDataBeans() {
        return eventDataBeans;
    }

    public int getTotalVotes() {
        int totalVotes = 0;
        for (EventDataBeans event : eventDataBeans) {
            totalVotes += event.getVoteCount();
        }
        return totalVotes;
    }
}
