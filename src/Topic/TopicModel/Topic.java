package Topic.TopicModel;

import Const.Const.*;
import IO.FileWriterReader;
import Topic.TopicModel.Comment;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private int id;
    private static int idCounter;
    private String title;
    private int votes = 0;
    private String username = "nghia";
    private String content;
    private Tag tag;
    private ArrayList<Comment> comments = null;

    public Topic() {
    }

    public Topic(int id, String title, int votes, String username, String content, Tag tag) {
        this.id = id;
        this.title = title;
        this.votes = votes;
        this.username = username;
        this.content = content;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Const.Const.Tag getTag() {
        return tag;
    }

    public void setTag(Const.Const.Tag tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        List<Topic> topicList = FileWriterReader.readFileToListTopic(Path.TOPIC_INPUT_OUTPUT_FILE);
        if (topicList.isEmpty()) {
            idCounter = 0;
        } else {
            idCounter = topicList.get(topicList.size() - 1).getId();
        }
        this.id = ++idCounter;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return id +
                "," + title +
                "," + votes +
                "," + username +
                "," + content +
                "," + tag.toString();
    }
}
