package Topic.TopicController;

import Const.Const.*;
import IO.Service;
import Topic.TopicModel.Topic;
import Topic.TopicModel.TopicDAOImp;
import Topic.TopicView.View;

import java.util.Comparator;
import java.util.List;

public class Controller implements ControllerInterface {
    TopicDAOImp topicDAOImp;
    View view;

    public Controller() {
        topicDAOImp = new TopicDAOImp();
        view = new View();
    }

    @Override
    public void showMainMenu() {
        view.showMainMenu();
    }

    @Override
    public void viewAllTopics() {
        view.viewTopics(topicDAOImp.getAllTopics());
    }

    @Override
    public void addTopic() {
        Topic topic = new Topic();
        String title = view.inputString(Message.MESSAGE_ENTER_TITLE);
        topic.setTitle(title);
        String choiceTag = view.inputString(Message.MESSAGE_CHOOSE_TAG);
        switch (choiceTag) {
            case "1":
                topic.setTag(Tag.NSFW);
                break;
            case "2":
                topic.setTag(Tag.SFW);
                break;
            case "3":
                topic.setTag(Tag.POLITIC);
                break;
            case "4":
                topic.setTag(Tag.SCIENCE);
                break;
            case "5":
                topic.setTag(Tag.NEWS);
                break;
            case "6":
                topic.setTag(Tag.GAMING);
                break;
            default:
                topic.setTag(Tag.GENERAL);
        }
        String content = Service.inputString(Message.MESSAGE_ENTER_CONTENT);
        topic.setContent(content);
        topic.setId();
        topicDAOImp.addTopic(topic);
        view.viewTopics(topicDAOImp.getAllTopics());
    }

    public String chooseFunctionsChoice() {
        String choiceFunction = view.inputString(Message.MESSAGE_CHOOSE_CHOICE);
        return choiceFunction;
    }

    public String chooseSearchChoice() {
        String choiceSearch = view.inputString(Message.MESSAGE_CHOOSE_SEARCH);
        return choiceSearch;
    }

    public String chooseSortChoice() {
        String choiceSort = view.inputString(Message.MESSAGE_CHOOSE_SORT);
        return choiceSort;
    }

    @Override
    public void searchTopicByID() {
        int idSearch = view.inputNumber(Message.MESSAGE_SEARCH_ID);
        Topic topic = topicDAOImp.getTopic(idSearch);
        view.showTopicInfo(topic);
    }

    @Override
    public void searchTopicsByUsername() {
        String titleSearch = view.inputString(Message.MESSAGE_SEARCH_TITLE);
        view.viewTopics(topicDAOImp.getTopics(titleSearch));
    }

    @Override
    public void searchTopicsByTag() {
        String tagSearch = view.inputString(Message.MESSAGE_SEARCH_TAG);
        view.viewTopics(topicDAOImp.getTopicsByTag(tagSearch));
    }

    @Override
    public void searchTopicsByTitle() {
        String usernameSearch = view.inputString(Message.MESSAGE_SEARCH_USERNAME);
        view.viewTopics(topicDAOImp.getTopicsByUsername(usernameSearch));
    }

    @Override
    public void viewOneTopic() {
        int idSearch = view.inputNumber(Message.MESSAGE_SEARCH_ID);
        Topic topic = topicDAOImp.getTopic(idSearch);
        view.showTopicInfo(topic);
    }

    @Override
    public void updateTopic() {
        int idSearch = view.inputNumber(Message.MESSAGE_SEARCH_ID);
        Topic topic = topicDAOImp.getTopic(idSearch);
        String choice = view.inputString(Message.MESSAGE_CHOOSE_UPDATE);
        switch (choice) {
            case "1":
                topic.setVotes(topic.getVotes() + 1);
                break;
            case "2":
                topic.setVotes(topic.getVotes() - 1);
                break;
            case "3":
                topic.setTitle(view.inputString(Message.MESSAGE_ENTER_NEW_TITLE));
                break;
            case "4":
                topic.setContent(view.inputString(Message.MESSAGE_ENTER_NEW_CONTENT));
                break;
        }
        topicDAOImp.updateTopic(idSearch, topic);
        view.showTopicInfo(topicDAOImp.getTopic(idSearch));
    }

    @Override
    public void deleteTopic() {
        int idSearch = view.inputNumber(Message.MESSAGE_SEARCH_ID);
        topicDAOImp.deleteTopic(idSearch);
    }

    @Override
    public void sortTopicsByVotes() {
        List<Topic> topics = topicDAOImp.getAllTopics();
        topics.sort(Comparator.comparing(Topic::getVotes));
        view.viewTopics(topics);
    }

    @Override
    public void sortTopicsByTitle() {
        List<Topic> topics = topicDAOImp.getAllTopics();
        topics.sort(Comparator.comparing(Topic::getTitle));
        view.viewTopics(topics);
    }

    @Override
    public void sortTopicsByTag() {
        List<Topic> topics = topicDAOImp.getAllTopics();
        topics.sort(new Comparator<Topic>() {
            @Override
            public int compare(Topic o1, Topic o2) {
                if (o1.getTag().toString().equals(o2.getTag().toString())) {
                    return 0;
                } else if (o1.getTag().toString().compareTo(o2.getTag().toString()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public void writeListToFile() {
        topicDAOImp.writeTopicToFile();
    }
}
