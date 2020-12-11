package Const;


public class Const {
    public class Errors {
        public static final String ERROR_IO = "Input/Output Error";
        public static final String ERROR_NO_TOPIC = "//Topic not found process to go back to main menu";
        public static final String ERROR_INPUT_MISSMATCH = "//Input missmatch process to go back to main menu";
    }

    public final class Message {
        public static final String MESSAGE_NO_THREAD = "There is no topic process to go back to main menu";
        public static final String MESSAGE_ENTER_TITLE = "Enter Thread title";
        public static final String MESSAGE_CHOOSE_TAG = "Choose tag 1.NSFW - 2.SFW - 3.POLITIC - 4.NEWS - 5.SIENCE - 6.GAMING - Default.GENERAL";
        public static final String MESSAGE_CHOOSE_UPDATE = "Choose  1.Upvote - 2.Downvote - 3.Change title - 4.Edit content";
        public static final String MESSAGE_ENTER_CONTENT = "Enter Thread content";
        public static final String MESSAGE_CHOOSE_SEARCH = "Search by 1.Search by Title - 2.Search by Tag - 3.Search by Username - Default.Search by ID";
        public static final String MESSAGE_SEARCH_ID = "Search by ID";
        public static final String MESSAGE_SEARCH_USERNAME = "Search by Username";
        public static final String MESSAGE_SEARCH_TAG = "Search by Tag";
        public static final String MESSAGE_SEARCH_TITLE = "Search by Title";
        public static final String MESSAGE_CHOOSE_SORT = "Choose 1.Sort by votes - 2.Sort by title - 3.Sort by tag - Default.Sort by ID";
        public static final String MESSAGE_CHOOSE_CHOICE = "Enter Choice";
        public static final String MESSAGE_ENTER_NEW_TITLE = "Enter new title";
        public static final String MESSAGE_ENTER_NEW_CONTENT = "Enter new content";
    }

    public class Path {
        public static final String TOPIC_INPUT_OUTPUT_FILE = "Thread.csv";
    }

    public class Regex {
        public static final String SEMICOLON = ",";
        public static final String NEWLINE = "\n";
    }

    public enum Role {
        ADMIN, MEMBER
    }

    public enum Tag {
        NSFW, SFW, POLITIC, NEWS, SCIENCE, GAMING, GENERAL
    }
}