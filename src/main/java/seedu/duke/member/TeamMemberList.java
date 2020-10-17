package seedu.duke.member;

import java.util.ArrayList;

public class TeamMemberList {
    protected static ArrayList<TeamMember> memberList = new ArrayList<>();

    public TeamMemberList() {

    }

    public static boolean isMemberPresent(int memberIndex) {
        return memberIndex < memberList.size();
    }

    public static void addTeamMember(String name) {
        TeamMember newMember = new TeamMember(name);
        memberList.add(newMember);
    }

    public static void removeTeamMember(int memberIndex) {
        memberList.remove(memberIndex);
    }

    public static String listTeamMembers() {
        if (memberList.size() == 0) {
            return "No team members have been added.";
        }
        
        String listOfMembers = "";
        int i = 0;
        for (TeamMember member : memberList) {
            String memberLine = (i + 1) + ". " + member.getName() + "\n";
            listOfMembers += memberLine;
            i++;
        }

        return listOfMembers;
    }
}
