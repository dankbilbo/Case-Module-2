package Topic.TopicController;

public interface ControllerInterface {
    public void showMainMenu();
    public void viewAllTopics();
    public void addTopic();
    public void searchTopicByID();
    public void searchTopicsByUsername();
    public void searchTopicsByTitle();
    public void searchTopicsByTag();
    public void viewOneTopic();
    public void updateTopic();
    public void deleteTopic();
    public void sortTopicsByVotes();
    public void sortTopicsByTitle();
    public void sortTopicsByTag();
}
