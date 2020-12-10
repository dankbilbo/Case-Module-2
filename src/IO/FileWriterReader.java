package IO;

import Const.Const.*;
import Topic.TopicModel.Topic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWriterReader {
    private static File file = null;
    private static FileWriter fileWriter = null;
    private static FileReader fileReader = null;
    private static BufferedReader bufferedReader = null;

    public static void writeTopicToFile(String path, List<Topic> topics) {
        file = new File(path);
        try {
            file.createNewFile();
            fileWriter = new FileWriter(file);
            for (Topic topic : topics) {
                fileWriter.append(topic.toString());
                fileWriter.append(Regex.NEWLINE);
                fileWriter.flush();
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(Errors.ERROR_IO);
        }
    }

    public static List<Topic> readFileToListTopic(String path) {
        List<Topic> list = new ArrayList<>();
        file = new File(path);
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(Regex.SEMICOLON);
                int id = Integer.parseInt(split[0]);
                String title = split[1];
                int votes = Integer.parseInt(split[2]);
                String username = split[3];
                String content = split[4];
                Tag tag = Tag.valueOf(split[5]);
                Topic topic = new Topic(id, title, votes, username, content, tag);
                list.add(topic);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(Errors.ERROR_IO);
        }
        return list;
    }
}
