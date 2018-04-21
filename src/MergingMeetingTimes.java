/*
    Problem #4
    Merging Meeting Times
    https://www.interviewcake.com/question/java/merging-ranges

    Method MergeRanges written by me, other code provided by InterviewCake.

    Expected Output:
    (0, 1) (3, 8) (9, 12)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class MergingMeetingTimes {

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        if (meetings == null || meetings.size() < 1) {
            throw new IllegalArgumentException("Bad input");
        }

        meetings.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.getStartTime() - m2.getStartTime();
            }
        });

        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(meetings.get(0));

        // merge meetings ranges
        for (int i=0; i<meetings.size(); i++) {
            Meeting latestMerged = mergedMeetings.get(mergedMeetings.size()-1);
            Meeting curr = meetings.get(i);

            // If the next meeting starts during the latest one, join them.
            if (latestMerged.getEndTime() >= curr.getStartTime()) {
                latestMerged.setEndTime(Math.max(curr.getEndTime(), latestMerged.getEndTime()));
            }
            else {
                mergedMeetings.add(curr);
            }
        }

        return mergedMeetings;
    }

    public static void main(String[] args) {
        Meeting[] meetings = {
                new Meeting(0, 1),
                new Meeting(3, 5),
                new Meeting(4, 8),
                new Meeting(10, 12),
                new Meeting(9, 10)
        };

        List<Meeting> result = mergeRanges(Arrays.asList(meetings));
        for (Meeting meeting: result) {
            System.out.printf("(%d, %d) ", meeting.getStartTime(),
                    meeting.getEndTime());
        }
        System.out.println();
    }
}