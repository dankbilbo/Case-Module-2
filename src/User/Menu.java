package User;

import Const.Const;
import Topic.TopicController.TopicController;

import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    static TopicController controller = new TopicController();

    public static void menu() {
        boolean run = true;
        while (run) {
            controller.showMainMenu();
            switch (controller.chooseFunctionsChoice()) {
                case "1":
                    controller.viewAllTopics();
                    break;
                case "2":
                    controller.addTopic();

                    break;
                case "3":
                    switch (controller.chooseSearchChoice()) {
                        case "1":
                            controller.searchTopicsByTitle();
                            break;
                        case "2":
                            controller.searchTopicsByUsername();
                            break;
                        case "3":
                            controller.searchTopicsByTag();
                            break;
                        default:
                            controller.searchTopicByID();
                    }
                    break;
                case "4":
                    controller.viewOneTopic();
                    break;
                case "5":
                    controller.updateTopic();
                    break;
                case "6":
                    controller.deleteTopic();
                    break;
                case "7":
                    switch (controller.chooseSortChoice()) {
                        case "1":
                            controller.sortTopicsByVotes();
                            break;
                        case "2":
                            controller.sortTopicsByTitle();
                            break;
                        case "3":
                            controller.sortTopicsByTag();
                            break;
                        default:
                            controller.viewAllTopics();
                    }
                    break;
                case "8":
                    run = false;
                    controller.writeListToFile();
                    break;
                default:
                    System.out.println(Const.Errors.ERROR_INPUT_MISSMATCH);
                    menu();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
