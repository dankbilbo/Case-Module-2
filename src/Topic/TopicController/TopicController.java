package Topic.TopicController;

import Const.Const.*;
import IO.Service;
import Topic.TopicModel.Topic;
import Topic.TopicModel.TopicDAOImp;
import Topic.TopicView.TopicView;

import java.util.*;

public class TopicController implements TopicControllerInterface {
    private TopicDAOImp topicDAOImp;
    private TopicView topicView;

    public TopicController() {
        topicDAOImp = new TopicDAOImp();
        topicView = new TopicView();
    }

    @Override
    public void showMainMenu() {
        topicView.showMainMenu();
    }

    @Override
    public void viewAllTopics() {
        topicView.viewTopics(topicDAOImp.getAllTopics());
    }

    @Override
    public void addTopic() {
        Topic topic = new Topic();
        String title = topicView.inputString(Message.MESSAGE_ENTER_TITLE);
        topic.setTitle(title);
        String choiceTag = topicView.inputString(Message.MESSAGE_CHOOSE_TAG);
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
        topicView.viewTopics(topicDAOImp.getAllTopics());
        topicDAOImp.appendTopicToFile(topic);
    }

    public String chooseFunctionsChoice() {
        String choiceFunction = topicView.inputString(Message.MESSAGE_CHOOSE_CHOICE);
        return choiceFunction;
    }

    public String chooseSearchChoice() {
        String choiceSearch = topicView.inputString(Message.MESSAGE_CHOOSE_SEARCH);
        return choiceSearch;
    }

    public String chooseSortChoice() {
        String choiceSort = topicView.inputString(Message.MESSAGE_CHOOSE_SORT);
        return choiceSort;
    }

    @Override
    public void searchTopicByID() {
        int idSearch = -1;
        try {
            idSearch = topicView.inputNumber(Message.MESSAGE_SEARCH_ID);
        } catch (NumberFormatException e) {
            topicView.showMessage(Errors.ERROR_INPUT_MISSMATCH);
            return;
        }
        Topic topic = topicDAOImp.getTopic(idSearch);
        if (topic == null) {
            topicView.showMessage(Errors.ERROR_NO_TOPIC);
            return;
        }
        topicView.showTopicInfo(topic);
    }

    @Override
    public void searchTopicsByUsername() {
        String titleSearch = topicView.inputString(Message.MESSAGE_SEARCH_TITLE);
        topicView.viewTopics(topicDAOImp.getTopics(titleSearch));
    }

    @Override
    public void searchTopicsByTag() {
        String tagSearch = topicView.inputString(Message.MESSAGE_SEARCH_TAG);
        topicView.viewTopics(topicDAOImp.getTopicsByTag(tagSearch));
    }

    @Override
    public void searchTopicsByTitle() {
        String usernameSearch = topicView.inputString(Message.MESSAGE_SEARCH_USERNAME);
        topicView.viewTopics(topicDAOImp.getTopicsByUsername(usernameSearch));
    }

    @Override
    public void viewOneTopic() {
        int idSearch = -1;
        try {
            idSearch = topicView.inputNumber(Message.MESSAGE_SEARCH_ID);
        } catch (NumberFormatException e) {
            topicView.showMessage(Errors.ERROR_INPUT_MISSMATCH);
            return;
        }
        Topic topic = topicDAOImp.getTopic(idSearch);
        if (topic == null) {
            topicView.showMessage(Errors.ERROR_NO_TOPIC);
            return;
        }
        topicView.showTopicInfo(topic);
    }


    @Override
    public void updateTopic() {
        int idSearch = -1;
        try {
            idSearch = Integer.parseInt(topicView.inputString(Message.MESSAGE_SEARCH_ID));
        } catch (NumberFormatException e) {
            topicView.showMessage(Errors.ERROR_INPUT_MISSMATCH);
            return;
        }
        Topic topic = topicDAOImp.getTopic(idSearch);
        if (topic == null) {
            topicView.showMessage(Errors.ERROR_NO_TOPIC);
            return;
        }
        String choice = topicView.inputString(Message.MESSAGE_CHOOSE_UPDATE);
        switch (choice) {
            case "1":
                topic.setVotes(topic.getVotes() + 1);
                break;
            case "2":
                topic.setVotes(topic.getVotes() - 1);
                break;
            case "3":
                topic.setTitle(topicView.inputString(Message.MESSAGE_ENTER_NEW_TITLE));
                break;
            case "4":
                topic.setContent(topicView.inputString(Message.MESSAGE_ENTER_NEW_CONTENT));
                break;
        }
        topicDAOImp.updateTopic(idSearch, topic);
        topicView.showTopicInfo(topicDAOImp.getTopic(idSearch));
    }

    @Override
    public void deleteTopic() {
        int idSearch = -1;
        try {
            idSearch = topicView.inputNumber(Message.MESSAGE_SEARCH_ID);
        } catch (NumberFormatException e) {
            topicView.showMessage(Errors.ERROR_INPUT_MISSMATCH);
            return;
        }
        Topic topic = topicDAOImp.getTopic(idSearch);
        if (topic == null) {
            topicView.showMessage(Errors.ERROR_NO_TOPIC);
            return;
        }
        topicDAOImp.deleteTopic(idSearch);
        topicView.viewTopics(topicDAOImp.getAllTopics());
    }

    @Override
    public void sortTopicsByVotes() {
        List<Topic> topics = topicDAOImp.getAllTopics();
        List<Topic> newTopics = new ArrayList<>();
        newTopics.addAll(topics);
        newTopics.sort(Comparator.comparing(Topic::getVotes));
        topicView.viewTopics(newTopics);
    }

    @Override
    public void sortTopicsByTitle() {
        List<Topic> topics = topicDAOImp.getAllTopics();
        List<Topic> newTopics = new ArrayList<>();
        newTopics.addAll(topics);
        newTopics.sort(Comparator.comparing(Topic::getTitle));
        topicView.viewTopics(newTopics);
    }

    @Override
    public void sortTopicsByTag() {
        List<Topic> topics = topicDAOImp.getAllTopics();
        List<Topic> newTopics = new ArrayList<>();
        newTopics.addAll(topics);
        newTopics.sort(new Comparator<Topic>() {
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
        topicView.viewTopics(newTopics);
    }

    public void writeListToFile() {
        topicDAOImp.writeTopicToFile();
    }
}
