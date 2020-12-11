package Topic.TopicModel;

import Const.Const.*;
import IO.FileWriterReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDAOImp implements TopicDAO {
    List<Topic> topics;

    public TopicDAOImp() {
        if (FileWriterReader.readFileToListTopic(Path.TOPIC_INPUT_OUTPUT_FILE) == null) {
            topics = new ArrayList<>();
        } else {
            topics = FileWriterReader.readFileToListTopic(Path.TOPIC_INPUT_OUTPUT_FILE);
        }
    }

    @Override
    public List<Topic> getAllTopics() {
        return topics;
    }

    @Override
    public Topic getTopic(int id) {
        for (Topic topic : topics) {
            if (topic.getId() == id) {
                return topic;
            }
        }
        return null;
    }

    @Override
    public List<Topic> getTopics() {
        return null;
    }

    public List<Topic> getTopics(String title) {
        List<Topic> listGetByTitle
                = topics.stream()
                .filter(topic -> topic.getTitle().contains(title))
                .collect(Collectors.toList());
        return listGetByTitle;
    }

    public List<Topic> getTopicsByUsername(String username) {
        List<Topic> listGetByUsername
                = topics.stream()
                .filter(topic -> topic.getUsername().contains(username))
                .collect(Collectors.toList());
        return listGetByUsername;
    }

    public List<Topic> getTopicsByTag(String tag) {
        List<Topic> listGetByTag
                = topics.stream()
                .filter(topic -> topic.getTag().toString().contains(tag))
                .collect(Collectors.toList());
        return listGetByTag;
    }

    @Override
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    @Override
    public void updateTopic(int id, Topic topic) {
        Topic topicGetbyID = getTopic(id);
        int index = topics.indexOf(topicGetbyID);
        topics.set(index, topic);
    }

    @Override
    public void deleteTopic(int id) {
        Topic topicGetbyID = getTopic(id);
        topics.remove(topicGetbyID);

    }

    @Override
    public void writeTopicToFile() {
        FileWriterReader.writeTopicToFile(Path.TOPIC_INPUT_OUTPUT_FILE, topics);
    }
    public void appendTopicToFile(Topic topic){
        FileWriterReader.writeTopicToFile(Path.TOPIC_INPUT_OUTPUT_FILE,topic);
    }
}
