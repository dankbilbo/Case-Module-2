package Topic.TopicModel;

import Topic.TopicModel.Topic;

import java.util.List;

public interface TopicDAO {
    public List<Topic> getAllTopics();

    public Topic getTopic(int id);

    public List<Topic> getTopics();

    public void addTopic(Topic Topic);

    public void updateTopic(int id, Topic topic);

    public void deleteTopic(int id);

    public void writeTopicToFile();
}
