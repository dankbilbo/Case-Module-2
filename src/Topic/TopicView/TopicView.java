package Topic.TopicView;

import Const.Const;
import IO.Service;
import Topic.TopicModel.Topic;

import java.util.List;

public class TopicView {
    public void showMainMenu() {
        System.out.println("------MENU------");
        System.out.println("1.Show all topics");
        System.out.println("2.Create new topic");
        System.out.println("3.Search topics");
        System.out.println("4.View a topic");
        System.out.println("5.Update a topic");
        System.out.println("6.Delete a topic");
        System.out.println("7.Sort topics");
        System.out.println("8.Exit");
    }

    public void viewTopics(List<Topic> topics) {
        if (topics.isEmpty()) {
            System.out.println(Const.Message.MESSAGE_NO_THREAD);
            return;
        }
        for (int i = 0; i < 125; i++) {
            System.out.print("-");
        }
        System.out.printf("\n%-25s%-25s%-25s%-25s%-25s%-25s", "| ThreadID", "| Title", "| Votes", "| Username", "| Tag", "|");
        System.out.println();
        for (int i = 0; i < 125; i++) {
            System.out.print("-");
        }
        for (Topic topic : topics) {
            System.out.printf("\n%-25s%-25s%-25s%-25s%-25s%-25s"
                    , "| " + topic.getId()
                    , "| " + topic.getTitle()
                    , "| " + topic.getVotes()
                    , "| " + topic.getUsername()
                    , "| " + topic.getTag().toString()
                    , "|");
        }
        System.out.println();
        for (int i = 0; i < 125; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showTopicInfo(Topic topic) {
        for (int i = 0; i < 122; i++) {
            System.out.print("-");
        }
        System.out.printf("\n%s%-20s%s%-100s%s", "|", "Topic ID  ", ":", " " + topic.getId(), "|");
        System.out.printf("\n%s%-20s%s%-100s%s", "|", "Title  ", ":", " " + topic.getTitle(), "|");
        System.out.printf("\n%s%-20s%s%-100s%s", "|", "Username  ", ":", " " + topic.getUsername(), "|");
        System.out.printf("\n%s%-20s%s%-100s%s", "|", "Tag  ", ":", " " + topic.getTag().toString(), "|");
        System.out.printf("\n%s%-20s%s%-100s%s", "|", "Content  ", ":", " " + topic.getContent(), "|");
        System.out.printf("\n%s%-20s%s%-100s%s", "|", "Votes  ", ":", " " + topic.getVotes(), "|");
        System.out.println();
        for (int i = 0; i < 122; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int inputNumber(String message) {
        return Service.inputNumber(message);
    }

    public String inputString(String message) {
        return Service.inputString(message);
    }
    public void showMessage(String message){
        System.out.println(message);
    }
}
