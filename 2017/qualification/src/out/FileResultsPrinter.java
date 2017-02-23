package out;


import model.Cache;
import model.Solution;
import model.Video;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileResultsPrinter {

    public void printResults(Solution solution, String fileName){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.append(String.valueOf(solution.getUsedCaches())).append('\n');
            Cache[] caches = solution.filledCaches;
            for (int i = 0; i < caches.length; i++){
                if (caches[i].getVideos().isEmpty()){
                    continue;
                }
                writer.append(String.valueOf(i))
                        .append(' ').
                        append(printVideos(caches[i].getVideos()))
                        .append('\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String printVideos(List<Video> videos) {
        return videos.stream()
                .map(Video::getIndex)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

}
